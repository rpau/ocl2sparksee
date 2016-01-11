package com.sparsity.ocl2sparksee.ast;

public class ColumnOrder implements SQAExpression{

	private int columnIndex;
	
	private OrderCriteria criteria;
	
	

	public ColumnOrder(int columnIndex, OrderCriteria criteria) {
		super();
		this.columnIndex = columnIndex;
		this.criteria = criteria;
	}

	public int getColumnIndex() {
		return columnIndex;
	}

	public void setColumnIndex(int columnIndex) {
		this.columnIndex = columnIndex;
	}

	public OrderCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(OrderCriteria criteria) {
		this.criteria = criteria;
	}
	
	
}
