package com.sparsity.ocl2sparksee.ast;

import java.util.List;

public class DataTransformationExp extends TableTransformationExp {

	public DataTransformationExp(List<TableOperationExp> source, String name, List<SQAExpression> argument) {
		super(source, name, argument);
	}

}
