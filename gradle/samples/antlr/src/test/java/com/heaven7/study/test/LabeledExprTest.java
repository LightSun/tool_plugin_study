package com.heaven7.study.test;//LabeledExprTest.java
import java.io.FileInputStream;
import java.io.InputStream;

import com.heaven7.study.EvalVisitor;
import com.heaven7.study.LabeledExprLexer;
import com.heaven7.study.LabeledExprParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
 
public class LabeledExprTest {


   public static void main(String[] args) throws Exception {
      // create a CharStream thatreads from standard input
      InputStream inputStream = LabeledExprTest.class.getResourceAsStream("/test_labeled_expr.txt");
      ANTLRInputStream input = new ANTLRInputStream(inputStream);

      LabeledExprLexer lexer = new LabeledExprLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      LabeledExprParser parser = new LabeledExprParser(tokens);

      ParseTree tree = parser.prog(); // parse
      EvalVisitor eval = new EvalVisitor();
      eval.visit(tree);
   }
}