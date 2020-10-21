/*!N
MIT License

Copyright (c) 2020 FBSQL Team

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

Home:   https://fbsql.github.io
E-Mail: fbsql.team@gmail.com

------------------------------------------------------------------------------

                            -----------------------
                            FBSQL JavaScript client
                            -----------------------

To use FBSQL just add <script src="YOUR_FBSQL_SERVER_URL/fbsql.min.js"></script>
declaration to <head> section of your HTML.

E.g:
<script src="http://localhost:8080/fbsql.min.js"></script>

------------------------------------------------------------------------------
*/

/*
Minified version of this script 'fbsql.min.js' hosted by FBSQL servlet/server
*/

"use strict";

/**
 * Custom HTTP header to send data with GET method
 * WARNING! This constant used also in Java part
 */
const CUSTOM_HTTP_HEADER_CLIENT_INFO = "X-FB-SQL-Client-Info";
const CUSTOM_HTTP_HEADER_STATEMENT   = "X-FB-SQL-Statement";
const CUSTOM_HTTP_HEADER_ROLE        = "X-FB-SQL-Role";

/**
 * Execute type: query
 * WARNING! This constant used also in Java part
 */
const EXEC_TYPE_QUERY  = 'Q';

/**
 * Execute type: update
 * WARNING! This constant used also in Java part
 */
const EXEC_TYPE_UPDATE = 'U';

class Constants {
	static get FBSQL_REMOTE_USER()                       { return "FBSQL_REMOTE_USER                      "; }
	static get FBSQL_REMOTE_ROLE()                       { return "FBSQL_REMOTE_ROLE                      "; }
	static get FBSQL_REMOTE_SESSION_ID()                 { return "FBSQL_REMOTE_SESSION_ID                "; }
	static get FBSQL_REMOTE_SESSION_CREATION_TIME()      { return "FBSQL_REMOTE_SESSION_CREATION_TIME     "; }
	static get FBSQL_REMOTE_SESSION_LAST_ACCESSED_TIME() { return "FBSQL_REMOTE_SESSION_LAST_ACCESSED_TIME"; }
	static get FBSQL_REMOTE_USER_INFO()                  { return "FBSQL_REMOTE_USER_INFO                 "; }
}

/** 
 * Represents connection (session) with a specific database.
 * This class provide Database Connection layer for client side JavaScript interaction.
 * SQL statements are executed and results are returned within the context of a connection.
 */
class Connection {

	/**
	 * Connection constructor
	 * 
	 * @param {String or URL} url      - database URL or instance name
	 * @param {String}        username - optional username
	 * @param {String}        password - optional password
	 * @param {String}        role     - optional user role
	 */
	constructor(url, username, password, role) {
		this.url = url === undefined ? null : url;

		if (this.url !== null) {
			if (this.url instanceof URL)
				this.url = this.url.href;
			if (!this.url.startsWith('https://') && !this.url.startsWith('http://')) // instance name provided
				this.url = getDbUrl() + this.url;
			if (this.url.endsWith('/'))
				this.url = this.url.substring(0, this.url.length - 1);
		}
		this.username = username === undefined ? null : username;
		this.password = password === undefined ? null : password;
		this.role     = role     === undefined ? null : role;

		this.listeners = [];
	}

	prepareStatement(sql) {
		return new PreparedStatement(this, sql);
	}

	/**
	 * Add database events listener
	 */
	addDatabaseEventListener(listener) {
		let connection = this;

		this.listeners.push(listener);

		if (this.url === null || this.url === undefined)
			return;

		if (!window.WritableStream)
			return;

		let dest = new WritableStream({
			write (json) {
				connection.listeners.forEach(listener => listener(json));
			}
		});

		/**
		 * Fetch options
		 */
		let options = {
			method: 'GET',
			mode: 'cors'
		};

		let headers = new Headers();

		headers.set('Cache-Control', 'no-store');

		// user role (optional)
		if (this.role !== null)
			headers.set(CUSTOM_HTTP_HEADER_ROLE, this.role);

		// authentication (optional)
		if (this.username !== null)
			headers.set('Authorization', 'Basic ' + window.btoa(this.username + ":" + this.password));

		headers.set(CUSTOM_HTTP_HEADER_CLIENT_INFO, window.btoa(unescape(encodeURIComponent(JSON.stringify(getClientInfo(), null, 0)))));

		options['headers'] = headers;

		if (isHttp()) // not 'file://' protocol
			options['credentials'] = 'include';

		fetch(this.url + '/events', options).then(response => {
			response.body
				.pipeThrough(new TextDecoderStream())
				.pipeThrough(splitStream('\n'))
				.pipeThrough(parseJSON())
				.pipeTo(dest);
			})
			.catch(error => console.log(error));
	}

