<h1>FBSQL - Frontend Backend SQL</h1>
Work (secure) with your backend database within HTML<br>

<h3>Features:</h3>
<ul>
	<li>Prepared statements</li>
	<li>Batch execution</li>
	<li>Background jobs</li>
	<li>Events notification</li>
	<li>Promise based JavaScript API</li>
	<li>Out of the box connection pooling</li>
	<li>Automatic session management</li>
	<li>ETag-optimized HTTP communication</li>
	<li>Compressed responses</li>
	<li>Static «warmed up» queries with no database interaction</li>
</ul>

<h3>F.A.Q.</h3>
<ul>
	<li><strong>Q.</strong> What is FBSQL?</li>
	<li><strong>A.</strong> FBSQL is a server that transparently connects your frontend to the remote database.</li>
	<br>
	<li><strong>Q.</strong> Is it really two-tier architecture?</li>
	<li><strong>A.</strong> Well, yes and no. Look at the FBSQL as two-tier architecture with third tier under the hood.</li>
	<br>
	<li><strong>Q.</strong> Is it really possible to implement an entire web application only with SQL and JavaScript/HTML?</li>
	<li><strong>A.</strong> Yes. In addition to full SQL access to underlying database FBSQL provide the set of it's own statements, to cover missing features required for typical web application</li>
	<br>
	<li><strong>Q.</strong> Which features are provided out of the box?</li>
	<li><strong>A.</strong>
	<ul>
		<li>Authentication</li>
		<li>Authorization</li>
		<li>Session management</li>
		<li>Custom request triggers</li>
		<li>Database events notification</li>
		<li>Background job execution</li>
		<li>etc.</li>
	</ul>
	</li>
	<br>
	<li><strong>Q.</strong> Which features are under the hood?</li>
	<li><strong>A.</strong> Connection pooling, ETag-optimized HTTP communication, compressed responses, static «warmed up» queries with no database interaction etc.</li>
	<br>
	<li><strong>Q.</strong> Which databases are supported?</li>
	<li><strong>A.</strong> FBSQL will works with any <abbr title="Java Database Connectivity">JDBC</abbr> compliant databases like SQLite, MySQL, PostgreSQL, Oracle, DB2 etc.</li>
	<br>
</ul>

<h1>Quick tutorial</h1>

<h2>Table of Contents</h2>
<a href="#installation_and_basic_example">Installation and basic example (CONNECT TO)</a><br>
<a href="#add_simple_authentication">Add simple authentication (SET ALLOW LOGIN)</a><br>
<a href="#add_simple_role_based_authorization">Add simple role-based authorization (SET ALLOW LOGIN)</a><br>
<a href="#secure_our_backend_with_whitelists">Secure our backend with whitelists (ADD WHITELIST)</a><br>
<a href="#reference_statements_by_their_hash">Reference statements by their SHA-256 hash</a><br>
<a href="#reference_statements_by_custom_names">Reference statements by custom names</a><br>
<a href="#assign_statements_to_roles">Assign statements to roles (SET ALLOW STATEMENT)</a><br>
<a href="#execute_query_and_execute_update">executeQuery and executeUpdate</a><br>
<a href="#parametrized_statements">Parametrized statements</a><br>
<a href="#batch_execution">Batch execution</a><br>
<a href="#reseult_set_format">Reseult set format (PreparedStatement.setResultSetFormat(format))</a><br>
<a href="#session_management">Session management (CREATE/INVALIDATE SESSION, GET SESSION INFO, SET/GET SESSION ATTRIBUTES)</a><br>
<a href="#cookies_management">Cookies management (ADD COOKIES, GET COOKIES)</a><br>
<a href="#database_agnostic_stored_procedures">Database agnostic stored procedures written in JVM languages (DECLARE PROCEDURE)</a><br>
<a href="#add_database_event_notifier">Add database event notifier (ADD NOTIFIER)</a><br>
<a href="#schedule_periodic_jobs">Schedule periodic jobs (SCHEDULE)</a><br>
<a href="#global_request_validator">Global request validator (SET VALIDATOR)</a><br>











<a id="installation_and_basic_example"></a>
<h2>Installation and basic example (CONNECT TO)</h2>

<strong>Backend:</strong><br>

