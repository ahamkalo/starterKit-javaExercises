package com.capgemini.pokerHands;

import java.util.HashMap;
import java.util.Map;

public enum Values {
	TWO("2"), 
	THREE("3"), 
	FOUR("4"), 
	FIVE("5"), 
	SIX("6"), 
	SEVEN("7"), 
	EIGHT("8"), 
	NINE("9"), 
	TEN("T"), 
	JACK("J"), 
	QUEEN("Q"), 
	KING("K"), 
	ACE("A");

	private final String signature;

	Values(String signature) {
		this.signature = signature;
	}
	
	public static Values findByKey(String signature){
		return map.get(signature);
	}
	
	private static final Map<String,Values> map = new HashMap<String,Values>();
	static{
		for (Values value : Values.values()) {
			map.put(value.signature, value);
		}
	}
}
