package com.sparsity.ocl2sparksee.visitors;

import java.util.LinkedList;
import java.util.List;

import com.sparsity.ocl.ast.BooleanLiteralExp;
import com.sparsity.ocl.ast.CallExp;
import com.sparsity.ocl.ast.ConnectableElement;
import com.sparsity.ocl.ast.Constraint;
import com.sparsity.ocl.ast.ExpressionInOcl;
import com.sparsity.ocl.ast.FeatureCallExp;
import com.sparsity.ocl.ast.IfExp;
import com.sparsity.ocl.ast.IntegerLiteralExp;
import com.sparsity.ocl.ast.IterateExp;
import com.sparsity.ocl.ast.IteratorExp;
import com.sparsity.ocl.ast.LetExpression;
import com.sparsity.ocl.ast.LiteralExp;
import com.sparsity.ocl.ast.LoopExp;
import com.sparsity.ocl.ast.NamedElement;
import com.sparsity.ocl.ast.NavigationCallExp;
import com.sparsity.ocl.ast.NumericLiteralExp;
import com.sparsity.ocl.ast.OclExpression;
import com.sparsity.ocl.ast.Operation;
import com.sparsity.ocl.ast.OperationCallExp;
import com.sparsity.ocl.ast.Parameter;
import com.sparsity.ocl.ast.PropertyCallExp;
import com.sparsity.ocl.ast.RealLiteralExp;
import com.sparsity.ocl.ast.StateExp;
import com.sparsity.ocl.ast.StringLiteralExp;
import com.sparsity.ocl.ast.TupleLiteralExp;
import com.sparsity.ocl.ast.Type;
import com.sparsity.ocl.ast.TypeExp;
import com.sparsity.ocl.ast.TypedElement;
import com.sparsity.ocl.ast.Variable;
import com.sparsity.ocl.ast.VariableExp;
import com.sparsity.ocl.visitors.GenericOclAstVisitor;
import com.sparsity.ocl2sparksee.ast.AttributeAccessExp;
import com.sparsity.ocl2sparksee.ast.BinaryOperation;
import com.sparsity.ocl2sparksee.ast.BinaryOperationType;
import com.sparsity.ocl2sparksee.ast.DataTransformationExp;
import com.sparsity.ocl2sparksee.ast.GraphOperationExp;
import com.sparsity.ocl2sparksee.ast.LetSQAExpression;
import com.sparsity.ocl2sparksee.ast.LiteralSQAExp;
import com.sparsity.ocl2sparksee.ast.LiteralType;
import com.sparsity.ocl2sparksee.ast.SQAExpression;
import com.sparsity.ocl2sparksee.ast.TableOperationExp;
import com.sparsity.ocl2sparksee.ast.VariableDeclarationExp;
import com.sparsity.ocl2sparksee.ast.VariableRefExp;

public class OCL2SparkseeVisitor implements GenericOclAstVisitor<SQAExpression, SQAExpression> {