1) Install FBSQL:<br>
<ul>
<li>Download the latest FBSQL release: <a href="fbsql-1.2-linux-x86-64.zip" title="The latest FBSQL release">fbsql-1.2-linux-x86-64.zip</a></li>
<li>Unzip the downloaded file into some directory</li>
</ul>
<br>
2) Add database connector:<br><br>
Assume our database is SQLite. First of all we need to create database instance connector. Let's give it some name E.g. <code>my-sqlite</code>.
<ul>
<li>Make the connector directory: <code>~/fbsql/config/db/my-sqlite</code></li>
<li>Copy the initialization script <code>init.sql</code> into the connector directory:</li>
</ul>

```sql
/*
 * init.sql
 *
 * Initialization script executes on FBSQL start up,
 * connects to database instance and optionally performs
 * any operations that you want to be executed at start up time
 */

CONNECT TO 'jdbc:sqlite:sample';
```

3) Start FBSQL server:<br>
<ul>
<li>Go to the appropriate subdirectory of the FBSQL installation;</li>
<li>Run the startup command from command line:</li>
</ul>

```sh
fbsql start
```
<strong>Frontend:</strong><br>

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <script src="http://localhost:8080/fbsql.min.js"></script>
    </head>
    <body>
        <script type="text/javascript">
            const conn = new Connection('my-sqlite');
            const ps   = conn.prepareStatement("SELECT 'Hello, World!' AS HELLO");
            ps.executeQuery().then(resultSet => alert(resultSet[0].HELLO));
        </script>
    </body>
</html>
```
<strong>Result:</strong><br><br>
<img src="hello-world-alert.png">

<hr>
<a id="add_simple_authentication"></a>
<h2>Add simple authentication (SET ALLOW LOGIN)</h2>

<strong>Backend:</strong><br>

```sql
/*
 * init.sql
 *
 * Initialization script executes on FBSQL start up,
 * connects to database instance and optionally performs
 * any operations that you want to be executed at start up time
 */

CONNECT TO 'jdbc:sqlite:sample';

/*
 * Authentication. Implement your own authentication logic here!
 */

DROP TABLE IF EXISTS USERS;

CREATE TABLE IF NOT EXISTS USERS (
    USERNAME VARCHAR(15) NOT NULL PRIMARY KEY,
    PASSWORD VARCHAR(15) NOT NULL
);

INSERT INTO USERS (USERNAME, PASSWORD) VALUES('john',  'secret'   );
INSERT INTO USERS (USERNAME, PASSWORD) VALUES('tim',   'secret123');
INSERT INTO USERS (USERNAME, PASSWORD) VALUES('jerry', 'secret456');

/*
 * Authenticate by user and password
 */

SET ALLOW LOGIN IF EXISTS (
    SELECT TRUE FROM USERS U WHERE USERNAME=:user AND PASSWORD=:password
);

```
<strong>Frontend:</strong><br>

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <script src="http://localhost:8080/fbsql.min.js"></script>
    </head>
    <body>
        <script type="text/javascript">
            /* connector name: 'my-sqlite', user: 'john', password: 'secret' */
            const conn = new Connection('my-sqlite', 'john', 'secret');
            const ps   = conn.prepareStatement("SELECT 'Hello, World!' AS HELLO");
            ps.executeQuery().then(resultSet => alert(resultSet[0].HELLO));
        </script>
    </body>
</html>
```
<hr>
<a id="add_simple_role_based_authorization"></a>
<h2>Add simple role-based authorization (SET ALLOW LOGIN)</h2>

<strong>Backend:</strong><br>

