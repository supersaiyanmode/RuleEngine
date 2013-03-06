package com.webshar.reveal.inference;

import java.util.LinkedList;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;


public class ConcordanceInferenceEngine implements InferenceUnit {
	private final XPath xpath;
	
	
	public ConcordanceInferenceEngine() {
		xpath = XPathFactory.newInstance().newXPath();
	}
	
	@Override
	public List<String> process(RevealXml obj) {
		final List<String> response = new LinkedList<String>();
		
		
		return response;
	}
	
	public static void main(String s[]) throws Exception{

	}
	
}
