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

<h1>FBSQL tutorial</h1>

<h2>Table of Contents</h2>
<a href="#installation_and_basic_example" title="How to install FBSQL, create database connector, use CONNECT TO statement, write simple «Hello, world!» HTML page where we execute query and get data from our backend database.">Basic example</a><br>
<a href="#add_simple_authentication" title="How to add simple authentication and usage of SET ALLOW LOGIN statement.">Authentication</a><br>
<a href="#add_simple_role_based_authorization" title="How to add simple role-based authorization, and usage of SET ALLOW LOGIN statement.">Authorization</a><br>
<a href="#secure_our_backend_with_whitelists" title="How to secure our backend with whitelists with ADD WHITELIST statement.">Whitelists</a><br>
<a href="#reference_statements_by_their_hash" title="How to reference statements by their SHA-256 hash.">Reference statements by their SHA-256 hash</a><br>
<a href="#reference_statements_by_custom_names" title="How to use custom names as statements references.">Reference statements by name</a><br>
<a href="#assign_statements_to_roles" title="How to limit statements by role and/or user with SET ALLOW STATEMENT statement.">Limit statements by role/user</a><br>
<a href="#execute_query_and_execute_update" title="How to execute SQL statements from frontend JavaScript by using executeQuery() and executeUpdate() methods.">Execute SQL statements</a><br>
<a href="#parametrized_statements" title="How to use parametrized statements.">Parametrized statements</a><br>
<a href="#batch_execution" title="How to use batch execution">Batch execution</a><br>
<a href="#reseult_set_format" title="How to receive result set in various formats by using setResultSetFormat() method.">Reseult set formats</a><br>
<a href="#session_management" title="How to manage your sessions (CREATE SESSION and INVALIDATE SESSION statements), access to session information (GET SESSION INFO statement), set and get custom attributes (SET SESSION ATTRIBUTES and GET SESSION ATTRIBUTES statements).">Session management</a><br>
<a href="#cookies_management" title="How to manage your cookies (ADD COOKIES and GET COOKIES statements).">Cookies management</a><br>
<a href="#database_agnostic_stored_procedures" title="How to write and use database agnostic stored procedures written in JavaScript or JVM languages (DECLARE PROCEDURE statement)">Database agnostic stored procedures</a><br>
<a href="#add_database_event_notifier" title="How to add database event notifier (ADD NOTIFIER statement).">Database event notification</a><br>
<a href="#schedule_periodic_jobs" title="How to schedule periodic jobs (SCHEDULE statement).">Schedule periodic jobs</a><br>
<a href="#global_request_validator" title="How to write and use global request validator (SET VALIDATOR statement).">Global request validator</a><br>











<a id="installation_and_basic_example"></a>
<h2>Basic example</h2>
<p><i>
In this chapter we will learn how to install FBSQL, create database connector, use CONNECT TO statement, write simple «Hello, world!» HTML page where we execute query and get data from our backend database.
</i></p>

<strong>Backend:</strong><br>

<ol>
<li>
Install FBSQL:<br><br>
<ul>
<li>Download the latest FBSQL release: <a href="fbsql-1.2-linux-x86-64.zip" title="The latest FBSQL release">fbsql-1.2-linux-x86-64.zip</a></li>
<li>Unzip the downloaded file into some directory</li>
</ul>
<br>
</li>

<li>
Add database instance connector:<br><br>
Assume our database is SQLite. Let's give some name E.g. <code>my-sqlite</code> to our connector.<br><br>
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
</li>

<li>
Start FBSQL server:<br><br>
<ul>
<li>Go to the appropriate subdirectory of the FBSQL installation;</li>
<li>Run the startup command from command line:</li>
</ul>

