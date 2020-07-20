<h1>FBSQL - Frontend Backend SQL</h1>
Work (secure) with your backend database within HTML<br>

<h3>Features</h3>
	<ul>
		<li>Prepared statements</li>
		<li>Batch execution</li>
		<li>Database events notification</li>
		<li>Background jobs</li>
	</ul>	

<h3>F.A.Q.</h3>
<ul>
	<li><strong>Q.</strong> What is FBSQL?</li>
	<li><strong>A.</strong> FBSQL is a server that transparently yet secure connects your frontend to the remote database.</li>
	<br>
	<li><strong>Q.</strong> Is it really two-tier architecture?</li>
	<li><strong>A.</strong> Well, yes and no. Look at the FBSQL as two-tier architecture with third tier under the hood.</li>
	<br>
	<li><strong>Q.</strong> Which databases are supported?</li>
	<li><strong>A.</strong> FBSQL supports any <abbr title="Java Database Connectivity">JDBC</abbr> compliant databases like SQLite, MySQL, PostgreSQL, Oracle, Microsoft SQL Server, IBM Db2 etc.
	All you need is <abbr title="Java Database Connectivity">JDBC</abbr> driver for your database.</li>
	<br>
	<li><strong>Q.</strong> What about performance?</li>
	<li><strong>A.</strong> FBSQL was designed with performance in mind and supports out of the box connection pooling, ETag-optimization, response compression and static queries «warming up» with no interaction with underlying database.</li>
</ul>

<h3>Comparison of FBSQL distributions:</h3>
<table>
<tr>
<th></th><th>FBSQL Servlet</th><th>FBSQL Server</th><th>FBSQL Server Plus</th>
</tr>
<tr>
<td>FBSQL engine (servlet)         </td><td>&check;</td><td>&check;</td><td>&check;</td>
</tr>
<tr>
<td>JavaScript client     </td><td>&check;</td><td>&check;</td><td>&check;</td>
</tr>
<tr>
<td>Java Runtime Environment (JRE)</td><td></td><td>&check;</td><td>&check;</td>
</tr>
<tr>
<td>Servlet container     </td><td></td><td>&check;</td><td>&check;</td>
</tr>
<tr>
<td>Command line interface</td><td></td><td>&check;</td><td>&check;</td>
</tr>
<tr>
<td>Embedded database</td><td></td><td></td><td>&check;</td>
</tr>
</table>

<h1>FBSQL tutorial</h1>

<h2>Table of Contents</h2>
<ul>
<li><a href="#installation_and_basic_example" title="How to install FBSQL, create database connector, use CONNECT TO statement, write simple «Hello, world!» HTML page where we execute query and get data from our backend database.">Basic example</a></li>
<li><a href="#add_simple_authentication" title="How to add simple authentication and usage of SET ALLOW LOGIN statement.">Authentication</a></li>
<li><a href="#add_simple_role_based_authorization" title="How to add simple role-based authorization, and usage of SET ALLOW LOGIN statement.">Authorization</a></li>
<li><a href="#secure_our_backend_with_whitelists" title="How to secure our backend with whitelists with ADD WHITELIST statement.">Whitelists</a></li>
<li><a href="#reference_statements_by_their_hash" title="How to reference statements by their SHA-256 hash.">Reference statements by their SHA-256 hash</a></li>
<li><a href="#reference_statements_by_custom_names" title="How to use custom names as statements references.">Reference statements by name</a></li>
<li><a href="#assign_statements_to_roles" title="How to limit statements by role and/or user with SET ALLOW STATEMENT statement.">Limit statements by role/user</a></li>
<li><a href="#execute_query_and_execute_update" title="How to execute SQL statements from frontend JavaScript by using executeQuery() and executeUpdate() methods.">Execute SQL statements</a></li>
<li><a href="#parametrized_statements" title="How to use parametrized statements.">Parametrized statements</a></li>
<li><a href="#batch_execution" title="How to use batch execution">Batch execution</a></li>
<li><a href="#reseult_set_format" title="How to receive result set in various formats by using setResultSetFormat() method.">Reseult set formats</a></li>
<li><a href="#session_management" title="How to manage your sessions (CREATE SESSION and INVALIDATE SESSION statements), access to session information (GET SESSION INFO statement), set and get custom attributes (SET SESSION ATTRIBUTES and GET SESSION ATTRIBUTES statements).">Session management</a></li>
<li><a href="#cookies_management" title="How to manage your cookies (ADD COOKIES and GET COOKIES statements).">Cookies management</a></li>
<li><a href="#database_agnostic_stored_procedures" title="How to write and use database agnostic stored procedures written in JavaScript or JVM languages (DECLARE PROCEDURE statement)">Database agnostic stored procedures</a></li>
<li><a href="#add_database_event_notifier" title="How to add database event notifier (ADD NOTIFIER statement).">Database event notification</a></li>
<li><a href="#schedule_periodic_jobs" title="How to schedule periodic jobs (SCHEDULE statement).">Schedule periodic jobs</a></li>
<li><a href="#global_request_validator" title="How to write and use global request validator (SET VALIDATOR statement).">Global request validator</a></li>
<li><a href="#warmed_up_queries" title="How to use «warmed up» static queries with no interaction with underlying database.">«warmed up» queries.</a></li>
<li><a href="#blob_type" title="How to work with BLOB type.">BLOB type</a></li>
</ul>