	/**
	 * Fires mock database event
	 */
	fireMockDatabaseEvent(mockEventFunc) {
		let json = mockEventFunc();
		this.listeners.forEach(listener => listener(json));
	}
}

class PreparedStatement {
	static get FORMAT_ARRAY_OF_OBJECTS() { return 0; } // the default
	static get FORMAT_ARRAY_OF_ARRAYS()  { return 1; } // 2D-array (this format may be useful in case you want to hide ResultSet column names from client)
	static get FORMAT_OBJECT_OF_ARRAYS() { return 2; } // pivot (processed on client side)s

	/**
	 * PreparedStatement constructor
	 * 
	 * @param {Connection} con - database connection
	 * @param {String}     arg - SQL statement or
	 *                           zero-based statement index in white list prefixed with '#' character or
	 *                           statement name prefixed with '#' character or
	 *                           DOM Element which textContent property contains SQL statement
	 *
	 * Examples:
	 *
	 * SELECT * FROM employee - SQL statement
	 * #1                     - SQL statement with index = 1 (second in list) in white list
	 * #my                    - SQL statement with name "my"
	 */
	constructor(connection, arg) {
		this.connection = connection;
		this.format = PreparedStatement.FORMAT_ARRAY_OF_OBJECTS;

		if (arg instanceof Element) {
			this.statementId = null;
			this.sql = arg.textContent.trim();
		} else if (arg.trim().charAt(0) === '#') { // name
			this.statementId = arg.trim().substring(1);
			this.sql = '';
		} else { // SQL satement
			this.statementId = null;
			this.sql = arg.trim();
		}
	}

	getStatement() {
		return this.sql;
	}

	getStatementId() {
		return this.statementId;
	}

	/**
	 * Set output format for result set produced by DQL SQL statement
	 *
	 * Supported values:
	 * PreparedStatement.FORMAT_ARRAY_OF_OBJECTS = 0; // the default
	 * PreparedStatement.FORMAT_ARRAY_OF_ARRAYS  = 1; // 2D-array (this format may be useful in case you want to hide ResultSet column names from client)
	 * PreparedStatement.FORMAT_OBJECT_OF_ARRAYS = 2; // pivot (processed on client side)
	 *
	 * @param {Number} format - optional result set output format
	 */
	setResultSetFormat(format) {
		this.format = format;
		return this;
	}

	/**
	 * Set execute mock function
	 */
	setMockFunction(mockFunc) {
		this.mockFunc  = mockFunc;
		return this;
	}

	/**
	 * Execute DQL (Data Query Language) SQL statement
	 * Send GET request
	 *
	 * SELECT etc.
	 *
	 * @param {Object} parameters - optional parameters
	 */
	executeQuery(parameters) {
		return new Promise((resolve, reject) => {
			if (parameters === undefined || parameters == null)
				parameters = {};
			
			for (const [key, value] of Object.entries(parameters))
				if (value instanceof ArrayBuffer)
					parameters[key] = arrayBufferToBase64(value);
				else if (value instanceof Date)
					parameters[key] = value.toISOString();

			if (this.mockFunc === undefined) {
				// NOTE
				// Format PreparedStatement.FORMAT_OBJECT_OF_ARRAYS supported on client side,
				// so we send to server PreparedStatement.FORMAT_ARRAY_OF_OBJECTS and
				// then convert received array of objects to pivoted object of arrays

				let json = {
					statementId: this.statementId,
					execType: EXEC_TYPE_QUERY, // execution type («Q» - query, «U» - update)
					parameters: parameters,
					format: this.format === PreparedStatement.FORMAT_OBJECT_OF_ARRAYS ? PreparedStatement.FORMAT_ARRAY_OF_OBJECTS : this.format
				};
	
	
				/**
				 * Fetch options
				 */
				let options = {
					method: 'GET',
					mode: 'cors',
				};
	
				let body = JSON.stringify(json, null, 0) + '\n' + this.sql;
	
				let headers = new Headers();
				headers.set('Cache-Control', 'no-cache');
				headers.set(CUSTOM_HTTP_HEADER_STATEMENT, window.btoa(unescape(encodeURIComponent(body))));
				headers.set(CUSTOM_HTTP_HEADER_CLIENT_INFO, window.btoa(unescape(encodeURIComponent(JSON.stringify(getClientInfo(), null, 0)))));
	
				// user role (optional)
				if (this.connection.role !== null)
					headers.set(CUSTOM_HTTP_HEADER_ROLE, this.connection.role);
	
				// authentication (optional)
				if (this.connection.username !== null)
					headers.set('Authorization', 'Basic ' + window.btoa(this.connection.username + ":" + this.connection.password));
	
				options['headers'] = headers;
	
				if (isHttp()) // not 'file://' protocol
					options['credentials'] = 'include';
	
				fetch(this.connection.url + '?h='+ MurmurHash3.hashString(body, body.length, 0), options)
				.then(response => response.json())
				.then(data => {
					if (data instanceof Array) {
						if (this.format === PreparedStatement.FORMAT_OBJECT_OF_ARRAYS)
							data = pivot(data);
						resolve(data);
					} else
						reject(data);
				})
				.catch(error => reject(error));
			} else {
				let data = this.mockFunc(this, parameters);
				if (data instanceof Array) {
					if (this.format === PreparedStatement.FORMAT_OBJECT_OF_ARRAYS)
						data = pivot(data);
					resolve(data);
				} else
					reject(data);
			}
		});
	}

