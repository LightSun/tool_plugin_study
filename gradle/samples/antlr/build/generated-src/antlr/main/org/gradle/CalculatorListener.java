// Generated from org\gradle\Calculator.g by ANTLR 4.5

    package org.gradle;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorParser}.
 */
public interface CalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(CalculatorParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(CalculatorParser.AddContext ctx);
}