
# antlr基础
http://yijun1171.github.io/2015/03/30/ANTLR4%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0-%E8%AF%AD%E6%B3%95%E5%AD%97%E5%85%B8-Grammar-Lexicon/

## 标识符(Identifiers): （支持unicode编码的字符）
 * 词法单元 and 词法规则 以upper字母开头命名.
 * 解析规则 以 lower字母开头命名
 * 比如：
 ```java
ID, LPAREN, RIGHT_CURLY //token names/rule
expr, simpleDclarator, d2, header_file //rule names
```

## 文字. (Literals)
 * ANTLR 不区分字符和字符串，所有的字符串(源.g/.g4等文件中)都是用 单引号 引用起来的字符.
 * 不包括正则表达式。(支持unicode and 转义字符)

 * eg:
```java
',' , 'if', '>=',
' \''//转义的单引号
'\u00E8' //法语中的字符è
'\n', '\r' //换行 回车
```

## 动作 (Actions)
 * 动作是用目标语言书写的代码块.嵌入的代码可以出现在:

   * 1, @header @members这样的命名动作中
   * 2, 解析规则和词法规则中
   * 3, 异常捕获中
   * 4, 解析规则的属性部分(返回值,参数等)
   * 5, 一些规则可选元素中

## 关键字
 * import, fragment, lexer, parser, grammar, returns, locals, throws, catch, finally, mode, options, tokens


## 语法结构(Grammar Structure)
 * 语法结构如下
 ```java
|Grammar |
| ————- |
| /Optional javadoc style comment*/|
| grammer Name; |
| options {…}; |
| import …; |
| tokens {…}; |
| channels {…}; |
| @actionName** {…}; |
| |
| rule1 //parser and lexer rules |
| … |
| ruleN |
```
 * 文件命名必须和grammar命名相同,如 grammar T,文件名必须命名为T.g4.
 * options,imports,token,action的声明顺序没有要求,但一个文件中options,imports,token最多只能声明一次.
grammar是必须声明的,同时必须至少声明一条规则(rule),其余的部分都是可选的.

## 规则 rules
格式：
```java
  ruleName : alternative1 | ... | alternativeN ;
  //定义类型
  type : 'int' | 'unsigned' | 'long'
```

