package com.webshar.reveal.inference.rule.operations;

import com.webshar.reveal.inference.rule.operations.operators.IllegalOperation;

public interface Operator {
	OperationResult operate(Operand[] operands) throws IllegalOperation;
}
