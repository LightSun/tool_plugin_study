grammar Expr;

//语句
stat: expr 
     |NEWLINE 
;

//表达式
/**
  语法规定第一个字母小写
  词法规定第一个字母大写
*/
expr : multExpr (('+'|'-') multExpr)* 
; 
multExpr : atom (('*'|'/') atom)* 
; 
atom:  '(' expr ')' 
      | INT  
   | ID  
;

//token定义
/**
 ID表示变量
   INT表示常量
   换行符 NEWLINE 和空格 WS 
*/
ID : ('a'..'z' |'A'..'Z')+ ; 
INT : '0'..'9' + ; 
NEWLINE:'\r' ? '\n' ; 
WS : (' ' |'\t' |'\n' |'\r' )+ {skip();} ;