<a id="installation_and_basic_example"></a>
<h2>Basic example</h2>
<h6>In this chapter we will learn how to install FBSQL, create database connector and use CONNECT TO statement. We also write simple «Hello, world!» HTML page which execute query and get data from our backend database.</h6>

<strong>Backend:</strong><br>

The <i>«FBSQL ServerPlus»</i> edition is good point to start, because
it already equipped with set of popular embedded databases and their drivers:
<ul>
	<li>SQLite</li>
	<li>Apache Derby</li>
	<li>H2</li>
	<li>HSQLDB</li>
</ul>
<br>
<ol>
<li>
Install FBSQL:<br><br>
<ul>
<li>Download the latest <i>«FBSQL Server Plus»</i> release: <a href="fbsql-1.2-linux-x86-64.zip" title="The latest «FBSQL Server Plus» release">fbsql-1.2-linux-x86-64.zip</a></li>
<li>Unzip the downloaded file on your machine</li>
</ul>
Expanding the archive yields the following folder structure:<br>

```text

fbsql-server-plus-2.3.4-linux-x86-64 ─┐
                                      ├─ fbsql    - FBSQL Server Plus executable
                                      ├─ README   - Release information 
                                      └─ LICENSES - Third party licenses
```
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
<li>Go to the appropriate subdirectory of the FBSQL installation</li>
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
        <script src="http://localhost:8080/fbsql.min.js" async></script>
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
<blockquote>
FBSQL JavaScript API (client) is self-hosted by FBSQL Server, so we need just place &lt;script&gt; tag with appropriate URL in &lt;head&gt; section of our HTML.
</blockquote>

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
            const ps1 = conn.prepareStatement("SELECT * FROM COUNTRIES");

            /* Update one record */
            const ps2 = conn.prepareStatement("UPDATE COUNTRIES SET COUNTRY_NAME = 'Federal Republic of Germany' WHERE COUNTRY_ID = 'DE'");


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
Procedures can be called from <code>init.sql</code> and/or frontend.<br><br>

<strong>Backend:</strong><br>

```sql
/*
 * init.sql
 */

CONNECT TO 'jdbc:sqlite:sample';

/*
 * Simple stored procedure that extracts employees by condition from mock "database" and return ResultSet
 */
DECLARE PROCEDURE GET_EMPLOYEES FOR "org.fbsql.examples.StoredProcedures::getEmployees";

```
<br>
org.fbsql.examples.StoredProcedures.java

```java
package org.fbsql.examples;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.h2.tools.SimpleResultSet;

public class StoredProcedures {

	/**
	 * Simple stored procedure that extracts employees by condition from mock "database" and return ResultSet
	 *
	 * @param request    javax.servlet.http.HttpServletRequest is mandatory parameter that receive each stored procedure
	 * @param connection java.sql.Connection is mandatory parameter that receive each stored procedure
	 * @param namePrefix Some user defined parameter
	 * @return
	 */
	public static ResultSet getEmployees(HttpServletRequest request, Connection connection, String nameStartsWith) {

		/**
		 * Our "database"
		 */
		Map<Integer, String> employees = new HashMap<>();
		employees.put(123, "John");
		employees.put(152, "Loren");
		employees.put(451, "Lisa");
		employees.put(481, "Ivan");
		employees.put(508, "Donald");
		employees.put(611, "Carlos");
		employees.put(751, "Lora");

		/**
		 * ResultSet
		 */
		SimpleResultSet rs = new SimpleResultSet();
		rs.addColumn("ID",   Types.INTEGER,  10, 0);
		rs.addColumn("NAME", Types.VARCHAR, 255, 0);

		/*
		 * Select data by condition
		 */
		for (Map.Entry<Integer, String> employee : employees.entrySet()) {
			int    id   = employee.getKey();
			String name = employee.getValue();
			if (name.startsWith(nameStartsWith)) // match our condition
				rs.addRow(id, name);
		}
		return rs;
	}
}
```

<strong>Frontend:</strong>

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <script src="http://localhost:8080/fbsql.min.js"></script>
    </head>
    <body>
        <script type="text/javascript">
            const conn = new Connection('my-sqlite');

            const ps   = conn.prepareStatement("CALL GET_EMPLOYEES(:nameStartsWith)");
            ps.executeQuery({nameStartsWith: 'Lor'})
            .then(resultSet => console.log(JSON.stringify(resultSet)));
            /*
             * Output:
             *
             *    [
             *        {
             *            "ID": 152,
             *            "NAME": "Loren"
             *        },
             *        {
             *            "ID": 751,
             *            "NAME": "Lora"
             *        }
             *    ]
             */
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
Most of information here was taken from <a href="http://www.quartz-scheduler.org/documentation/quartz-2.3.0/tutorials/crontrigger.html">Cron Trigger Tutorial</a>