```sql
/*
 * init.sql
 *
 * Initialization script executes on FBSQL start up,
 * connects to database instance and optionally performs
 * any operations that you want to be executed at start up time
 */

CONNECT TO 'jdbc:sqlite:sample';

/*
 * Authenticaton and authorization. Implement your own authentication/authorization logic here!
 */

DROP TABLE IF EXISTS USER_ROLES;
DROP TABLE IF EXISTS USERS;

CREATE TABLE IF NOT EXISTS USERS (
    USERNAME VARCHAR(15) NOT NULL PRIMARY KEY,
    PASSWORD VARCHAR(15) NOT NULL
);

INSERT INTO USERS (USERNAME, PASSWORD) VALUES('john',  'secret'   );
INSERT INTO USERS (USERNAME, PASSWORD) VALUES('tim',   'secret123');
INSERT INTO USERS (USERNAME, PASSWORD) VALUES('jerry', 'secret456');

CREATE TABLE IF NOT EXISTS USER_ROLES (
    USERNAME VARCHAR(15) NOT NULL,
    ROLE     VARCHAR(15) NOT NULL,
    PRIMARY KEY (USERNAME, ROLE)
);

INSERT INTO USER_ROLES (USERNAME, ROLE) VALUES('john',  'manager'      );
INSERT INTO USER_ROLES (USERNAME, ROLE) VALUES('tim',   'programmer'   );
INSERT INTO USER_ROLES (USERNAME, ROLE) VALUES('jerry', 'administrator');

/*
 * Authenticate and authorize by user, password and role
 */

SET ALLOW LOGIN IF EXISTS (
    SELECT TRUE FROM USERS U WHERE USERNAME=:user AND PASSWORD=:password AND EXISTS (
        SELECT TRUE FROM USER_ROLES R WHERE U.USERNAME=R.USERNAME AND R.ROLE=:role
    )
);

```
<strong>Frontend:</strong><br>

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <script src="http://localhost:8080/fbsql.min.js"></script>
    </head>
    <body>
        <script type="text/javascript">
            /* connector name: 'my-sqlite', user: 'john', password: 'secret', role: 'manager' */
            const conn = new Connection('my-sqlite', 'john', 'secret', 'manager');
            const ps   = conn.prepareStatement("SELECT 'Hello, World!' AS HELLO");
            ps.executeQuery().then(resultSet => alert(resultSet[0].HELLO));
        </script>
    </body>
</html>
```
<hr>
<a id="secure_our_backend_with_whitelists"></a>
<h2>Secure our backend with whitelists (ADD WHITELIST)</h2>

<strong>Backend:</strong><br>

```sql
/*
 * init.sql
 *
 * Initialization script executes on FBSQL start up,
 * connects to database instance and optionally performs
 * any operations that you want to be executed at start up time
 */

CONNECT TO 'jdbc:sqlite:sample';

ADD WHITELIST 'my-whitelist.sql';

```

```sql
/*
 * my-whitelist.sql
 */

SELECT 'Hello, World!' AS HELLO;

```

<strong>Frontend:</strong><br>

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <script src="http://localhost:8080/fbsql.min.js"></script>
    </head>
    <body>
        <script type="text/javascript">
            const conn = new Connection('my-sqlite'); 

            const ps1 = conn.prepareStatement("SELECT 'Hello, World!' AS HELLO");
            ps1.executeQuery().then(resultSet => alert(resultSet[0].HELLO));

            /* Error! Not in whitelist! */
            const ps2 = conn.prepareStatement("SELECT 'Bye, World!' AS BYE");
            ps2.executeQuery().then(resultSet => alert(resultSet[0].BYE));
        </script>
    </body>
</html>
```
<hr>
<a id="reference_statements_by_their_hash"></a>
<h2>Reference statements by their SHA-256 hash</h2>
FBSQL supports custom statement names in whitelist.<br>
SHA-256 hash is a default statement reference name if no custom name was provided in whitelist:


<strong>Backend:</strong><br>

```sql
/*
 * init.sql
 *
 * Initialization script executes on FBSQL start up,
 * connects to database instance and optionally performs
 * any operations that you want to be executed at start up time
 */

CONNECT TO 'jdbc:sqlite:sample';

ADD WHITELIST 'my-whitelist.sql';

```

```sql
/*
 * my-whitelist.sql
 */

SELECT 'Hello, World!' AS HELLO;

```

<strong>Frontend:</strong><br>

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <script src="http://localhost:8080/fbsql.min.js"></script>
    </head>
    <body>
        <script type="text/javascript">
            const conn = new Connection('my-sqlite'); 

            const ps1 = conn.prepareStatement("SELECT 'Hello, World!' AS HELLO");
            ps1.executeQuery().then(resultSet => alert("First: " + resultSet[0].HELLO));

            /* 
             * Reference SQL statement form whitelist by it SHA-256 hash
             * After each change of statement content SHA-256 references must be recalculated.
             */
            const ps2 = conn.prepareStatement("#bb7df2faf8e72324d1b515078ed2ec961e808940850ddba738cad50a479e1ce0");
            ps2.executeQuery().then(resultSet => alert("Second: " + resultSet[0].HELLO));
        </script>
    </body>