```sh
./fbsql start
```
</li>
</ol>

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
<h2>Authentication</h2>
<p><i>
In this chapter we will learn how to add simple authentication and usage of SET ALLOW LOGIN statement.
</i></p>

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
<h2>Authorization</h2>
<p><i>
In this chapter we will learn how to add simple role-based authorization, and usage of SET ALLOW LOGIN statement.
</i></p>

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
<h2>Whitelists</h2>
<p><i>
In this chapter we will learn how to secure our backend with whitelists with ADD WHITELIST statement.
</i></p>


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
<p><i>
In this chapter we will learn how to reference statements by their SHA-256 hash.
</i></p>

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
<h2>Reference statements by name</h2>
<p><i>
In this chapter we will learn how to use custom names as statements references.
</i></p>


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
<h2>Limit statements by role/user</h2>
<p><i>
In this chapter we will learn how to limit statements by role and/or user with SET ALLOW STATEMENT statement.
</i></p>

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
<h2>Execute SQL statements</h2>
<p><i>
In this chapter we will learn how to execute SQL statements from frontend JavaScript by using executeQuery() and executeUpdate() methods.
</i></p>

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

            /* Update one record */
            const ps2   = conn.prepareStatement("UPDATE COUNTRIES SET COUNTRY_NAME = 'Federal Republic of Germany' WHERE COUNTRY_ID = 'DE'");


            ps1.executeQuery()
            .then(resultSet => {
                console.log(resultSet);
                /*
                 *   Output:
                 *   
                 *   [
                 *       {
                 *           "COUNTRY_ID": "AU",
                 *           "COUNTRY_NAME": "Australia"
                 *       },
                 *       {
                 *           "COUNTRY_ID": "DE",
                 *           "COUNTRY_NAME": "Germany"
                 *       },
                 *       {
                 *           "COUNTRY_ID": "IN",
                 *           "COUNTRY_NAME": "India"
                 *       }
                 *   ]
                 */
                 return ps2.executeUpdate();
            })
            .then(result => {
                console.log(result);
                /*
                 *   Output:
                 *   
                 *   {
                 *       "rowCount": 1,                                  // one record updated
                 *       "generatedKeys": [
                 *                          {
                 *                              "last_insert_rowid()": 0 // database product specific key names
                 *                          }
                 *                      ]
                 *   }
                 */
                return ps1.executeQuery();
            })
            .then(resultSet => {
                console.log(resultSet);
                /*
                 *   Output:
                 *   
                 *   [
                 *       {
                 *           "COUNTRY_ID": "AU",
                 *           "COUNTRY_NAME": "Australia"
                 *       },
                 *       {
                 *           "COUNTRY_ID": "DE",
                 *           "COUNTRY_NAME": "Federal Republic of Germany"
                 *       },
                 *       {
                 *           "COUNTRY_ID": "IN",
                 *           "COUNTRY_NAME": "India"
                 *       }
                 *   ]
                 */
            });
        </script>
    </body>
</html>
```



<hr>
<a id="parametrized_statements"></a>
<h2>Parametrized statements</h2>
<p><i>
In this chapter we will learn how to use parametrized statements.
</i></p>


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
<p><i>
In this chapter we will learn how to use batch execution.
</i></p>

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
<h2>Reseult set formats</h2>
<p><i>
In this chapter we will learn how to receive result set in various formats by using setResultSetFormat() method.
</i></p>

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
            .then(resultSet => {
                console.log(resultSet);
                /*
                 *   Output:
                 *
                 *   [
                 *       {
                 *           "COUNTRY_ID": "AU",
                 *           "COUNTRY_NAME": "Australia"
                 *       },
                 *       {
                 *           "COUNTRY_ID": "DE",
                 *           "COUNTRY_NAME": "Germany"
                 *       },
                 *       {
                 *           "COUNTRY_ID": "IN",
                 *           "COUNTRY_NAME": "India"
                 *       }
                 *   ]
                 */
                ps1.setResultSetFormat(PreparedStatement.FORMAT_ARRAY_OF_ARRAYS);
                return ps1.executeQuery();
            })
            .then(resultSet => {
                console.log(resultSet);
                /*
                 *   Output:
                 *
                 *   [
                 *       [
                 *           "AU",
                 *           "Australia"
                 *       ],
                 *       [
                 *           "DE",
                 *           "Germany"
                 *       ],
                 *       [
                 *           "IN",
                 *           "India"
                 *       ]
                 *   ]
                 */
                ps1.setResultSetFormat(PreparedStatement.FORMAT_OBJECT_OF_ARRAYS);
                return ps1.executeQuery();
            })
            .then(resultSet => {
                console.log(resultSet);
                /*
                 *   Output:
                 *
                 *   {
                 *       "COUNTRY_ID": [
                 *           "AU",
                 *           "DE",
                 *           "IN",
                 *       ],
                 *       "COUNTRY_NAME": [
                 *           "Australia",
                 *           "Germany",
                 *           "India"
                 *       ]
                 *   }
                 */
            });
        </script>
    </body>
</html>
```
<hr>
<a id="session_management"></a>
<h2>Session management</h2>
<p><i>
In this chapter we will learn how to manage your sessions (CREATE SESSION and INVALIDATE SESSION statements), access to session information (GET SESSION INFO statement), set and get custom attributes (SET SESSION ATTRIBUTES and GET SESSION ATTRIBUTES statements).
</i></p>


