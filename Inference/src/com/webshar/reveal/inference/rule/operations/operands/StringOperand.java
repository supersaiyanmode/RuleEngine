package com.webshar.reveal.inference.rule.operations.operands;

import com.webshar.reveal.inference.rule.operations.Operand;

public class StringOperand implements Operand {

	private final String value_;

	public StringOperand(String str) {
		this.value_ = str;
	}

	public String value() {
		return value_;
	}

}