	/**
	 * Execute DML (Data Manipulation Language) SQL statement
	 * Send POST request
	 *
	 * INSERT, UPDATE, DELETE etc.
	 *
	 * @param {Object} parameters - optional parameters
	 */
	executeUpdate(parameters) {
		return new Promise((resolve, reject) => {
			if (parameters === undefined || parameters == null)
				parameters = {};

			for (const [key, value] of Object.entries(parameters))
				if (value instanceof ArrayBuffer)
					parameters[key] = arrayBufferToBase64(value);
				else if (value instanceof Date)
					parameters[key] = value.toISOString();

			if (this.mockFunc === undefined) {
				// NOTE
				// To support JDBC PreparedStatement.RETURN_GENERATED_KEYS feature we need format for ResultSet returned by Statement.getGeneratedKeys()
				//
				// Format PreparedStatement.FORMAT_OBJECT_OF_ARRAYS supported on client side,
				// so we send to server PreparedStatement.FORMAT_ARRAY_OF_OBJECTS and
				// then convert received array of objects to pivoted object of arrays
	
				let json = {
					statementId: this.statementId,
					execType: EXEC_TYPE_UPDATE, // execution type («Q» - query, «U» - update)
					parameters: parameters,
					format: this.format === PreparedStatement.FORMAT_OBJECT_OF_ARRAYS ? PreparedStatement.FORMAT_ARRAY_OF_OBJECTS : this.format
				};
	
				/**
				 * Fetch options
				 */
				let options = {
					method: 'POST',
					mode: 'cors',
					body: JSON.stringify(json, null, 0) + '\n' + this.sql
				};
	
				let headers = new Headers();
	
				// user role (optional)
				if (this.connection.role !== null)
					headers.set(CUSTOM_HTTP_HEADER_ROLE, this.connection.role);
				headers.set(CUSTOM_HTTP_HEADER_CLIENT_INFO, window.btoa(unescape(encodeURIComponent(JSON.stringify(getClientInfo(), null, 0)))));
	
				// authentication (optional)
				if (this.connection.username !== null)
					headers.set('Authorization', 'Basic ' + window.btoa(this.connection.username + ":" + this.connection.password));
	
				options['headers'] = headers;
	
				if (isHttp()) // not 'file://' protocol
					options['credentials'] = 'include';
	
				fetch(this.connection.url, options)
				.then(response => response.json())
				.then(data => {
					if (data['message'] !== undefined)
						reject(data);
					else {
						if (this.format === PreparedStatement.FORMAT_OBJECT_OF_ARRAYS)
							data['generatedKeys'] = pivot(data['generatedKeys']);
						resolve(data);
					}
				})
				.catch(error => reject(error));
			} else {
				let data = this.mockFunc(this, parameters);
				if (data['message'] !== undefined)
					reject(data);
				else {
					if (this.format === PreparedStatement.FORMAT_OBJECT_OF_ARRAYS)
						data['generatedKeys'] = pivot(data['generatedKeys']);
					resolve(data);
				}
			}
		});
	}
}

/**
 * Convert ArrayBuffer to Base64 string
 * 
 * @param {ArrayBuffer} arrayBuffer - source
 * @returns Base64 encoded string representation
 */
function arrayBufferToBase64(arrayBuffer) {
	let binary = '';
	let bs = new Uint8Array(arrayBuffer);
    for (let i = 0; i < bs.byteLength; i++)
        binary += String.fromCharCode(bs[i]);
    return window.btoa(binary);
}

/**
 * Pivot transformation
 *
 * @param records - array of objects
 * @returns       - object of arrays
 */
function pivot(records) {
    return records.reduce((result, record) => {
	    for (let key in record) {
		    if (!result[key])
			    result[key] = []
		    result[key].push(record[key])
	    }
	    return result;
    }, Object.create(null));
}

/**
 * Modified version of MurmurHash3 JavaScript implementation
 * The MurmurHash3 algorithm was created by Austin Appleby.  This JavaScript port was authored
 * by whitequark (based on Java port by Yonik Seeley) and is placed into the public domain.
 * The author hereby disclaims copyright to this source code.
 *
 * This algorithm interprets the string as a UTF-16 codepoint sequence, and appends each 16-bit codepoint
 * to the hash independently.
 *
 * See http://github.com/whitequark/murmurhash3-js.
 */