<hr>
<a id="cookies_management"></a>
<h2>Cookies management</h2>
<p><i>
In this chapter we will learn how to manage your cookies (ADD COOKIES and GET COOKIES statements).
</i></p>

<hr>
<a id="database_agnostic_stored_procedures"></a>
<h2>Database agnostic stored procedures</h2>
<p><i>
In this chapter we will learn how to write and use database agnostic stored procedures written in JavaScript or <abbr title="Java Virtual Machine">JVM</abbr> languages (DECLARE PROCEDURE statement).
</i></p>
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
<h2>Database event notification</h2>
<p><i>
In this chapter we will learn how  to add database event notifier (ADD NOTIFIER statement).
</i></p>

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
<h2>Schedule periodic jobs</h2>
<p><i>
In this chapter we will learn how to schedule periodic jobs (SCHEDULE statement).
</i></p>

------------------------------------------------------------------------------------------------------

https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html
<div class="block">Date sequence generator for a
<a href="https://www.manpagez.com/man/5/crontab/">Crontab pattern</a>,
allowing clients to specify a pattern that the sequence matches.
<p>The pattern is a list of six single space-separated fields: representing
second, minute, hour, day, month, weekday. Month and weekday names can be
given as the first three letters of the English names.
<p>Example patterns:
<ul>
<li>"0 0 * * * *" = the top of every hour of every day.</li>
<li>"*&#47;10 * * * * *" = every ten seconds.</li>
<li>"0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.</li>
<li>"0 0 6,19 * * *" = 6:00 AM and 7:00 PM every day.</li>
<li>"0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30, 10:00 and 10:30 every day.</li>
<li>"0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays</li>
<li>"0 0 0 25 12 ?" = every Christmas Day at midnight</li>
</ul></div>
------------------------------------------------------------------------------------------------------
http://www.quartz-scheduler.org/documentation/quartz-2.3.0/tutorials/crontrigger.html

<h2 id="introduction">Introduction</h2>

<p><tt>cron</tt> is a UNIX tool that has been around for a long time, so its scheduling capabilities are powerful
and proven. The <tt>CronTrigger</tt> class is based on the scheduling capabilities of cron.</p>

<p><tt>CronTrigger</tt> uses “cron expressions”, which are able to create firing schedules such as: “At 8:00am every
Monday through Friday” or “At 1:30am every last Friday of the month”.</p>

<p>Cron expressions are powerful, but can be pretty confusing. This tutorial aims to take some of the mystery out of
creating a cron expression, giving users a resource which they can visit before having to ask in a forum or mailing
list.</p>

<h2 id="format">Format</h2>

