package com.heaven7.study;

import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends LabeledExprBaseVisitor<Integer> {

    private final Map<String, Integer> memory = new HashMap<String, Integer>();

    private void println(String method, String msg){
        System.out.println("TAG = EvalVisitor, called [ "+ method+"() ]: " + msg);
    }

    /** ID '=' expr NEWLINE    # Assign*/
    @Override //对于语句 aa=1 。先访问语句在访问表达式 aa , 1
    public Integer visitAssign(LabeledExprParser.AssignContext ctx) {
        // TODO Auto-generatedmethod stub
        String id = ctx.ID().getText(); // id is left-hand side of '='
        int value = visit(ctx.expr()); // compute valueof expression on right
        memory.put(id, value); // store it inour memory
        println("visitAssign", "id = " + id + " ,value = " + value);
        return value;
    }

    /** expr NEWLINE */
    @Override //计算表达式的值并打印
    public Integer visitPrintExpr(LabeledExprParser.PrintExprContext ctx) {
        // TODO Auto-generatedmethod stub
        Integer value = visit(ctx.expr()); // evaluate the exprchild
        System.out.println(value); // print theresult
        return 0; // return dummy value
    }
    /** INT */
    @Override
    public Integer visitInt(LabeledExprParser.IntContext ctx) {
        // TODO Auto-generatedmethod stub
        return Integer.valueOf(ctx.INT().getText());
    }

    /** '(' expr ')' */
     @Override //检测ID，如果map中含有这个ID，就返回其对应的value值。
    public Integer visitParens(LabeledExprParser.ParensContext ctx) {
        // TODO Auto-generatedmethod stub
        return visit(ctx.expr()); // return child expr's value
    }

    /** ID */
    @Override//检测ID，如果map中含有这个ID，就返回其对应的value值。
    public Integer visitId(LabeledExprParser.IdContext ctx) {
        // TODO Auto-generatedmethod stub
        String id = ctx.ID().getText();
        println("visitId", "id = " + id);
        if ( memory.containsKey(id) ) return memory.get(id);
       return 0;
    }

    /** expr op=('*'|'/') expr */
    @Override
    public Integer visitMulDiv(LabeledExprParser.MulDivContext ctx) {
        // TODO Auto-generatedmethod stub
        int left = visit(ctx.expr(0)); // get value ofleft subexpression
        int right = visit(ctx.expr(1)); // get value ofright subexpression
        println("visitMulDiv", "left = " + left + " ,right = " + right);
        if ( ctx.op.getType() == LabeledExprParser.MUL ) return left * right;
        if(right == 0){
            System.err.println("div: right is 0 , left = " + left + ", ");
            return -1;
        }
        return left / right; // must be DIV
    }

    /** expr op=('+'|'-') expr */
    @Override
    public Integer visitAddSub(LabeledExprParser.AddSubContext ctx) {
        // TODO Auto-generatedmethod stub
        int left = visit(ctx.expr(0)); // get value ofleft subexpression
        int right = visit(ctx.expr(1)); // get value ofright subexpression
        println("visitAddSub", "left = " + left + " ,right = " + right);
        if ( ctx.op.getType() == LabeledExprParser.ADD ) return left + right;
        return left - right; // must be SUB
    }
}
