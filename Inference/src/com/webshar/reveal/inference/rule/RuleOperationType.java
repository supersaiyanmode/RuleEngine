package com.webshar.reveal.inference.rule;

import java.util.HashMap;
import java.util.Map;

import com.webshar.reveal.inference.rule.operations.Operator;
import com.webshar.reveal.inference.rule.operations.operators.EqualityOperator;

public class RuleOperationType {
	private Map<String, Operator> operationMap = new HashMap<String, Operator>() {{
		put("equals", new EqualityOperator());
	}};
}
