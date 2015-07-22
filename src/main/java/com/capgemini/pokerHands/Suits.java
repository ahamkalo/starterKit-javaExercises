package com.capgemini.pokerHands;

import java.util.HashMap;
import java.util.Map;

public enum Suits {
	SPADES("S"), 
	CLUBS("C"), 
	DIAMONDS("D"), 
	HEARTS("H");

	private final String signature;

	Suits(String signature) {
		this.signature = signature;
	}
	
	public static Suits findByKey(String signature) {
		return map.get(signature);
	}

	private static final Map<String,Suits> map = new HashMap<String,Suits>();
	static{
		for (Suits suit : Suits.values()) {
			map.put(suit.signature, suit);
		}
	}
}
