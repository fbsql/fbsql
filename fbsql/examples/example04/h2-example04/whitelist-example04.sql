/*
File: whitelist.sql

This is a whitelist file.
The whitelist file must be declared in the 'WHITELIST FILE' clause of the 'CONNECT TO' statement in your connection script
E.g.:

CONNECT TO 'jdbc:h2:~/fbsql/data/data;AUTO_SERVER=TRUE;'
    USER 'SA'
    PASSWORD ''
    WHITELIST FILE 'white-list.sql'

If the whitelist file is declared into 'CONNECT TO' statement, only whitelisted entries will be available for execution on the frontend side.
Each whitelist entry can be accessed from the frontend JavaScript client through Connection.prepareStatement(arg) method by specifying the argument (arg) as:

- the SQL statement (E.g.: "SELECT * FROM EMPLOYEES")
- the name prepended with # (E.g.: "#get_all_employees")
- the index in white list prepended with # (E.g.: "#1")

*/

/*
This is an example of a superfast static query (see "(static)" clause after the query name).
Once executed on FBSQL startup query's result set permanently stored in FBSQL memory
and immediately available to clients.
*/
-- #get_countries (static)
SELECT * FROM countries;

-- #get_all_employees
SELECT * FROM employees;

-- #get_employee_by_id
SELECT * FROM employees WHERE EMPLOYEE_ID = :id;

-- #add_new_employee
INSERT INTO employees (FIRST_NAME, DATE_OF_BIRTH) VALUES(:first_name, :date_of_birth);

-- #update_employee
UPDATE employees SET FIRST_NAME = :first_name, DATE_OF_BIRTH = :date_of_birth WHERE EMPLOYEE_ID = :id;

-- #delete_all_employees
DELETE FROM employees;