</i></p>

FBSQL has own scheduler to run periodic jobs. Stored procedures can be scheduled to run according <strong>cron</strong> expression.

<p><a href="https://en.wikipedia.org/wiki/Cron" title="Article from wikipedia.org">cron</a> is a UNIX tool that has been around for a long time, so its scheduling capabilities are powerful
and proven.</p>
<p>SCHEDULE statement uses cron expressions, which are able to create firing schedules such as: “At 8:00am every
Monday through Friday” or “At 1:30am every last Friday of the month”.</p>

<h3>Format</h3>

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

<h3>Special characters</h3>

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

<h3>Notes</h3>

<ul>
  <li>Support for specifying both a day-of-week and a day-of-month value is not complete (you must currently use
  the ‘?’ character in one of these fields).</li>
  <li>Be careful when setting fire times between the hours of the morning when “daylight savings” changes occur
  in your locale (for US locales, this would typically be the hour before and after 2:00 AM - because the time
  shift can cause a skip or a repeat depending on whether the time moves back or jumps forward.  You may find
  this wikipedia entry helpful in determining the specifics to your locale:<br />
  <a href="https://secure.wikimedia.org/wikipedia/en/wiki/Daylight_saving_time_around_the_world">https://secure.wikimedia.org/wikipedia/en/wiki/Daylight_saving_time_around_the_world</a></li>
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
<hr>
<a id="blob_type"></a>
<h2>BLOB type</h2>
<p><i>
In this chapter we will learn how to work with BLOB type.
</i></p>

<strong>Backend:</strong><br>

```sql
CONNECT TO 'jdbc:sqlite:sample';

DROP TABLE IF EXISTS COUNTRIES;
CREATE TABLE IF NOT EXISTS COUNTRIES (
    COUNTRY_ID   CHAR(2)     NOT NULL PRIMARY KEY,
    COUNTRY_NAME VARCHAR(40) NOT NULL,
    COUNTRY_FLAG BLOB
);

/* image taken from wikipedia.org https://en.wikipedia.org/wiki/Australia */
INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME, COUNTRY_FLAG) VALUES('AU', 'Australia', 'data:image/png;base64,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');

```
<strong>Frontend:</strong><br>

```html

<!DOCTYPE html>
<html lang="en">
    <head>
        <script src="http://localhost:8080/fbsql.min.js"></script>

        <style type="text/css">
            div {
                width: 400px;
                border: 1px solid #999999;
                border-radius: 3px;
                padding: 10px;
                margin-bottom: 10px;
            }

            img {
                border: 1px solid #cccccc;
                width: 100%;
                margin-bottom: 10px;
            }

            button {
                border: none;
                color: #ffffff;
                background-color: #4CAF50;
                padding: 10px 32px;
                text-align: center;
                font-size: 1rem;
            }
        </style>
    </head>

    <body>
        <div>
            <img id="myImage">
            <label for="myInput">Select new image:</label>
            <input id="myInput" type="file" accept="image/*">
        </div>
        <button id="btnSave">Save</button>

        <script type="text/javascript">
            let myImage = document.getElementById("myImage");
            let myInput = document.getElementById("myInput");
            let btnSave = document.getElementById('btnSave');

            const conn = new Connection('my-sqlite');
            let psSelect = conn.prepareStatement("SELECT COUNTRY_FLAG FROM COUNTRIES WHERE COUNTRY_ID = 'AU'");
            let psUpdate = conn.prepareStatement("UPDATE COUNTRIES SET COUNTRY_FLAG = :country_flag WHERE COUNTRY_ID = 'AU'");

            /* Load image from database */
            psSelect.executeQuery()
            .then(resultSet => {
                myImage.src = resultSet[0].COUNTRY_FLAG;
            });

            /* Select new image */
            myInput.onchange = function(event) {
                var input = event.target;
                var reader = new FileReader();
                reader.onload = function() {
                    //let arrayBuffer = arrayBufferToBase64(reader.result); // BINARY
                    myImage.src = reader.result;;
                };
                //reader.readAsArrayBuffer(input.files[0]); // BINARY
                reader.readAsDataURL(input.files[0]);
            };

            /* Store image in the database as BLOB */
            btnSave.onclick = function() {
            	psUpdate.executeUpdate({country_flag: myImage.src})
                .then(result => {
                    alert("Image stored in database as BLOB.");
                });
            };
        </script>
    </body>
</html>
```
<h3>Contacts and support:</h3>
<ul>
	<li>Home: <a href="https://fbsql.github.io" target="_blank">https://fbsql.github.io</a></li>
	<li>E-Mail: <a href="mailto:fbsql.team.team@gmail.com" target="_blank">fbsql.team.team@gmail.com</a></li>
</ul>