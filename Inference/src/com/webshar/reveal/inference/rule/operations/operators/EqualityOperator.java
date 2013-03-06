package com.webshar.reveal.inference.rule.operations.operators;

import com.webshar.reveal.inference.rule.operations.Operand;
import com.webshar.reveal.inference.rule.operations.OperationResult;
import com.webshar.reveal.inference.rule.operations.Operator;
import com.webshar.reveal.inference.rule.operations.operands.BooleanOperand;
import com.webshar.reveal.inference.rule.operations.operands.NumericOperand;
import com.webshar.reveal.inference.rule.operations.operands.StringOperand;
import com.webshar.reveal.inference.rule.operations.result.BooleanOperationResult;

public class EqualityOperator implements Operator {

	@Override
	public OperationResult operate(Operand[] operands) throws IllegalOperation {
		if (operands.length < 2)
			throw new IllegalOperation();
		boolean isBooleanOperand = operands[0] instanceof BooleanOperand;
		boolean isStringOperand = operands[0] instanceof StringOperand;
		boolean isNumericOperand = operands[0] instanceof NumericOperand;
		
		if (isBooleanOperand) {
			boolean value = ((BooleanOperand) operands[0]).value();
			for (Operand o: operands) {
				if (((BooleanOperand)o).value() != value)
					return new BooleanOperationResult(false);
			}
			return new BooleanOperationResult(true);
		}
		
		if (isNumericOperand) {
			long value = ((NumericOperand) operands[0]).value();
			for (Operand o: operands) {
				if (((NumericOperand)o).value() != value) 
					return new BooleanOperationResult(false);
			}
			return new BooleanOperationResult(true);
		}
		
		if (isStringOperand) {
			String value = ((StringOperand) operands[0]).value();
			for (Operand o: operands) {
				if (((StringOperand)o).value() != value) 
					return new BooleanOperationResult(false);
			}
			return new BooleanOperationResult(true);
		}
		
		throw new IllegalOperation();
	}

}
