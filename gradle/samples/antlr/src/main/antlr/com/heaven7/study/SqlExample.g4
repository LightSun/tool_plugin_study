grammar SqlExample;

@lexer::header {
    package com.heaven7.study;
}

@parser::header {
    package com.heaven7.study;
}

fragment A_ :   'a' | 'A';
fragment B_ :   'b' | 'B';
fragment C_ :   'c' | 'C';
fragment D_ :   'd' | 'D';
fragment E_ :   'e' | 'E';
fragment F_ :   'f' | 'F';
fragment G_ :   'g' | 'G';
fragment H_ :   'h' | 'H';
fragment I_ :   'i' | 'I';
fragment J_ :   'j' | 'J';
fragment K_ :   'k' | 'K';
fragment L_ :   'l' | 'L';
fragment M_ :   'm' | 'M';
fragment N_ :   'n' | 'N';
fragment O_ :   'o' | 'O';
fragment P_ :   'p' | 'P';
fragment Q_ :   'q' | 'Q';
fragment R_ :   'r' | 'R';
fragment S_ :   's' | 'S';
fragment T_ :   't' | 'T';
fragment U_ :   'u' | 'U';
fragment V_ :   'v' | 'V';
fragment W_ :   'w' | 'W';
fragment X_ :   'x' | 'X';
fragment Y_ :   'y' | 'Y';
fragment Z_ :   'z' | 'Z';

keyword
 : TRUE
 | FALSE
 | NOT
 // ....
;

SEMI    : ';' ;
DOT     : '.' ;
COMMA   : ',' ;
ASTERISK: '*' ;


CREATE: C_ R_ E_ A_ T_ E_ ;
DATABASE: D_ A_ T_ A_ B_ A_ S_ E_ ;
SCHEMA: S_ C_ H_ E_ M_ A_ ;
IF: I_ F_ ;
NOT: N_ O_ T_ ;
EXISTS: E_ X_ I_ S_ T_ S_ ;
TRUE: T_ R_ U_ E_ ;
FALSE: F_ A_ L_ S_ E_ ;

ID:
     ( 'A'..'Z' | 'a'..'z' | '_' | '$' | '0'..'9' )+
;

root_statement:
      data_definition_statements
        (SEMI)?
;

data_definition_statements:
      create_statement
;

create_statement:
       create_database_statement
;

create_database_statement:
    CREATE (DATABASE | SCHEMA) (IF NOT EXISTS)? database_name
;

database_name:  ID
      | keyword
;