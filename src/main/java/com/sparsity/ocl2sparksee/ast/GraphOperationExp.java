package com.sparsity.ocl2sparksee.ast;

import java.util.List;

public class GraphOperationExp implements SQAExpression{

	private String name;
	
	private List<SQAExpression> argument;
	
	

	public GraphOperationExp(String name, List<SQAExpression> argument) {
		super();
		this.name = name;
		this.argument = argument;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SQAExpression> getArgument() {
		return argument;
	}

	public void setArgument(List<SQAExpression> argument) {
		this.argument = argument;
	}
	
	
}