</html>
```
<hr>
<a id="reference_statements_by_custom_names"></a>
<h2>Reference statements by custom names</h2>

<strong>Backend:</strong><br>

```sql
/*
 * init.sql
 *
 * Initialization script executes on FBSQL start up,
 * connects to database instance and optionally performs
 * any operations that you want to be executed at start up time
 */

CONNECT TO 'jdbc:sqlite:sample';

ADD WHITELIST 'my-whitelist.sql';

```

```sql
/*
 * my-whitelist.sql
 */

-- #myHello
SELECT 'Hello, World!' AS HELLO;

```

<strong>Frontend:</strong><br>

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <script src="http://localhost:8080/fbsql.min.js"></script>
    </head>
    <body>
        <script type="text/javascript">
            const conn = new Connection('my-sqlite'); 

            const ps1 = conn.prepareStatement("SELECT 'Hello, World!' AS HELLO");
            ps1.executeQuery().then(resultSet => alert("First: " + resultSet[0].HELLO));

            /* reference SQL statement form whitelist by name */
            const ps2 = conn.prepareStatement("#myHello");
            ps2.executeQuery().then(resultSet => alert("Second: " + resultSet[0].HELLO));
        </script>
    </body>
</html>
```
<hr>
<a id="assign_statements_to_roles"></a>
<h2>Assign statements to roles (SET ALLOW STATEMENT)</h2>
FBSQL supports simple mechanism that helps assign particular SQL statements to specified roles.


<strong>Backend:</strong><br>

```sql
/*
 * init.sql
 *
 * Initialization script executes on FBSQL start up,
 * connects to database instance and optionally performs
 * any operations that you want to be executed at start up time
 */

CONNECT TO 'jdbc:sqlite:sample';

/*
 * Authenticaton and authorization. Implement your own authentication/authorization logic here!
 */

DROP TABLE IF EXISTS USER_ROLES;
DROP TABLE IF EXISTS USERS;

CREATE TABLE IF NOT EXISTS USERS (
    USERNAME VARCHAR(15) NOT NULL PRIMARY KEY,
    PASSWORD VARCHAR(15) NOT NULL
);

INSERT INTO USERS (USERNAME, PASSWORD) VALUES('john',  'secret'   );
INSERT INTO USERS (USERNAME, PASSWORD) VALUES('tim',   'secret123');
INSERT INTO USERS (USERNAME, PASSWORD) VALUES('jerry', 'secret456');

CREATE TABLE IF NOT EXISTS USER_ROLES (
    USERNAME VARCHAR(15) NOT NULL,
    ROLE     VARCHAR(15) NOT NULL,
    PRIMARY KEY (USERNAME, ROLE)
);

INSERT INTO USER_ROLES (USERNAME, ROLE) VALUES('john',  'manager'      );
INSERT INTO USER_ROLES (USERNAME, ROLE) VALUES('tim',   'programmer'   );
INSERT INTO USER_ROLES (USERNAME, ROLE) VALUES('jerry', 'administrator');

CREATE TABLE IF NOT EXISTS STATEMENTS_ROLES (
    STATEMENT VARCHAR(128) NOT NULL,
    ROLE      VARCHAR(15) NOT NULL,
    PRIMARY KEY (STATEMENT, ROLE)
);
INSERT INTO STATEMENTS_ROLES (STATEMENT, ROLE) VALUES('myHello', 'manager');

/*
 * Authenticate and authorize by user, password and role
 */

SET ALLOW LOGIN IF EXISTS (
    SELECT TRUE FROM USERS U WHERE USERNAME=:user AND PASSWORD=:password AND EXISTS (
        SELECT TRUE FROM USER_ROLES R WHERE U.USERNAME=R.USERNAME AND R.ROLE=:role
    )
);

/*
 * Allow particular statements to specified roles
 */
SET ALLOW STATEMENT IF EXISTS (
    SELECT TRUE FROM STATEMENTS_ROLES WHERE STATEMENT=:statement_name AND ROLE=:role
);

```
<strong>Frontend:</strong><br>

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <script src="http://localhost:8080/fbsql.min.js"></script>
    </head>
    <body>
        <script type="text/javascript">
            /* connector name: 'my-sqlite', user: 'john', password: 'secret', role: 'manager' */
            const conn = new Connection('my-sqlite', 'john', 'secret', 'manager');
            const ps   = conn.prepareStatement("SELECT 'Hello, World!' AS HELLO");
            ps.executeQuery().then(resultSet => alert(resultSet[0].HELLO));
        </script>
    </body>
