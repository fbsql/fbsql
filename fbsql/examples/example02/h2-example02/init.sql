/*
File: ~/fbsql/config/db/h2-example02/init.sql

This connector connects H2 database engine (https://www.h2database.com).
Data directory: ~/fbsql/data

To connect the instance locally from external JDBC client use:

URL         : jdbc:h2:~/fbsql/data/data;AUTO_SERVER=TRUE;
User        : SA
Password    : no password required (empty string)
Driver class: org.h2.Driver
Driver JAR  : ~/fbsql/config/tomcat/webapps/ROOT/WEB-INF/lib/h2-1.4.200.jar
*/

/*
 * Connect to our database
 */
CONNECT TO 'jdbc:h2:~/fbsql/data/data;AUTO_SERVER=TRUE;'
    USER 'SA'
    PASSWORD ''
    JAVASCRIPT FILES ('scripts02.js')
    KKKWHITELIST FILES 'whitelist-example02.sql';
/*
 * Authenticaton and authorization
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
 * Authenticate by user and password
 */

/*
SET AUTHORIZE USERS IF EXISTS (
    SELECT TRUE FROM USERS U WHERE USERNAME=:user AND PASSWORD=:password
);
*/

/*
 * Authorize by user, password and role
 */
SET AUTHORIZE USERS IF EXISTS (
    SELECT TRUE FROM USERS U WHERE USERNAME=:user AND PASSWORD=:password AND EXISTS (
        SELECT TRUE FROM USER_ROLES R WHERE U.USERNAME=R.USERNAME AND R.ROLE=:role
    )
);


/*
 * Your application sepcific business logic starts here:
 */

/* Countries table */
DROP TABLE IF EXISTS COUNTRIES;
CREATE TABLE IF NOT EXISTS COUNTRIES (
    COUNTRY_ID   CHAR(2)     NOT NULL PRIMARY KEY,
    COUNTRY_NAME VARCHAR(40) NOT NULL
);

-- Add some records:
INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES('AU', 'Australia');
INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES('DE', 'Germany'  );
INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME) VALUES('IN', 'India'    );

/* Employees table */
DROP TABLE IF EXISTS EMPLOYEES;
CREATE TABLE IF NOT EXISTS EMPLOYEES (
    EMPLOYEE_ID   INTEGER AUTO_INCREMENT,
    FIRST_NAME    VARCHAR(250),
    LAST_NAME     VARCHAR(250),
    DATE_OF_BIRTH DATE,
    AVATAR        VARBINARY,
    PHOTO         BLOB,
    CONSTRAINT EMPLOYEES_PK PRIMARY KEY (EMPLOYEE_ID)
);

-- Add some records:
INSERT INTO EMPLOYEES (FIRST_NAME, LAST_NAME, DATE_OF_BIRTH) VALUES('Javier', 'Gallego', '1974-10-07');
INSERT INTO EMPLOYEES (FIRST_NAME, LAST_NAME, DATE_OF_BIRTH) VALUES('Joanna', 'Chou',    '1973-12-11');
INSERT INTO EMPLOYEES (FIRST_NAME, LAST_NAME, DATE_OF_BIRTH) VALUES('John',   'Monk',    '1970-07-23');

