package com.webshar.reveal.inference.rule.operations.operators;

import com.webshar.reveal.inference.rule.operations.Operand;
import com.webshar.reveal.inference.rule.operations.OperationResult;
import com.webshar.reveal.inference.rule.operations.Operator;
import com.webshar.reveal.inference.rule.operations.operands.NumericOperand;
import com.webshar.reveal.inference.rule.operations.result.BooleanOperationResult;

public class GreaterThanOperator implements Operator {

	@Override
	public OperationResult operate(Operand[] operands) throws IllegalOperation {
		if (operands.length != 2)
			throw new IllegalOperation();
		
		boolean isNumericOperand = operands[0] instanceof NumericOperand;
		if (!isNumericOperand)
			throw new IllegalOperation();
		
		long value1 = ((NumericOperand)operands[0]).value();
		long value2 = ((NumericOperand)operands[0]).value();
		
		return new BooleanOperationResult(value1 > value2);
	}

}
