package com.sparsity.ocl2sparksee.ast;

public class UnaryExpr implements SQAExpression{

	private UnaryOperationType type;
	
	private SQAExpression operand;

	public UnaryExpr(UnaryOperationType type, SQAExpression operand) {
		super();
		this.type = type;
		this.operand = operand;
	}

	public UnaryOperationType getType() {
		return type;
	}

	public void setType(UnaryOperationType type) {
		this.type = type;
	}

	public SQAExpression getOperand() {
		return operand;
	}

	public void setOperand(SQAExpression operand) {
		this.operand = operand;
	}
	
	
}
