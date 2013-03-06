package com.webshar.reveal.inference.rule;

import java.util.HashMap;
import java.util.Map;

import com.webshar.reveal.inference.rule.operations.Operator;
import com.webshar.reveal.inference.rule.operations.operators.EqualityOperator;
import com.webshar.reveal.inference.rule.operations.operators.GreaterThanOperator;

public class RuleOperationType {
	private final static Map<String, Operator> operationMap =
						new HashMap<String, Operator>() {{
		put("equals", new EqualityOperator());
		put("greater-than", new GreaterThanOperator());
	}};
	
	Operator operator;
	
	public RuleOperationType(String str) throws IllegalOperator {
		operator = operationMap.get(str);
		if (operator == null)
			throw new IllegalOperator();
	}
	
	public Operator getOperator() {
		return operator;
	}
}
