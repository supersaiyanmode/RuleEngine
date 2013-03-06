package com.webshar.reveal.inference.rule.operations.operands;

import com.webshar.reveal.inference.rule.operations.Operand;

public class BooleanOperand implements Operand{
	private final boolean value_;
	
	public BooleanOperand(final boolean val) {
		value_ = val;
	}
	
	public boolean value() {
		return value_;
	}

}
