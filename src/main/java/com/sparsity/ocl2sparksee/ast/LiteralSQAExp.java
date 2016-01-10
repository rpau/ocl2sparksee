package com.sparsity.ocl2sparksee.ast;

public class LiteralSQAExp implements SQAExpression {

	private String value;

	private LiteralType type;

	public LiteralSQAExp(String value, LiteralType type) {
		super();
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public LiteralType getType() {
		return type;
	}

	public void setType(LiteralType type) {
		this.type = type;
	}

}
