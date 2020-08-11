grammar Fbsql;

/*
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


Some code was copied from Bart Kiers project (see code comments):
Project : sqlite-parser; an ANTLR4 grammar for SQLite (The MIT License) 2014
URI     : https://github.com/bkiers/sqlite-parser
Mail    : bart@big-o.nl <Bart Kiers>


Home:   https://fbsql.github.io
E-Mail: fbsql.team.team@gmail.com
*/

@header
{
/*
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
E-Mail: fbsql.team.team@gmail.com
*/

package org.fbsql.antlr4.generated;
}

/* keywords */

EXPOSE      : E X P O S E;
STATIC      : S T A T I C;
ROLES       : R O L E S;
TRIGGER     : T R I G G E R;
BEFORE      : B E F O R E;
AFTER       : A F T E R;
AS          : A S;
NO          : N O;
COMPRESSION : C O M P R E S S I O N;
NONE        : N O N E;
BEST        : B E S T;
SPEED       : S P E E D;

DECLARE     : D E C L A R E;
PROCEDURE   : P R O C E D U R E;
FOR         : F O R;
STATEMENT   : S T A T E M E N T;

CONNECT     : C O N N E C T;
TO          : T O;
USER        : U S E R;
PASSWORD    : P A S S W O R D;
PROPERTIES  : P R O  P E R T I E S;
DRIVER      : D R I V E R;
LIB         : L I B;
CONNECTION  : C O N N E C T I O N;
POOL        : P O O L;
SIZE        : S I Z E;
MIN         : M I N;
MAX         : M A X;
UNDECLARED  : U N D E C L A R E D;
STATEMENTS  : S T A T E M E N T S;
INCOMING    : I N C O M I N G;
CONNECTIONS : C O N N E C T I O N S;
ALLOW       : A L L O W;
REJECT      : R E J E C T;
IF          : I F;
EXISTS      : E X I S T S;

SWITCH      : S W I T C H;

SCHEDULE    : S C H E D U L E;
AT          : A T;

INCLUDE     : I N C L U D E;
FILE        : F I L E;

native_sql
 : .*?
 ;

role_name
 : IDENTIFIER
 | STRING_LITERAL
 ;

trigger_before_procedure_name
 : IDENTIFIER
 ;

trigger_after_procedure_name
 : IDENTIFIER
 ;

compression_level
 : NO COMPRESSION
 | BEST COMPRESSION
 | BEST SPEED
 ;

connection_alias
 : IDENTIFIER
 | STRING_LITERAL
 ;

statement_alias
 : IDENTIFIER
 | STRING_LITERAL
 ;

procedure_name
 : IDENTIFIER
 | STRING_LITERAL
 ;

java_method_name
 : STRING_LITERAL
 ;

jdbc_url // JDBC URL
 : STRING_LITERAL
 ;

user // JDBC username
 : IDENTIFIER
 | STRING_LITERAL
 ;

password // JDBC user password
 :STRING_LITERAL
 ;

jdbc_connection_properties // JDBC connection properties
 : STRING_LITERAL
 ;

jdbc_driver_class_name // JDBC driver class name
 : STRING_LITERAL
 ;

jar_file
 : STRING_LITERAL
 ;

connection_pool_size_min
 : NUMERIC_LITERAL
 ;

connection_pool_size_max
 : NUMERIC_LITERAL
 ;

sql_script_file // file name
 : STRING_LITERAL
 ;

cron_expression
 : STRING_LITERAL
 ;

connect_to_stmt
 : CONNECT TO jdbc_url
   (
    (USER user) |
    (PASSWORD password) |
    (PROPERTIES jdbc_connection_properties) |
    (DRIVER jdbc_driver_class_name) |
    (LIB jar_file ( ',' jar_file )* ) |
    (CONNECTION POOL
     (
      (MIN connection_pool_size_min) |
      (MAX connection_pool_size_max)
     )+
    ) |
    (EXPOSE UNDECLARED STATEMENTS) |
    (
     ALLOW INCOMING CONNECTIONS ( IF EXISTS '(' native_sql ')' )?
    )
   )*
   (AS? connection_alias)?
 ;

switch_to_stmt
 : SWITCH TO connection_alias
 ;

declare_statement_stmt
 : DECLARE STATEMENT
   '(' native_sql ')'
   (
    STATIC |
    ( COMPRESSION compression_level) |
    ( ROLES '(' role_name ( ',' role_name )* ')' ) |
    ( TRIGGER BEFORE trigger_before_procedure_name ) |
    ( TRIGGER AFTER trigger_after_procedure_name )
   )*
   (AS? statement_alias)?
 ;

declare_procedure_stmt
 : DECLARE PROCEDURE procedure_name FOR java_method_name
 ;

include_script_file_stmt
 : INCLUDE sql_script_file ( ',' sql_script_file )*
 ;

schedule_stmt
 : SCHEDULE procedure_name AT cron_expression
 ;

/* Developed by : Bart Kiers, bart@big-o.nl */
IDENTIFIER
 : '"' (~'"' | '""')* '"'
 | '`' (~'`' | '``')* '`'
 | '[' ~']'* ']'
 | [a-zA-Z_] [a-zA-Z_0-9]*
 ;

/* Developed by : Bart Kiers, bart@big-o.nl */
NUMERIC_LITERAL
 : DIGIT+ ( '.' DIGIT* )? ( E [-+]? DIGIT+ )?
 | '.' DIGIT+ ( E [-+]? DIGIT+ )?
 ;

/* Developed by : Bart Kiers, bart@big-o.nl */
STRING_LITERAL
 : '\'' ( ~'\'' | '\'\'' )* '\''
 ;

/* Developed by : Bart Kiers, bart@big-o.nl */
SINGLE_LINE_COMMENT
 : '--' ~[\r\n]* -> channel(HIDDEN)
 ;

/* Developed by : Bart Kiers, bart@big-o.nl */
MULTILINE_COMMENT
 : '/*' .*? ( '*/' | EOF ) -> channel(HIDDEN)
 ;

/* Developed by : Bart Kiers, bart@big-o.nl */
SPACES
 : [ \u000B\t\r\n] -> channel(HIDDEN)
 ;

/* Developed by : Bart Kiers, bart@big-o.nl */
UNEXPECTED_CHAR
 : .
 ;

/* Developed by : Bart Kiers, bart@big-o.nl */
fragment DIGIT : [0-9];

/* Developed by : Bart Kiers, bart@big-o.nl */
fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];

/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