</html>
```
<hr>
<a id="execute_query_and_execute_update"></a>
<h2>executeQuery and executeUpdate</h2>

<strong>Backend:</strong><br>

```sql
/*
 * init.sql
 *
 * Initialization script executes on FBSQL start up,
 * connects to database instance and optionally performs
 * any operations that you want to be executed at start up time
 */

CONNECT TO 'jdbc:sqlite:sample';

DROP TABLE IF EXISTS COUNTRIES;
CREATE TABLE IF NOT EXISTS COUNTRIES (
    COUNTRY_ID   CHAR(2)     NOT NULL PRIMARY KEY,
    COUNTRY_NAME VARCHAR(40) NOT NULL
);

INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES('AU', 'Australia');
INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES('DE', 'Germany'  );
INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES('IN', 'India'    );

```
<strong>Frontend:</strong><br>

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <script src="http://localhost:8080/fbsql.min.js"></script>
    </head>
    <body>
        <script type="text/javascript">
            const conn = new Connection('my-sqlite');

            /* Select all records */
            const ps1   = conn.prepareStatement("SELECT * FROM COUNTRIES");
            ps1.executeQuery()
            .then(resultSet => console.log(resultSet));
            /*
                Output:

                [
                    {
                        COUNTRY_ID: "AU",
                        COUNTRY_NAME: "Australia"
                    },
                    {
                        COUNTRY_ID: "DE",
                        COUNTRY_NAME: "Germany"
                    },
                    {
                        COUNTRY_ID: "IN",
                        COUNTRY_NAME: "India"
                    }
                ]
            */

            /* Add new record */
            const ps2   = conn.prepareStatement("INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES('IT', 'Italy')");
            ps2.executeUpdate()
            .then(result => console.log(result));
        </script>
    </body>
</html>
```
<hr>
<a id="parametrized_statements"></a>
<h2>Parametrized statements</h2>

<strong>Backend:</strong><br>

```sql
/*
 * init.sql
 *
 * Initialization script executes on FBSQL start up,
 * connects to database instance and optionally performs
 * any operations that you want to be executed at start up time
 */

CONNECT TO 'jdbc:sqlite:sample';

DROP TABLE IF EXISTS COUNTRIES;
CREATE TABLE IF NOT EXISTS COUNTRIES (
    COUNTRY_ID   CHAR(2)     NOT NULL PRIMARY KEY,
    COUNTRY_NAME VARCHAR(40) NOT NULL
);

INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES('AU', 'Australia');
INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES('DE', 'Germany'  );
INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES('IN', 'India'    );

```
<strong>Frontend:</strong><br>

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <script src="http://localhost:8080/fbsql.min.js"></script>
    </head>
    <body>
        <script type="text/javascript">
            const conn = new Connection('my-sqlite');
            
            /* add new record */
            const ps   = conn.prepareStatement("INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES(:countryId, :countryName)");
            ps.executeUpdate({countryId: 'IT', countryName: 'Italy'})
            .then(result => alert(`${result.rowCount} records added`));
        </script>
    </body>
</html>
```
<hr>
<a id="batch_execution"></a>
<h2>Batch execution</h2>

<strong>Backend:</strong><br>

```sql
/*
 * init.sql
 *
 * Initialization script executes on FBSQL start up,
 * connects to database instance and optionally performs
 * any operations that you want to be executed at start up time
 */

CONNECT TO 'jdbc:sqlite:sample';

DROP TABLE IF EXISTS COUNTRIES;
CREATE TABLE IF NOT EXISTS COUNTRIES (
    COUNTRY_ID   CHAR(2)     NOT NULL PRIMARY KEY,
    COUNTRY_NAME VARCHAR(40) NOT NULL
);

INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES('AU', 'Australia');
INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES('DE', 'Germany'  );
INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES('IN', 'India'    );