	@Override
	public SQAExpression visit(BooleanLiteralExp booleanLiteralExp, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(CallExp callExp, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(ConnectableElement connectableElement, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(Constraint constraint, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(ExpressionInOcl expressionInOcl, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(FeatureCallExp featureCallExp, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(IfExp ifExp, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(IntegerLiteralExp integerLiteralExp, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(IterateExp iterateExp, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(IteratorExp iteratorExp, SQAExpression context) {
		String op = iteratorExp.getName();
		OclExpression source = iteratorExp.getSource();
		List<TableOperationExp> previousOps = null;
		if (source != null) {
			SQAExpression result = source.accept(this, context);
			if (result != null) {
				previousOps = new LinkedList<TableOperationExp>();
				previousOps.add((TableOperationExp) result);
			}
		}
		String name = null;
		if (op.equals("select")) {
			name = "SELECT";
			SQAExpression filter = null;
			OclExpression body = iteratorExp.getBody();
			if (body != null) {
				filter = body.accept(this, context);
			}
			List<SQAExpression> args = null;
			if (filter != null) {
				args = new LinkedList<SQAExpression>();
				args.add(filter);
			}

			return new DataTransformationExp(previousOps, name, args);
		}
		else if(op.equals("collect")){
			
		}
		

		return null;
	}

	@Override
	public SQAExpression visit(LetExpression letExpression, SQAExpression context) {

		Variable var = letExpression.getVariable();
		SQAExpression varResult = var.accept(this, context);
		OclExpression inExpr = letExpression.getInExpression();
		
		if (context != null) {

			LetSQAExpression ctx = (LetSQAExpression) context;
			ctx.getVariables().add((VariableDeclarationExp) varResult);
		} else {
			List<VariableDeclarationExp> vars = new LinkedList<VariableDeclarationExp>();
			LetSQAExpression letClause = new LetSQAExpression(vars, null);
			vars.add((VariableDeclarationExp) varResult);
			context = letClause;
		}
		if(inExpr instanceof LetExpression){
			inExpr.accept(this, context);
		}
		else{
			LetSQAExpression ctx = (LetSQAExpression) context;
			ctx.setInExpression(inExpr.accept(this, context));
		}

		return context;
	}

	@Override
	public SQAExpression visit(LiteralExp literalExp, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(LoopExp loopExp, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(NamedElement namedElement, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(NavigationCallExp navigationCallExp, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(NumericLiteralExp numericLiteralExp, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(Operation operation, SQAExpression context) {

		return operation.getBody().accept(this, context);
	}

	@Override
	public SQAExpression visit(OperationCallExp operationCallExp, SQAExpression context) {
		OclExpression source = operationCallExp.getSource();
		String op = operationCallExp.getReferredOperation();

		if (op.equals("allInstances")) {
			VariableExp typeNode = (VariableExp) source;

			String var = typeNode.getReferedVariable();
			List<SQAExpression> args = new LinkedList<SQAExpression>();

			LiteralSQAExp typeName = new LiteralSQAExp(var, LiteralType.STRING);
			args.add(typeName);

			GraphOperationExp graphOp = new GraphOperationExp("SCAN", args);

			return graphOp;
		} else {
			SQAExpression sourceResult = null;
			if (source != null) {
				sourceResult = source.accept(this, context);
			}
			List<OclExpression> args = operationCallExp.getArguments();
			List<SQAExpression> argsResult = null;
			if (args != null) {
				argsResult = new LinkedList<SQAExpression>();
				for (OclExpression expr : args) {
					argsResult.add(expr.accept(this, context));
				}
			}

			if (op.equals("EQ")) {
				return new BinaryOperation(sourceResult, argsResult.get(0), BinaryOperationType.EQ);
			}
			else if(op.equals("subSequence")){
				List<TableOperationExp> sources = new LinkedList<TableOperationExp>();
				sources.add((TableOperationExp) sourceResult);
				return new DataTransformationExp(sources, "SLICE", argsResult);
			}
			else if(op.equals("union")){
				List<TableOperationExp> sources = new LinkedList<TableOperationExp>();
				sources.add((TableOperationExp) sourceResult);
				if(argsResult != null){
					for(SQAExpression arg: argsResult){
						sources.add((TableOperationExp) arg);
					}
				}
				return new DataTransformationExp(sources, "UNION", null);
			}
			else if(op.equals("sortedBy")){
				List<TableOperationExp> sources = new LinkedList<TableOperationExp>();
				sources.add((TableOperationExp) sourceResult);
				
				argsResult = new LinkedList<SQAExpression>();
				//TODO: use ColumnOrder and infer the column headers before
				
				return new DataTransformationExp(sources, "SORT", argsResult);
			}

		}

		return null;
	}

	@Override
	public SQAExpression visit(Parameter parameter, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(PropertyCallExp propertyCallExp, SQAExpression context) {

		AttributeAccessExp result = null;

		OclExpression sourceExpr = propertyCallExp.getSource();
		if (sourceExpr instanceof VariableExp) {
			VariableExp var = (VariableExp) sourceExpr;
			String typeName = var.getReferedVariable();

			return new AttributeAccessExp(typeName, propertyCallExp.getReferredProperty());
		}

		return result;
	}

	@Override
	public SQAExpression visit(RealLiteralExp realLiteralExp, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(StateExp stateExp, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(StringLiteralExp stringLiteralExp, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(TupleLiteralExp tupleLiteralExp, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(Type type, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(TypedElement typedElement, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(TypeExp typedExp, SQAExpression context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQAExpression visit(Variable variable, SQAExpression context) {
		OclExpression init = variable.getInitExpression();
		if (init != null) {
			SQAExpression initResult = init.accept(this, context);
			return new VariableDeclarationExp(variable.getName(), initResult);
		}
		return null;
	}

	@Override
	public SQAExpression visit(VariableExp variableExp, SQAExpression context) {
		return new VariableRefExp(variableExp.getReferedVariable());
	}

}