<p>A cron expression is a string comprised of 6 or 7 fields separated by white space. Fields can contain any of the
allowed values, along with various combinations of the allowed special characters for that field. The fields are as
follows:</p>
<table cellpadding="3" cellspacing="1">
    <tbody>
        <tr>
            <th>Field Name</th>
            <th>Mandatory</th>
            <th>Allowed Values</th>
            <th>Allowed Special Characters</th>
        </tr>
        <tr>
            <td>Seconds</td>
            <td>YES</td>
            <td>0-59</td>
            <td>, - * /</td>
        </tr>
        <tr>
            <td>Minutes</td>
            <td>YES</td>
            <td>0-59</td>
            <td>, - * /</td>
        </tr>
        <tr>
            <td>Hours</td>
            <td>YES</td>
            <td>0-23</td>
            <td>, - * /</td>
        </tr>
        <tr>
            <td>Day of month</td>
            <td>YES</td>
            <td>1-31</td>
            <td>, - * ? / L W<br clear="all" />
            </td>
        </tr>
        <tr>
            <td>Month</td>
            <td>YES</td>
            <td>1-12 or JAN-DEC</td>
            <td>, - * /</td>
        </tr>
        <tr>
            <td>Day of week</td>
            <td>YES</td>
            <td>1-7 or SUN-SAT</td>
            <td>, - * ? / L #</td>
        </tr>
        <tr>
            <td>Year</td>
            <td>NO</td>
            <td>empty, 1970-2099</td>
            <td>, - * /</td>
        </tr>
    </tbody>
</table>
<p>So cron expressions can be as simple as this: <tt>* * * * ? *</tt></p>
<p>or more complex, like this: <tt>0/5 14,18,3-39,52 * ? JAN,MAR,SEP MON-FRI 2002-2010</tt></p>

<h2 id="special-characters">Special characters</h2>

<ul>
  <li>
    <p><tt><strong>*</strong></tt> (<em>“all values”</em>) - used to select all values within a field. For example, “<strong>*</strong>”
  in the minute field means <em>“every minute”</em>.</p>
  </li>
  <li>
    <p><tt><strong>?</strong></tt> (<em>“no specific value”</em>) - useful when you need to specify something in one of the
  two fields in which the character is allowed, but not the other. For example, if I want my trigger to fire on a
  particular day of the month (say, the 10th), but don’t care what day of the week that happens to be, I would put
  “10” in the day-of-month field, and “?” in the day-of-week field. See the examples below for clarification.</p>
  </li>
  <li>
    <p><tt><strong>-</strong></tt> - used to specify ranges. For example, “10-12” in the hour field means <em>“the
  hours 10, 11 and 12”</em>.</p>
  </li>
  <li>
    <p><tt><strong>,</strong></tt> - used to specify additional values. For example, “MON,WED,FRI” in the day-of-week
  field means <em>“the days Monday, Wednesday, and Friday”</em>.</p>
  </li>
  <li>
    <p><tt><strong>/</strong></tt> - used to specify increments. For example, “0/15” in the seconds field means <em>“the
  seconds 0, 15, 30, and 45”</em>. And “5/15” in the seconds field means <em>“the seconds 5, 20, 35, and 50”</em>. You can
  also specify ‘/’ after the ‘<strong>’ character - in this case ‘</strong>’ is equivalent to having ‘0’ before the ‘/’. ‘1/3’
  in the day-of-month field means <em>“fire every 3 days starting on the first day of the month”</em>.</p>
  </li>
  <li>
    <p><tt><strong>L</strong></tt> (<em>“last”</em>) - has different meaning in each of the two fields in which it is
  allowed. For example, the value “L” in the day-of-month field means <em>“the last day of the month”</em> - day
  31 for January, day 28 for February on non-leap years. If used in the day-of-week field by itself, it simply means
  “7” or “SAT”. But if used in the day-of-week field after another value, it means <em>“the last xxx day of the
  month”</em> - for example “6L” means <em>“the last friday of the month”</em>. You can also specify an offset
  from the last day of the month, such as “L-3” which would mean the third-to-last day of the calendar month.
  <em>When using the ‘L’ option, it is important not to specify lists, or ranges of values, as you’ll get
  confusing/unexpected results.</em></p>
  </li>
  <li>
    <p><tt><strong>W</strong></tt> (<em>“weekday”</em>) - used to specify the weekday (Monday-Friday) nearest the given day.
  As an example, if you were to specify “15W” as the value for the day-of-month field, the meaning is: <em>“the
  nearest weekday to the 15th of the month”</em>. So if the 15th is a Saturday, the trigger will fire on Friday the 14th.
  If the 15th is a Sunday, the trigger will fire on Monday the 16th. If the 15th is a Tuesday, then it will fire on
  Tuesday the 15th. However if you specify “1W” as the value for day-of-month, and the 1st is a Saturday, the trigger
  will fire on Monday the 3rd, as it will not ‘jump’ over the boundary of a month’s days. The ‘W’ character can only
  be specified when the day-of-month is a single day, not a range or list of days.</p>
  </li>
