grammar LabeledExpr;
@lexer::header {
    package com.heaven7.study;
}

@parser::header {
    package com.heaven7.study;
}

//词法规则. ? 0或者1次， * 0+次
//ID : [a-zA-Z]+ ; // matchidentifiers
ID:
     ( 'A'..'Z' | 'a'..'z' | '_' | '$')( 'A'..'Z' | 'a'..'z' | '_' | '$' | '0'..'9' )*
;
INT : [0-9]+ ; // match integers
NEWLINE:'\r'? '\n' ;//return newlinesto parser(end-statement signal)
WS : [ \t]+ -> skip ;// skip space and tab

//加减乘除
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;

//表达式定义. 使用#打tag后。 生成的XXXExprVisitor文件 会生成对应的方法，eg: visitMulDiv...etc.
//西面的表达式表示：
// 第一行 以乘除为例.expr op=(‘*’|’/’) expr.
// 在上述式子中我们有两个expr。第一个代表我们运算的第一个值,第二个代表我们运算的第二个值，中间是运算符 ‘*’或者‘/’
expr:expr op =('*'|'/') expr       # MulDiv
| expr op=('+'|'-') expr           # AddSub
| INT                              # int
| ID                               # id
| '(' expr ')'                     # parens
;

//定义语句stat
stat: expr NEWLINE         # printExpr
     | ID '=' expr NEWLINE # assign
     | NEWLINE             # blank
     ;

//最后定义我们的program.即多个语句
prog: stat+;