```
<strong>Frontend:</strong><br>

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <script src="http://localhost:8080/fbsql.min.js"></script>
    </head>
    <body>
        <script type="text/javascript">
            const conn = new Connection('my-sqlite');
            
            /* add new records */
            const ps   = conn.prepareStatement("INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES(:countryId, :countryName)");
            ps.executeUpdate(
            	[
            		{countryId: 'IT', countryName: 'Italy'},
            		{countryId: 'ES', countryName: 'Spain'}
            	]
            )
            .then(result => alert(`${result.rowCount} records added`));
        </script>
    </body>
</html>
```
<hr>
<a id="reseult_set_format"></a>
<h2>Reseult set format (PreparedStatement.setResultSetFormat(format))</h2>
You can control the result set format by choosing one from the available formats:

*Available formats:*
<ul>
	<li><code>PreparedStatement.FORMAT_ARRAY_OF_OBJECTS</code><br>Arrays with records as plain JSON objects. The default.</li><br>
	<li><code>PreparedStatement.FORMAT_ARRAY_OF_ARRAYS</code><br>2D-array</li><br>
	<li><code>PreparedStatement.FORMAT_OBJECT_OF_ARRAYS</code><br>Pivot object with column names as keys and arrays of cell values as values</li>
</ul>

<strong>Backend:</strong><br>

```sql
/*
 * init.sql
 *
 * Initialization script executes on FBSQL start up,
 * connects to database instance and optionally performs
 * any operations that you want to be executed at start up time
 */

CONNECT TO 'jdbc:sqlite:sample';

DROP TABLE IF EXISTS COUNTRIES;
CREATE TABLE IF NOT EXISTS COUNTRIES (
    COUNTRY_ID   CHAR(2)     NOT NULL PRIMARY KEY,
    COUNTRY_NAME VARCHAR(40) NOT NULL
);

INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES('AU', 'Australia');
INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES('DE', 'Germany'  );
INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES('IN', 'India'    );

```
<strong>Frontend:</strong><br>

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <script src="http://localhost:8080/fbsql.min.js"></script>
    </head>
    <body>
        <script type="text/javascript">
            const conn = new Connection('my-sqlite');

            const ps1   = conn.prepareStatement("SELECT * FROM COUNTRIES");
            ps1.setResultSetFormat(PreparedStatement.FORMAT_ARRAY_OF_OBJECTS);
            ps1.executeQuery()
            .then(resultSet => console.log(resultSet));
            /*
                Output:

                [
                    {
                        COUNTRY_ID: "AU",
                        COUNTRY_NAME: "Australia"
                    },
                    {
                        COUNTRY_ID: "DE",
                        COUNTRY_NAME: "Germany"
                    },
                    {
                        COUNTRY_ID: "IN",
                        COUNTRY_NAME: "India"
                    }
                ]
            */

            const ps2   = conn.prepareStatement("SELECT * FROM COUNTRIES");
            ps2.setResultSetFormat(PreparedStatement.FORMAT_ARRAY_OF_ARRAYS);
            ps2.executeQuery()
            .then(resultSet => console.log(resultSet));
            /*
                Output:

                [
                    [
                        "AU",
                        "Australia"
                    ],
                    [
                        "DE",
                        "Germany"
                    ],
                    [
                        "IN",
                        "India"
                    ]
                ]
            */

            const ps3   = conn.prepareStatement("SELECT * FROM COUNTRIES");
            ps3.setResultSetFormat(PreparedStatement.FORMAT_OBJECT_OF_ARRAYS);
            ps3.executeQuery()
            .then(resultSet => console.log(resultSet));
            /*
                Output:

                {
                    COUNTRY_ID: [
                        "AU",
                        "DE",
                        "IN",
                    ],
                    COUNTRY_NAME: [
                        "Australia",
                        "Germany",
                        "India"
                    ]
                }
            */

        </script>
    </body>
</html>
```
<hr>
<a id="session_management"></a>
<h2>Session management (CREATE/INVALIDATE SESSION, GET SESSION INFO, SET/GET SESSION ATTRIBUTES)</h2>
<hr>
<a id="cookies_management"></a>
<h2>Cookies management (ADD COOKIES, GET COOKIES)</h2>
<hr>
<a id="database_agnostic_stored_procedures"></a>
<h2>Database agnostic stored procedures written in <abbr title="Java Virtual Machine">JVM</abbr> languages (DECLARE PROCEDURE)</h2>
Procedures can be called from <code>init.sql</code> and/or frontend:

```sql
/*
 * init.sql
 *
 * Initialization script executes on FBSQL start up,
 * connects to database instance and optionally performs
 * any operations that you want to be executed at start up time
 */

CONNECT TO 'jdbc:sqlite:sample';

