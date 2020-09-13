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

                             ---------------------
                             FBSQL Debug Utilities
                             ---------------------

To use FBSQL Debug Utilities just add <script src="YOUR_FBSQL_SERVER_URL/fbsql-debug.min.js"></script>
declaration to <head> section of your HTML after FBSQL JavaScript client.

E.g:
<script src="http://localhost:8080/fbsql.min.js"></script>
<script src="http://localhost:8080/fbsql-debug.min.js"></script>


This script provide utility functions:

logDatabaseEvents(Connection)                            - Utility function that print out database events
function logExecuteQuery(PreparedStatement, parameters)  - Utility function that execute DQL (Data Query Language) SQL statement and print results
function logExecuteUpdate(PreparedStatement, parameters) - Utility function that execute DML (Data Manipulation Language) SQL statement

------------------------------------------------------------------------------
*/

/*
Minified version of this script 'fbsql-debug.min.js' hosted by FBSQL servlet/server
*/

"use strict";

/**
 * Utility function that print out database events
 */
function logDatabaseEvents(connection) {
	if (!window.WritableStream)
		return;

	connection.addDatabaseEventListener(event => {

		let url = connection.url;
		let username = connection.username;
		let role = connection.role;
		let con = {url: url, user: username, role: role};

		let html = '<small style="float: right; color: Gray">' + new Date().toISOString() + '</small><br>';
		html += 'Connection:<br>' + printJson(con) + '<br><br>';
		html += 'Event:<br>' + printJson(event);

		let div = document.createElement('div');
		div.style = 'font-family: monospace; white-space: pre; border: 1px solid #ccc; margin-bottom: .5rem; padding: .5rem';
		div.innerHTML = html;
		document.body.append(div);
	});
}

/**
 * Execute SQL statement and print results
 * This is internal function, please use logExecuteQuery() or logExecuteUpdate() instead.
 *
 * @param {String} execType   - optional parameters
 * @param {Object} parameters - optional parameters
 */
function logExecute(preparedStatement, execType, parameters) {
	let div = document.createElement('div');
	div.style = 'font-family: monospace; white-space: pre; border: 1px solid #ccc; margin-bottom: .5rem; padding: .5rem';

	document.body.append(div);

	let startTime = performance.now();
	let statementId = preparedStatement.getStatementId();
	let statement = preparedStatement.getStatement();
	let html = '<small style="float: right; color: Gray">' + new Date().toISOString() + '</small><br>'

	let url = preparedStatement.connection.url;
	let username = preparedStatement.connection.username;
	let role = preparedStatement.connection.role;
	let con = {url: url, user: username, role: role};

	html += 'Connection:<br>' + printJson(con) + '<br><br>';

	if (statementId === null)
		html += 'Statement:<br><strong>' + printSql(statement) + '</strong><br><br>';
	else
		html += 'Statement ID: <strong>' + statementId + '</strong><br><br>';

	if (parameters !== undefined)
		html += 'Parameters:<br>' + printJson(parameters) + '<br><br>';
	let promise;
	if (execType === EXEC_TYPE_QUERY)
		promise = preparedStatement.executeQuery(parameters);
	else if (execType === EXEC_TYPE_UPDATE)
		promise = preparedStatement.executeUpdate(parameters);

	html += 'Output format: <span style="color: MediumBlue">';
	if (preparedStatement.format == PreparedStatement.FORMAT_ARRAY_OF_OBJECTS)
		html += 'PreparedStatement.FORMAT_ARRAY_OF_OBJECTS';
	else if (preparedStatement.format == PreparedStatement.FORMAT_ARRAY_OF_ARRAYS)
		html += 'PreparedStatement.FORMAT_ARRAY_OF_ARRAYS';
	else if (preparedStatement.format == PreparedStatement.FORMAT_OBJECT_OF_ARRAYS)
		html += 'PreparedStatement.FORMAT_OBJECT_OF_ARRAYS';
	html += '</span><br><br>';

	if (execType === EXEC_TYPE_QUERY)
		promise
		.then((resultSet) => {
			console.log(resultSet);
			traverse(resultSet, process);
			html += 'Result Set:<br>' + printJson(resultSet) + '<br><br>'
			html += '<span style="color: DarkOrange">' + resultSet.length + '</span> record(s) selected in: <span style="color: DarkOrange">' + ((performance.now() - startTime)) + '</span> ms';
			div.innerHTML = html;
		})
		.catch((error)=> {
			html += 'Error message:<br><span style="color: Red">' + JSON.stringify(error.message, null, '    ') + '</span>';
			div.innerHTML = html;
		})
	else if (execType === EXEC_TYPE_UPDATE)
		promise
		.then((result) => {
			console.log(result);
			let rowCount = Array.isArray(result.rowCount) ? result.rowCount.reduce((a, b) => { return a + b; }, 0) : result.rowCount;
			html += 'Result:<br>' + printJson(result) + '<br><br>'
			html += '<span style="color: DarkOrange">' + rowCount + '</span> record(s) updated in: <span style="color: DarkOrange">' + ((performance.now() - startTime)) + '</span> ms';
			div.innerHTML = html;
		})
		.catch((error)=> {
			html += 'Error message:<br><span style="color: Red">' + JSON.stringify(error.message, null, '    ') + '</span>';
			div.innerHTML = html;
		})
	return promise;
}

