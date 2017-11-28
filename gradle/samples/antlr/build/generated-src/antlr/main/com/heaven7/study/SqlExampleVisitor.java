// Generated from com\heaven7\study\SqlExample.g4 by ANTLR 4.5

    package com.heaven7.study;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SqlExampleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SqlExampleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SqlExampleParser#keyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword(SqlExampleParser.KeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlExampleParser#root_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot_statement(SqlExampleParser.Root_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlExampleParser#data_definition_statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_definition_statements(SqlExampleParser.Data_definition_statementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlExampleParser#create_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_statement(SqlExampleParser.Create_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlExampleParser#create_database_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_database_statement(SqlExampleParser.Create_database_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlExampleParser#database_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabase_name(SqlExampleParser.Database_nameContext ctx);
}