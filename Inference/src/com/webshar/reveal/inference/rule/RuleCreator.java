package com.webshar.reveal.inference.rule;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.webshar.reveal.inference.exceptions.BadXMLException;
import com.webshar.reveal.inference.exceptions.BadXPathException;
import com.webshar.reveal.inference.rule.operations.Operand;
import com.webshar.reveal.inference.rule.operations.operands.BooleanOperand;
import com.webshar.reveal.inference.rule.operations.operands.StringOperand;
import com.webshar.reveal.inference.rule.operations.operands.XPathOperand;


public class RuleCreator {
	private static final String OPERAND_BOOLEAN = "boolean";
	private static final String OPERAND_STRING = "string";
	private static final String OPERAND_XPATH = "xpath";	
	
	private final static XPath xpath;

	private static XPathExpression operatorTypeXpath;
	private static XPathExpression testListXpath;
	
	
	static {
		xpath = XPathFactory.newInstance().newXPath();
		try {
			operatorTypeXpath = xpath.compile("rule/test/@type");
			testListXpath = xpath.compile("rule/test");
		} catch (XPathExpressionException e) {
			// Wont fail, static expression
			System.out.println("THis wont happen!");
		}
	}
	
	public static Rule create(Node node) throws BadXMLException, BadXPathException{
		final Rule rule = new Rule();
		
		String typeStr;
		try {
			typeStr = operatorTypeXpath.evaluate(node);
			rule.type = new RuleOperationType(typeStr);
		} catch (XPathExpressionException e) {
			throw  (BadXMLException) new BadXMLException().initCause(e); 
		} catch (IllegalOperator e) {
			throw  (BadXMLException) new BadXMLException().initCause(e);
		}
		
		NodeList tests = null;
		try {
			tests = (NodeList) testListXpath.evaluate(node,XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			throw (BadXMLException) new BadXMLException().initCause(e);
		}
		
		rule.operands = new BooleanOperand[tests.getLength()];
		
		for (int i=0, len=tests.getLength(); i<len; i++) {
			Node operandNode = tests.item(i).getFirstChild();
			String nodeName = operandNode.getNodeName();
			
			Boolean bVal;
			String str;
			
			switch (nodeName) {
			case OPERAND_BOOLEAN:
				bVal = Boolean.parseBoolean(operandNode.getFirstChild().toString());
				rule.operands[i] = new BooleanOperand(bVal);
				break;
				
			case OPERAND_XPATH:
				str = operandNode.getFirstChild().toString();
				
				XPathExpression expression;
				try {
					expression = xpath.compile(str);
				} catch (XPathExpressionException e) {
					throw (BadXPathException)new BadXPathException().initCause(e);
				}
				rule.operands[i] = new XPathOperand(expression);
				break;
				
			case OPERAND_STRING:
				str = operandNode.getFirstChild().toString();
				rule.operands[i] = new StringOperand(str);
				break;
			}
		}
		
		
		return rule;
	}

}