/**
 * Utility function that execute DQL (Data Query Language) SQL statement and print results
 * Send GET request
 *
 * SELECT etc.
 *
 * @param {Object} parameters - optional parameters
 */
function logExecuteQuery(preparedStatement, parameters) {
	return logExecute(preparedStatement, EXEC_TYPE_QUERY, parameters);
}

/**
 * Utility function that execute DML (Data Manipulation Language) SQL statement
 * Send POST request
 *
 * INSERT, UPDATE, DELETE etc.
 *
 * @param {Object} parameters - optional parameters
 */
function logExecuteUpdate(preparedStatement, parameters) {
	return logExecute(preparedStatement, EXEC_TYPE_UPDATE, parameters);
}

/**
 * Traverse callback function
 *
 * @param obj
 * @param key
 * @param value
 * @returns
 */
function process(obj, key, value) {
	if (typeof value === 'string' || value instanceof String)
		if (value.startsWith('http:') || value.startsWith('https:') || value.startsWith('data:')) {
			/* <!-- */ value = '<a href=\'' + value + '\'>' + value + '</a>' /* --> */
			obj[key] = value;
		}
}

/**
 * Recursive traverse object
 *
 * @param o
 * @param func
 * @returns
 */
function traverse(o, func) {
    for (var i in o) {
        func.apply(this, [o, i, o[i]]);  
        if (o[i] !== null && typeof(o[i])=="object")
            traverse(o[i], func);
    }
}

/**
 * Replace value with 'colorized' span element
 *
 * @param match
 * @param pIndent
 * @param pKey
 * @param pVal
 * @param pEnd
 * @returns
 *
 * Note: This is modified version from:
 * Pretty Print JSON Data in Color
 * http://jsfiddle.net/unLSJ
 */