</ul>
<blockquote>
            The 'L' and 'W' characters can also be combined in the day-of-month field to yield 'LW', which
            translates to *"last weekday of the month"*.
</blockquote>

<ul>
  <li><tt><strong>#</strong></tt> - used to specify “the nth” XXX day of the month. For example, the value of “6#3”
  in the day-of-week field means <em>“the third Friday of the month”</em> (day 6 = Friday and “#3” = the 3rd one in
  the month). Other examples: “2#1” = the first Monday of the month and “4#5” = the fifth Wednesday of the month. Note
  that if you specify “#5” and there is not 5 of the given day-of-week in the month, then no firing will occur that
  month.</li>
</ul>
<blockquote>
            The legal characters and the names of months and days of the week are not case sensitive. <tt>MON</tt>
            is the same as <tt>mon</tt>.
</blockquote>

<h2 id="examples">Examples</h2>

<p>Here are some full examples:</p>
<table cellpadding="3" cellspacing="1">
    <tbody>
        <tr>
            <td width="200">**Expression**</td>
            <td>**Meaning**</td>
        </tr>
        <tr>
            <td><tt>0 0 12 * * ?</tt></td>
            <td>Fire at 12pm (noon) every day</td>
        </tr>
        <tr>
            <td><tt>0 15 10 ? * *</tt></td>
            <td>Fire at 10:15am every day</td>
        </tr>
        <tr>
            <td><tt>0 15 10 * * ?</tt></td>
            <td>Fire at 10:15am every day</td>
        </tr>
        <tr>
            <td><tt>0 15 10 * * ? *</tt></td>
            <td>Fire at 10:15am every day</td>
        </tr>
        <tr>
            <td><tt>0 15 10 * * ? 2005</tt></td>
            <td>Fire at 10:15am every day during the year 2005</td>
        </tr>
        <tr>
            <td><tt>0 * 14 * * ?</tt></td>
            <td>Fire every minute starting at 2pm and ending at 2:59pm, every day</td>
        </tr>
        <tr>
            <td><tt>0 0/5 14 * * ?</tt></td>
            <td>Fire every 5 minutes starting at 2pm and ending at 2:55pm, every day</td>
        </tr>
        <tr>
            <td><tt>0 0/5 14,18 * * ?</tt></td>
            <td>Fire every 5 minutes starting at 2pm and ending at 2:55pm, AND fire every 5
            minutes starting at 6pm and ending at 6:55pm, every day</td>
        </tr>
        <tr>
            <td><tt>0 0-5 14 * * ?</tt></td>
            <td>Fire every minute starting at 2pm and ending at 2:05pm, every day</td>
        </tr>
        <tr>
            <td><tt>0 10,44 14 ? 3 WED</tt></td>
            <td>Fire at 2:10pm and at 2:44pm every Wednesday in the month of March.</td>
        </tr>
        <tr>
            <td><tt>0 15 10 ? * MON-FRI</tt></td>
            <td>Fire at 10:15am every Monday, Tuesday, Wednesday, Thursday and Friday</td>
        </tr>
        <tr>
            <td><tt>0 15 10 15 * ?</tt></td>
            <td>Fire at 10:15am on the 15th day of every month</td>
        </tr>
        <tr>
            <td><tt>0 15 10 L * ?</tt></td>
            <td>Fire at 10:15am on the last day of every month</td>
        </tr>
        <tr>
            <td><tt>0 15 10 L-2 * ?</tt></td>
            <td>Fire at 10:15am on the 2nd-to-last last day of every month</td>
        </tr>
        <tr>
            <td><tt>0 15 10 ? * 6L</tt></td>
            <td>Fire at 10:15am on the last Friday of every month</td>
        </tr>
        <tr>
            <td><tt>0 15 10 ? * 6L</tt></td>
            <td>Fire at 10:15am on the last Friday of every month</td>
        </tr>
        <tr>
            <td><tt>0 15 10 ? * 6L 2002-2005</tt></td>
            <td>Fire at 10:15am on every last friday of every month during the years 2002,
            2003, 2004 and 2005</td>
        </tr>
        <tr>
            <td><tt>0 15 10 ? * 6#3</tt></td>
            <td>Fire at 10:15am on the third Friday of every month</td>
        </tr>
        <tr>
            <td><tt>0 0 12 1/5 * ?</tt></td>
            <td>Fire at 12pm (noon) every 5 days every month, starting on the first day of the
            month.</td>
        </tr>
        <tr>
            <td><tt>0 11 11 11 11 ?</tt></td>
            <td>Fire every November 11th at 11:11am.</td>
        </tr>
    </tbody>
