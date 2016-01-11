package com.sparsity.ocl2sparksee.ast;

public class VariableDeclarationExp implements SQAExpression{

	private String name;
	
	private SQAExpression init;

	public VariableDeclarationExp(String name, SQAExpression init) {
		super();
		this.name = name;
		this.init = init;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SQAExpression getInit() {
		return init;
	}

	public void setInit(SQAExpression init) {
		this.init = init;
	}
	
	
}