## 导入 imports
 * ANTLR中的引入机制类似于OO中的继承.它会从引入的文件继承所有的规则,词法单元,动作.然后主文件中的元素会”覆盖”引入文件中的重名元素.
 * 嵌套引用的合并规则比较复杂,详见[官方文档](https://theantlrguy.atlassian.net/wiki/display/ANTLR4/Grammar+Structure#GrammarStructure-GrammarImports)


## 词法单元(Tokens Section)

* tokens {Token1 ... TokenN}

* //例如为向量表示定义虚词法单元:
```java
grammar VecMathAST
options{output=AST;}
tokens{VEC;}
statlist : stat+ ;
stat : ID '=' expr -> ^('=' ID expr)
     | 'print' expr -> ^('print' expr);
expr : multExpr ('+' ^ multExpr)*;
multExpr : primary (('*'^|'.'^) primary)*;
primary : INT | ID | '[' expr (',' expr)* ']' -> ^(VEC expr+);
```

##  动作(Actions at the Grammar Level)
 * 针对java,有两个已经定义好的action:header和members
   * @header在生成的目标代码中的类定义之前注入代码
   * @members在生成的目标代码中的类定义里注入代码(例如类的属性和方法)

```java
grammar Count;

@header {
pacakage foo;
}

@members{
int count = 0;
}
list @after{System.out.println(count+"ints");} : INT {count++;} (',' INT {count++})*
;

INT: [0-9]+;
```

## 解析器规则(Parser Rules)
 * 解析器由一组解析器规则组成.java应用通过调用生成的规则函数(每个规则会生成一个函数)来启动解析.
 基本形式如下,用 | 操作符分割多个选项
 ```java

stat : restat | 'break' ';' | 'continue' ';' ;

 ```

## 可选标签(Alternative Labels)
 * 可以在规则中添加标签,ANTLR会根据标签生成与规则相关的解析树的事件监听函数,使我们更加精准的控制解析过程.用 # 操作符定义一个标签
 用法如下:
 ```java
 grammar T;
 stat: 'return' e ';' # Return
     | 'break' ';' # Break
 ```
 * ANTLR会为每个标签生成一个rule-context类.
 ```java
 public interface AListener extends ParseTreeListener {
  	void enterReturn(AParser.ReturnContext ctx);
  	void exitReturn(AParser.ReturnContext ctx);
  	void enterBreak(AParser.BreakContext ctx);
  	void exitBreak(AParser.BreakContext ctx);
  	}
 ```
 ps: 同一个标签可以加在多个规则选项上(multiple alternatives),但是标签命名不可以和规则名冲突

 ## 规则上下文对象(Rule Context Objects)
  * ANTLR为每个规则生成一个上下文对象,通过这个对象可以访问规则定义中的其他规则的引用.
  根据规则定义中的其他规则的引用数量不同,生成对象中包含的方法也不同.例如:
  ```java
  inc : e '++';

  //generates this context class
  public static class IncContext extends ParserRuleContext {
   	public EContext e() { ... } // return context object associated with e
   	...
   	}
  ```
  ```java
  field : e '.' e;

  //generates this context class
  public static class FieldContext extends ParserRuleContext {
   	public EContext e(int i) { ... } // get ith e context
   	public List<EContext> e() { ... } // return ALL e contexts
   	...
   	}
  ```

## 规则元素标签(Rule Element Labels)
 * 可以用 = 操作符为规则中的元素添加标签,这样会在规则的上下文对象中添加元素的字段.
 例如:
 ```java
 stat: 'return' value=e ';' # Return //将e的context作为一个字段添加到 ReturnContext中
  	| 'break' ';' # Break
  	;

  //generates context class
  public static class ReturnContext extends StatContext {
  	public EContext value;
  	...
  	}
 ```
 += 操作符可以很方便的记录大量的token或者规则的引用
 ```java
 array : '{' el+=INT (',' el+=INT)* '}' ;
 //ANTLR generates a List field in the appropriate rule context class:
  public static class ArrayContext extends ParserRuleContext {
  	public List<Token> el = new ArrayList<Token>();
  	...
  	}
 ```

 ## 规则元素(Rule ELements)
 * 规则元素指定了解析器在具体时刻应该执行什么任务.元素可以是规则(rule), 词法单元(token), 字符串文字(string literal)等
 ```java
 T token
 ‘literal’ 字符串文字
 r 规则
 r[args] 向规则函数中传递参数,参数的书写规则是目标语言,用逗号分隔
 . 通配符
 {action} 动作,在元素的间隔中执行
 {p} 谓词
 //支持逻辑非: ~
 ```

## 子规则
 * 规则中包含的可选块称为子规则(被封闭在括号中).子规则也可以看做规则(rule),
 但是没有显式的命名.子规则不能定义局部变量,也没有返回值.
 如果子规则只有一个元素,括号可以省略.
子规则有四种:
```java
(x|y|z) 只匹配一个选项
(x|y|z)? 匹配一个或者不匹配
(x|y|z)* 匹配零次或多次
(x|y|z)+ 匹配一次或多次
```

## 捕获异常(Catching Exception)
 * 当规则中出现语法错误,ANTLR可以捕获异常,报告错误和尝试恢复(possibly by consuming more tokens),然后从规则中返回.
 ANLTR通过策略模式来处理所有的异常,也可以为某个规则通过指定特定的异常处理:在规则末尾添加catch语句.
 ```java
 r : ...
  	;
  	catch[RecognitionException e] { throw e; }

 ```

 ## 规则属性定义(Rule Attribute Definition)
 * 可以像编程语言中的函数那样,在规则中定义参数,返回值,局部变量,定义的这些属性会保存在规则上下文对象中(rule context object).
   例如:
   ```java
   rulename [args] returns [retvals] locals [localvars]: ...;
   //[..]中定义的变量可以在定义之后使用
   add [int x] returns [int result] : '+=' INT {$result = $x + $INT.int;};

   ```
 * 和语法层面的动作(action)一样,可以定义规则层面的动作.合法的动作名是:init,after.
 像这些动作的命名一样,解析器会在匹配相应的规则之前执行init动作,在规则匹配完成之后执行after动作.
 ```java
 /** Derived from rule "row : field (',' field)* '\r'? '\n' ;" */
  	row[String[] columns] returns [Map<String,String> values]
  	locals [int col=0]
  	@init {
  	$values = new HashMap<String,String>();
  	}
  	@after {
  	if ($values!=null && $values.size()>0) {
  	System.out.println("values = "+$values);
  	}
  	}
 ```