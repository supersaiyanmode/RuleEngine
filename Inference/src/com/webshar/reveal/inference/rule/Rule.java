package com.webshar.reveal.inference.rule;

import org.w3c.dom.Node;

import com.webshar.reveal.inference.rule.operations.Operand;
import com.webshar.reveal.inference.rule.operations.OperationResult;
import com.webshar.reveal.inference.rule.operations.operators.IllegalOperation;


public class Rule {
	RuleOperationType type;
	OperationResult result;
	Operand[] operands;
	
	protected Rule() {
		
	}
	
	OperationResult execute() throws IllegalOperation {
		if (result != null)
			return result;
		result =  type.getOperator().operate(operands);
		return result;
	}
	
}