DECLARE PROCEDURE GET_ITEMS    FOR "org.fbsql.examples.StoredProcedures::getItems";
DECLARE PROCEDURE ADD_NEW_ITEM FOR "org.fbsql.examples.StoredProcedures::addNewItem";

CALL ADD_NEW_ITEM('T-Shirt', 123);

```
<strong>Frontend:</strong><br>

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <script src="http://localhost:8080/fbsql.min.js"></script>
    </head>
    <body>
        <script type="text/javascript">
            const conn = new Connection('my-sqlite');

            const ps   = conn.prepareStatement("CALL GET_ITEMS(:maxPrice)");
            ps.setResultSetFormat(PreparedStatement.FORMAT_ARRAY_OF_OBJECTS);
            ps.executeQuery({maxPrice: 200})
            .then(resultSet => console.log(JSON.stringify(resultSet)));
        </script>
    </body>
</html>
```
<hr>
<a id="add_database_event_notifier"></a>
<h2>Add database event notifier (ADD NOTIFIER)</h2>
<hr>
<strong>Backend:</strong><br>

```sql
/*
 * init.sql
 *
 * Initialization script executes on FBSQL start up,
 * connects to database instance and optionally performs
 * any operations that you want to be executed at start up time
 */

CONNECT TO 'jdbc:sqlite:sample';

DECLARE PROCEDURE MYNOTIFIER FOR "org.fbsql.examples.StoredProcedures::myNotifier";
ADD NOTIFIER MYNOTIFIER TO "add_new_employee";

```
<strong>Frontend:</strong><br>

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <script src="http://localhost:8080/fbsql.min.js"></script>
    </head>
    <body>
        <script type="text/javascript">
            const conn = new Connection('my-sqlite');
            conn.addDatabaseEventListener(event => console.log(event));
        </script>
    </body>
</html>
```
<a id="schedule_periodic_jobs"></a>
<h2>Schedule periodic jobs (SCHEDULE)</h2>
<strong>Backend:</strong><br>

```sql
/*
 * init.sql
 *
 * Initialization script executes on FBSQL start up,
 * connects to database instance and optionally performs
 * any operations that you want to be executed at start up time
 */

CONNECT TO 'jdbc:sqlite:sample';

DECLARE PROCEDURE PERIODICRUN FOR "org.fbsql.examples.StoredProcedures::periodicRun";
SCHEDULE PERIODICRUN AT "0/5 * * * * ?";

```

<hr>
<a id="global_request_validator"></a>
<h2>Global request validator (SET VALIDATOR)</h2>

<strong>Backend:</strong><br>

```sql
/*
 * init.sql
 *
 * Initialization script executes on FBSQL start up,
 * connects to database instance and optionally performs
 * any operations that you want to be executed at start up time
 */

CONNECT TO 'jdbc:sqlite:sample';

DECLARE PROCEDURE MYVALIDATOR FOR "org.fbsql.examples.StoredProcedures::myValidator";
SET VALIDATOR MYVALIDATOR TO "add_new_employee";

DROP TABLE IF EXISTS COUNTRIES;
CREATE TABLE IF NOT EXISTS COUNTRIES (
    COUNTRY_ID   CHAR(2)     NOT NULL PRIMARY KEY,
    COUNTRY_NAME VARCHAR(40) NOT NULL
);

INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES('AU', 'Australia');
INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES('DE', 'Germany'  );
INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES('IN', 'India'    );

```
<strong>Frontend:</strong><br>

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <script src="http://localhost:8080/fbsql.min.js"></script>
    </head>
    <body>
        <script type="text/javascript">
            const conn = new Connection('my-sqlite');
            
            /* add new records */
            const ps   = conn.prepareStatement("INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES(:countryId, :countryName)");
            ps.executeUpdate(
            	[
            		{countryId: 'IT', countryName: 'Italy'},
            		{countryId: 'ES', countryName: 'Spain'},
            	]
            )
            .then(result => alert(`${result.rowCount} records added`));
        </script>
    </body>
</html>
```

<h3>Contacts and support:</h3>
<ul>
	<li>Home: <a href="https://fbsql.github.io" target="_blank">https://fbsql.github.io</a></li>
	<li>E-Mail: <a href="mailto:fbsql.team.team@gmail.com" target="_blank">fbsql.team.team@gmail.com</a></li>
</ul>