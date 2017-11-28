// Generated from com\heaven7\study\SqlExample.g4 by ANTLR 4.5

    package com.heaven7.study;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SqlExampleParser}.
 */
public interface SqlExampleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SqlExampleParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(SqlExampleParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlExampleParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(SqlExampleParser.KeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlExampleParser#root_statement}.
	 * @param ctx the parse tree
	 */
	void enterRoot_statement(SqlExampleParser.Root_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlExampleParser#root_statement}.
	 * @param ctx the parse tree
	 */
	void exitRoot_statement(SqlExampleParser.Root_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlExampleParser#data_definition_statements}.
	 * @param ctx the parse tree
	 */
	void enterData_definition_statements(SqlExampleParser.Data_definition_statementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlExampleParser#data_definition_statements}.
	 * @param ctx the parse tree
	 */
	void exitData_definition_statements(SqlExampleParser.Data_definition_statementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlExampleParser#create_statement}.
	 * @param ctx the parse tree
	 */
	void enterCreate_statement(SqlExampleParser.Create_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlExampleParser#create_statement}.
	 * @param ctx the parse tree
	 */
	void exitCreate_statement(SqlExampleParser.Create_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlExampleParser#create_database_statement}.
	 * @param ctx the parse tree
	 */
	void enterCreate_database_statement(SqlExampleParser.Create_database_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlExampleParser#create_database_statement}.
	 * @param ctx the parse tree
	 */
	void exitCreate_database_statement(SqlExampleParser.Create_database_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlExampleParser#database_name}.
	 * @param ctx the parse tree
	 */
	void enterDatabase_name(SqlExampleParser.Database_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlExampleParser#database_name}.
	 * @param ctx the parse tree
	 */
	void exitDatabase_name(SqlExampleParser.Database_nameContext ctx);
}