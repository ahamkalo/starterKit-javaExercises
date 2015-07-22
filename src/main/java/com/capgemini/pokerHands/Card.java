package com.capgemini.pokerHands;

public class Card {
	private Suits suit;
	private Values value;
	
	public Card(Values value, Suits suit){
		this.value = value;
		this.suit = suit;
	}

	public Suits getSuit() {
		return suit;
	}

	public Values getValue() {
		return value;
	}
}