</table>
<blockquote>
        Pay attention to the effects of '?' and '*' in the day-of-week and day-of-month fields!
</blockquote>

<h2 id="notes">Notes</h2>

<ul>
  <li>Support for specifying both a day-of-week and a day-of-month value is not complete (you must currently use
  the ‘?’ character in one of these fields).</li>
  <li>Be careful when setting fire times between the hours of the morning when “daylight savings” changes occur
  in your locale (for US locales, this would typically be the hour before and after 2:00 AM - because the time
  shift can cause a skip or a repeat depending on whether the time moves back or jumps forward.  You may find
  this wikipedia entry helpful in determining the specifics to your locale:<br />
  <a href="https://secure.wikimedia.org/wikipedia/en/wiki/Daylight_saving_time_around_the_world">https://secure.wikimedia.org/wikipedia/en/wiki/Daylight_saving_time_around_the_world</a></li>
</ul>







------------------------------------------------------------------------------------------------------
http://www.quartz-scheduler.org/documentation/quartz-2.3.0/tutorials/tutorial-lesson-06.html

<p>if you need a job-firing schedule that recurs based on calendar-like notions</p>

<p>With SCHEDULE statement, you can specify firing-schedules such as “every Friday at noon”, or “every weekday and 9:30
am”, or even “every 5 minutes between 9:00 am and 10:00 am on every Monday, Wednesday and Friday during January”.</p>

<h3>Cron Expressions</h3>

<p><strong><em>Cron-Expressions</em></strong> are used to configure FBSQL scheduler. Cron-Expressions are strings
that are actually made up of seven sub-expressions, that describe individual details of the schedule. These
sub-expression are separated with white-space, and represent:</p>

<ol>
  <li>Seconds</li>
  <li>Minutes</li>
  <li>Hours</li>
  <li>Day-of-Month</li>
  <li>Month</li>
  <li>Day-of-Week</li>
  <li>Year (optional field)</li>
</ol>

<p>An example of a complete cron-expression is the string <em>“0 0 12 ? * WED”</em> - which means “every
Wednesday at 12:00:00 pm”.</p>

<p>Individual sub-expressions can contain ranges and/or lists. For example, the day of week field in the previous
(which reads “WED”) example could be replaced with “MON-FRI”, “MON,WED,FRI”, or even “MON-WED,SAT”.</p>

<p>Wild-cards (the ‘<em>’ character) can be used to say “every” possible value of this field. Therefore the ‘</em>’
character in the “Month” field of the previous example simply means “every month”. A ‘*’ in the Day-Of-Week field would
therefore obviously mean “every day of the week”.</p>

<p>All of the fields have a set of valid values that can be specified. These values should be fairly obvious - such
as the numbers 0 to 59 for seconds and minutes, and the values 0 to 23 for hours. Day-of-Month can be any value 1-31,
but you need to be careful about how many days are in a given month! Months can be specified as values between 0 and
11, or by using the strings JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV and DEC. Days-of-Week can be specified
as values between 1 and 7 (1 = Sunday) or by using the strings SUN, MON, TUE, WED, THU, FRI and SAT.</p>

<p>The ‘/’ character can be used to specify increments to values. For example, if you put ‘0/15’ in the Minutes
field, it means ‘every 15th minute of the hour, starting at minute zero’. If you used ‘3/20’ in the Minutes field, it
would mean ‘every 20th minute of the hour, starting at minute three’ - or in other words it is the same as specifying
‘3,23,43’ in the Minutes field.  Note the subtlety that “<em>/35” does *not</em> mean “every 35 minutes” - it mean
“every 35th minute of the hour, starting at minute zero” - or in other words the same as specifying ‘0,35’.</p>

<p>The ‘?’ character is allowed for the day-of-month and day-of-week fields. It is used to specify “no specific
value”. This is useful when you need to specify something in one of the two fields, but not the other. See the examples
below for clarification.</p>

<p>The ‘L’ character is allowed for the day-of-month and day-of-week fields. This character is short-hand for
“last”, but it has different meaning in each of the two fields. For example, the value “L” in the day-of-month field
means “the last day of the month” - day 31 for January, day 28 for February on non-leap years. If used in the
day-of-week field by itself, it simply means “7” or “SAT”. But if used in the day-of-week field after another value, it
means “the last xxx day of the month” - for example “6L” or “FRIL” both mean “the last friday of the month”.  You
can also specify an offset from the last day of the month, such as “L-3” which would mean the third-to-last day of the
calendar month. <em>When using the ‘L’ option, it is important not to specify lists, or ranges of values, as you’ll get
confusing/unexpected results.</em></p>

<p>The ‘W’ is used to specify the weekday (Monday-Friday) nearest the given day. As an example, if you were to
specify “15W” as the value for the day-of-month field, the meaning is: “the nearest weekday to the 15th of the month”.</p>

<p>The ‘#’ is used to specify “the nth” XXX weekday of the month. For example, the value of “6#3” or “FRI#3” in the
day-of-week field means “the third Friday of the month”.</p>

<p>Here are a few more examples of expressions and their meanings - you can find even more in the JavaDoc for
org.quartz.CronExpression</p>

<h3>Example Cron Expressions</h3>

<p>Example 1 - an expression to create a trigger that simply fires every 5 minutes</p>

<p>“0 0/5 * * * ?”</p>

<p>Example 2 - an expression to create a trigger that fires every 5 minutes, at 10 seconds after the minute
(i.e. 10:00:10 am, 10:05:10 am, etc.).</p>

<p>“10 0/5 * * * ?”</p>

<p>Example 3 - an expression to create a trigger that fires at 10:30, 11:30, 12:30, and 13:30, on every
Wednesday and Friday.</p>

<p>“0 30 10-13 ? * WED,FRI”</p>

<p>Example 4 - an expression to create a trigger that fires every half hour between the hours of 8 am and 10 am
on the 5th and 20th of every month. Note that the trigger will NOT fire at 10:00 am, just at 8:00, 8:30, 9:00 and 9:30</p>

<p>“0 0/30 8-9 5,20 * ?”</p>

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
<h2>Global request validator</h2>
<p><i>
In this chapter we will learn how to write and use global request validator (SET VALIDATOR statement).
</i></p>

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