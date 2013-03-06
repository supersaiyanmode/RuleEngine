package com.webshar.reveal.inference;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.webshar.reveal.inference.exceptions.BadXMLException;
import com.webshar.reveal.inference.exceptions.BadXPathException;
import com.webshar.reveal.inference.exceptions.ConcordanceException;
import com.webshar.reveal.inference.rule.Rule;
import com.webshar.reveal.inference.rule.RuleCreator;


public class ConcordanceInferenceEngine implements InferenceUnit {
	private final static DocumentBuilderFactory documentBuilderFactory;
	private final static XPath xpath;
	
	private XPathExpression ruleNodesXPath;
	private final List<Rule> rules;
	
	static {
		documentBuilderFactory = DocumentBuilderFactory.newInstance();
		xpath = XPathFactory.newInstance().newXPath();
	}
	
	public ConcordanceInferenceEngine() throws ConcordanceException {
		try {
			ruleNodesXPath = xpath.compile("/rules/rule");
		} catch (XPathExpressionException e) {
			throw (ConcordanceException)new ConcordanceException().initCause(e);
		}
		rules = new LinkedList<Rule>();
	}
	
	public void updateRulesFromXmlStream(InputStream in) throws BadXMLException, BadXPathException {
		final Document xmlDoc;
		try {
			xmlDoc = documentBuilderFactory.newDocumentBuilder().parse(in);
		} catch (ParserConfigurationException e) {
			throw (BadXMLException) new BadXMLException().initCause(e);
		} catch (SAXException e) {
			throw (BadXMLException) new BadXMLException().initCause(e);
		} catch (IOException e) {
			throw (BadXMLException) new BadXMLException().initCause(e);
		}
		
		final NodeList ruleSet;
		try {
			ruleSet = (NodeList) ruleNodesXPath.evaluate(xmlDoc, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			throw (BadXPathException) new BadXPathException().initCause(e);
		}
		
		rules.clear();
		
		for (int i=0, len=ruleSet.getLength(); i<len; i++) {
			rules.add(RuleCreator.create(ruleSet.item(i)));
		}
	}
	
	
	
	@Override
	public List<String> process(RevealXml obj) {
		final List<String> response = new LinkedList<String>();
		
		
		return response;
	}
}
