package com.webshar.reveal.inference.rule.operations.operationresult;

import com.webshar.reveal.inference.rule.operations.OperationResult;

public class BooleanOperationResult extends OperationResult {
	private boolean value_;

	public BooleanOperationResult(boolean value) {
		this.value_ = value;
	}

	@Override
	public boolean booleanResult() {
		return this.value_;
	}
}
