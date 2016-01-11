package com.sparsity.ocl2sparksee.ast;

public class VariableRefExp implements SQAExpression {

	private String name;

	public VariableRefExp(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
