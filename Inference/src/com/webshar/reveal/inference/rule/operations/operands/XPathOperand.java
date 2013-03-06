package com.webshar.reveal.inference.rule.operations.operands;

import javax.xml.xpath.XPathExpression;

import com.webshar.reveal.inference.rule.operations.Operand;

public class XPathOperand implements Operand {
	XPathExpression expression;
	
	public XPathOperand(XPathExpression expression) {
		this.expression = expression;
	}
}
