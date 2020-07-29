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

fbsql_stmt
 :
 (
   connect_to_stmt
 | declare_procedure_stmt
 | expose_stmt
 )
 ;

/* keywords */

K_EXPOSE      : E X P O S E;
K_PREFETCH    : P R E F E T C H;
K_ROLES       : R O L E S;
K_TRIGGER     : T R I G G E R;
K_BEFORE      : B E F O R E;
K_AFTER       : A F T E R;
K_AS          : A S;
K_COMPRESSION : C O M P R E S S I O N;
K_NONE        : N O N E;
K_BEST        : B E S T;
K_SPEED       : S P E E D;
K_ON          : O N;
K_OFF         : O F F;

K_DECLARE     : D E C L A R E;
K_PROCEDURE   : P R O C E D U R E;
K_FOR         : F O R;

K_CONNECT     : C O N N E C T;
K_TO          : T O;
K_USER        : U S E R;
K_PASSWORD    : P A S S W O R D;
K_PROPERTIES  : P R O  P E R T I E S;
K_DRIVER      : D R I V E R;
K_JAR         : J A R;
K_FILES       : F I L E S;
K_CONNECTION  : C O N N E C T I O N;
K_POOL        : P O O L;
K_SIZE        : S I Z E;
K_MIN         : M I N;
K_MAX         : M A X;
K_DEBUG       : D E B U G;

K_SET         : S E T;
K_ALLOW       : A L L O W;
K_LOGIN       : L O G I N;
K_IF          : I F;
K_EXISTS      : E X I S T S;

K_SCHEDULE    : S C H E D U L E;
K_AT          : A T;

K_INCLUDE     : I N C L U D E;
K_SCRIPT      : S C R I P T;
K_FILE        : F I L E;

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

compression
 : K_NONE
 | K_BEST K_COMPRESSION
 | K_BEST K_SPEED
 ;

prefetch
 : K_ON
 | K_OFF
 ;

statement_alias
 : IDENTIFIER
 | STRING_LITERAL
 ;

expose_stmt
 : K_EXPOSE
   '(' native_sql ')'
   (
    ( K_PREFETCH prefetch) |
    ( K_COMPRESSION compression) |
    ( K_ROLES '(' role_name ( ',' role_name )* ')' ) |
    ( K_TRIGGER K_BEFORE trigger_before_procedure_name ) |
    ( K_TRIGGER K_AFTER trigger_after_procedure_name )
   )*
   K_AS? statement_alias?
 ;

procedure_name
 : IDENTIFIER
 | STRING_LITERAL
 ;

java_method_name
 : STRING_LITERAL
 ;

declare_procedure_stmt
 : K_DECLARE K_PROCEDURE procedure_name K_FOR java_method_name
 ;

jdbc_url // JDBC URL
 : STRING_LITERAL
 ;

jdbc_user // JDBC username
 : IDENTIFIER
 | STRING_LITERAL
 ;

jdbc_password // JDBC user password
 :STRING_LITERAL
 ;

jdbc_properties // JDBC connection properties
 : STRING_LITERAL
 ;
jdbc_driver // JDBC driver class name
 : STRING_LITERAL
 ;

jdbc_driver_jar
 : STRING_LITERAL
 ;

connection_pool_size_min
 : NUMERIC_LITERAL
 ;

connection_pool_size_max
 : NUMERIC_LITERAL
 ;

debug
 : K_ON
 | K_OFF
 ;

connect_to_stmt
 : K_CONNECT K_TO jdbc_url
   (
    (K_USER jdbc_user) |
    (K_PASSWORD jdbc_password) |
    (K_PROPERTIES jdbc_properties) |
    (K_DRIVER jdbc_driver) |
    (K_JAR K_FILES '(' jdbc_driver_jar ( ',' jdbc_driver_jar )* ')') |
    (K_CONNECTION K_POOL K_SIZE K_MIN connection_pool_size_min) | 
    (K_CONNECTION K_POOL K_SIZE K_MAX connection_pool_size_max) |
    (K_DEBUG debug)
   )*
 ;

file // file name
 : STRING_LITERAL
 ;

include_script_file_stmt
 : K_INCLUDE K_SCRIPT K_FILE file
 ;

set_allow_login_if_exists
 : K_SET K_ALLOW K_LOGIN K_IF K_EXISTS
   '(' native_sql ')'
 ;

cron_expression
 : STRING_LITERAL
 ;

schedule_stmt
 : K_SCHEDULE procedure_name K_AT cron_expression
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
