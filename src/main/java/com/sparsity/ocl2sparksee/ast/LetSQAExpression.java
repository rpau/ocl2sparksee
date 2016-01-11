package com.sparsity.ocl2sparksee.ast;

import java.util.List;

public class LetSQAExpression implements SQAExpression{

	private List<VariableDeclarationExp> variables;
	
	private SQAExpression inExpression;
	
	public LetSQAExpression(List<VariableDeclarationExp> statements, SQAExpression inExpression) {
		super();
		this.variables = statements;
		this.inExpression = inExpression;
	}

	public List<VariableDeclarationExp> getVariables() {
		return variables;
	}

	public void setVariables(List<VariableDeclarationExp> variables) {
		this.variables = variables;
	}

	public SQAExpression getInExpression() {
		return inExpression;
	}

	public void setInExpression(SQAExpression inExpression) {
		this.inExpression = inExpression;
	}
	
	
	
}