var MurmurHash3 = {
	mul32: function(m, n) {
		var nlo = n & 0xffff;
		var nhi = n - nlo;
		return ((nhi * m | 0) + (nlo * m | 0)) | 0;
	},

	hashString: function(data, len, seed) {
		var c1 = 0xcc9e2d51, c2 = 0x1b873593;

		var h1 = seed;
		var roundedEnd = len & ~0x1;

		for (var i = 0; i < roundedEnd; i += 2) {
			var k1 = data.charCodeAt(i) | (data.charCodeAt(i + 1) << 16);

			k1 = this.mul32(k1, c1);
			k1 = ((k1 & 0x1ffff) << 15) | (k1 >>> 17);  // ROTL32(k1,15);
			k1 = this.mul32(k1, c2);

			h1 ^= k1;
			h1 = ((h1 & 0x7ffff) << 13) | (h1 >>> 19);  // ROTL32(h1,13);
			h1 = (h1 * 5 + 0xe6546b64) | 0;
		}

		if((len % 2) == 1) {
			k1 = data.charCodeAt(roundedEnd);
			k1 = this.mul32(k1, c1);
			k1 = ((k1 & 0x1ffff) << 15) | (k1 >>> 17);  // ROTL32(k1,15);
			k1 = this.mul32(k1, c2);
			h1 ^= k1;
		}

		// finalization
		h1 ^= (len << 1);

		// fmix(h1);
		h1 ^= h1 >>> 16;
		h1  = this.mul32(h1, 0x85ebca6b);
		h1 ^= h1 >>> 13;
		h1  = this.mul32(h1, 0xc2b2ae35);
		h1 ^= h1 >>> 16;

		return h1;
	}
};

/**
 * Split the stream
 * @param {*} splitOn 
 * 
 * Taken from:
 * https://github.com/deanhume/streams
 * MIT License
 */
function splitStream(splitOn) {
    let buffer = '';

    return new TransformStream({
        transform(chunk, controller) {
            buffer += chunk;
            const parts = buffer.split(splitOn);
            parts.slice(0, -1).forEach(part => controller.enqueue(part));
            buffer = parts[parts.length - 1];
        },
        flush(controller) {
            if (buffer)
            	controller.enqueue(buffer);
        }
    });
}

/**
 * Parse the NDJSON results
 * 
 * Taken from:
 * https://github.com/deanhume/streams
 * MIT License
 */
function parseJSON() {
    return new TransformStream({
        transform(chunk, controller) {
            controller.enqueue(JSON.parse(chunk));
        }
    });
}

/**
 * Get parent of all databases instances URL
 *
 * @returns parent of all databases instances URL
 */
function getDbUrl() {
	let script = document.querySelector('script[src$="/fbsql.min.js"],[src$="/fbsql.js"]');
	if (script == null)
		return '';
	let src = script.src;
	let pos = src.lastIndexOf('/');
	src = src.substring(0, pos);
	return src + '/db/'; // Defined in: "servlet-mapping/url-pattern" in web.xml
}

/**
 * Detect WWW protocols HTTP and HTTPS, but not "file:"!
 *
 * @returns true if not 'file://' protocol
 */
function isHttp() {
	let protocol = window.location.protocol;
	return protocol == 'http:' || protocol == 'https:';
	//return true;
}

/**
 * Get client (Browser) information
 * Result of this function is used in CLIENT_INFO() SQL function (See Java code)
 *
 * @returns Client (Browser) information in JSON format
 */
function getClientInfo() {
	return { //
		url:           window.location.href,                             // URI of the page
		referrer:      document.referrer,                                // URI of the page that linked to this page
		timeZone:      Intl.DateTimeFormat().resolvedOptions().timeZone, // Time Zone
		language:      navigator.language,                               // Language
		languages:     navigator.languages,                              // Languages
		userAgent:     navigator.userAgent,                              // User Agent
		onLine:        navigator.onLine,                                 // ON/OFF line flag
		cookieEnabled: navigator.cookieEnabled,                          // Cookie ENABLED/DISABLED flag
		colorDepth:    screen.colorDepth,                                // Color Depth
		screenWidth:   screen.width,                                     // Screen width
		screenHeight:  screen.height,                                    // Screen height
		availWidth:    screen.availWidth,                                // Available width
		availHeight:   screen.availHeight,                               // Available height
		deviceXDPI:    screen.deviceXDPI,                                // Device XDPI
		deviceYDPI:    screen.deviceYDPI                                 // Device YDPI
	};
}

/*
Please contact FBSQL Team by E-Mail fbsql.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
