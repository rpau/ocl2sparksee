package com.sparsity.ocl2sparksee.ast;

public class AttributeAccessExp implements SQAExpression{

	private String typeName;
	
	private String attribute;

	
	public AttributeAccessExp(String typeName, String attribute) {
		super();
		this.typeName = typeName;
		this.attribute = attribute;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
	
}
