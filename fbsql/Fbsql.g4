grammar Fbsql;

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

fbsql_stmt:
 (
   declare_procedure_stmt
 | expose_stmt
 )
;

/* keywords */

K_EXPOSE   : E X P O S E;
K_PREFETCH : P R E F E T C H;
K_ROLES    : R O L E S;
K_AS       : A S;

K_DECLARE  : D E C L A R E;
K_PROCEDURE: P R O C E D U R E;
K_FOR      : F O R;

native_sql:
 .*?
;

role_name:
   IDENTIFIER
 | STRING_LITERAL
;

statement_alias:
   IDENTIFIER
 | STRING_LITERAL
;

expose_stmt:
    K_EXPOSE K_PREFETCH? '(' native_sql ')' ( K_ROLES '(' role_name ( ',' role_name )* ')' )? K_AS? statement_alias?
;

procedure_name:
   IDENTIFIER
 | STRING_LITERAL
;

java_method_name:
   STRING_LITERAL
;

declare_procedure_stmt:
    K_DECLARE K_PROCEDURE procedure_name K_FOR java_method_name
;

IDENTIFIER:
   '"' (~'"' | '""')* '"'
 | '`' (~'`' | '``')* '`'
 | '[' ~']'* ']'
 | [a-zA-Z_] [a-zA-Z_0-9]*
;

STRING_LITERAL:
 '\'' ( ~'\'' | '\'\'' )* '\''
;

SINGLE_LINE_COMMENT:
 '--' ~[\r\n]* -> channel(HIDDEN)
;

MULTILINE_COMMENT:
 '/*' .*? ( '*/' | EOF ) -> channel(HIDDEN)
;

SPACES:
 [ \u000B\t\r\n] -> channel(HIDDEN)
;

UNEXPECTED_CHAR:
 .
;

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