function replacer(match, pIndent, pKey, pVal, pEnd) {
	let key             = '<span style="color: Brown">';
	let valString       = '<span style="color: DarkOliveGreen">';
	let valBooleanFalse = '<span style="color: Red">';
	let valBooleanTrue  = '<span style="color: Green">';
	let valNull         = '<span style="color: Gray">';
	let valNumeric      = '<span style="color: DarkOrange">';

	var r = pIndent || '';
	if (pKey)
		r = r + key + pKey.replace(/[": ]/g, '') + '</span>: ';
	if (pVal) {
		if (pVal[0] == '"')
			r = r + valString + pVal + '</span>';
		else if (isDigit(pVal[0]) || pVal[0] === '-')
			r = r + valNumeric + pVal + '</span>';
		else if (pVal === 'true')
			r = r + valBooleanTrue + pVal + '</span>';
		else if (pVal === 'false')
			r = r + valBooleanFalse + pVal + '</span>';
		else if (pVal === 'null')
			r = r + valNull + pVal + '</span>';
	}
	return r + (pEnd || '');
}

/**
 * Print JSON in color
 *
 * @param obj
 * @returns
 *
 * Note: This is modified version from:
 * Pretty Print JSON Data in Color
 * http://jsfiddle.net/unLSJ
 */
function printJson(obj) {
	let jsonLine = /^( *)("[\w-]+": )?("[^"]*"|[\w.+-]*)?([,[{])?$/mg;
	return JSON.stringify(obj, null, 3)
		.replace(/&/g, '&amp;').replace(/\\"/g, '&quot;')
		//.replace(/</g, '&lt;').replace(/>/g, '&gt;')
		.replace(jsonLine, replacer);
}

/**
 * Print SQL in color
 *
 * @param s
 * @returns
 *
 * Note: This is modified version from:
 * https://idiallo.com/blog/javascript-syntax-highlighter
 * How to create a Javascript Syntax highlighter
 * By Ibrahim Diallo
 */
function printSql(s) {
	let regSingleQuotedString = /'(.*?)'/g;
	let regDoubleQuotedString = /"(.*?)"/g;
	let regSQL                = /\b(CREATE|ALL|DATABASE|TABLE|VIEW|INDEX|CONSTRAINT|CHECK|UNIQUE|DISTINCT|EXISTS|KEY|PRIMARY|FOREIGN|DEFAULT|GRANT|REVOKE|PRIVILEGES|USER|ROLE|IDENTIFIED|LEFT|RIGHT|OUTER|INNER|JOIN|FLUSH|DROP|ALTER|WITH|SELECT|CALL|UPDATE|SET|DELETE|INSERT|INTO|VALUES|FROM|WHERE|HAVING|ORDER|BY|GROUP|LIMIT|INNER|OUTER|AS|ON|COUNT|CASE|TO|IF|WHEN|BETWEEN|NOT|AND|OR|IN|NULL|TRUE|FALSE|OBJECT|XML|JSON|TEXT|STRING|CHAR|CHARACTER|VARCHAR|LONGVARCHAR|BINARY|VARBINARY|LONGVARBINARY|LONG|SMALL|SHORT|BIG|NUMBER|INTEGER|FLOAT|DOUBLE|BYTE|WORD|BIT|BOOL|BOOLEAN|DATE|TIME|TIMESTAMP|CURRENT_DATE|CURRENT_TIME|CURRENT_TIMESTAMP|CURRENT_USER)(?=[^\w])/gi;
	let regComment            = /(\/\*.*\*\/)/g;
	let regParameter          = /(:[\w]*)/g;
	let regNumumber           = /((-|\d|\.)[*]*)/g;

	s = s.replace(regSingleQuotedString, "<span class=x_string>'$1'</span>");
	s = s.replace(regDoubleQuotedString, '<span class=x_string>"$1"</span>');
	s = s.replace(regSQL,                '<span class=x_sql>$1</span>');
	s = s.replace(regComment,            '<span class=x_comment>$1</span>');
	s = s.replace(regParameter,          '<span class=x_parameters>$1</span>');
	s = s.replace(regNumumber,           '<span class=x_number>$1</span>');

	s = '<style>.x_parameters {color: Brown;} .x_sql {color: MediumBlue;} .x_comment {color: Gray;} .x_number {color: DarkOrange;} .x_string {color: DarkOliveGreen;}</style>' + s
	return s;
}

function isDigit(c) {
	return c >= '0' && c <= '9';
}

/*
Please contact FBSQL Team by E-Mail fbsql.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
