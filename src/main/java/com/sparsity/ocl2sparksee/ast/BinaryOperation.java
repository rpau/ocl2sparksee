package com.sparsity.ocl2sparksee.ast;

public class BinaryOperation implements SQAExpression{

	private SQAExpression firstOperand;
	
	private SQAExpression secondOperand;
	
	private BinaryOperationType operand;

	
	public BinaryOperation(SQAExpression firstOperand, SQAExpression secondOperand, BinaryOperationType operand) {
		super();
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
		this.operand = operand;
	}

	public SQAExpression getFirstOperand() {
		return firstOperand;
	}

	public void setFirstOperand(SQAExpression firstOperand) {
		this.firstOperand = firstOperand;
	}

	public SQAExpression getSecondOperand() {
		return secondOperand;
	}

	public void setSecondOperand(SQAExpression secondOperand) {
		this.secondOperand = secondOperand;
	}

	public BinaryOperationType getOperand() {
		return operand;
	}

	public void setOperand(BinaryOperationType operand) {
		this.operand = operand;
	}
	
	
}
