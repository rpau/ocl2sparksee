package com.sparsity.ocl2sparksee.ast;

import java.util.List;

public abstract class TableTransformationExp extends TableOperationExp {

	private List<TableOperationExp> source;

	public TableTransformationExp(List<TableOperationExp> source, String name, List<SQAExpression> argument) {
		super(name, argument);
		this.source = source;
	}

	public List<TableOperationExp> getSource() {
		return source;
	}

	public void setSource(List<TableOperationExp> source) {
		this.source = source;
	}

}
