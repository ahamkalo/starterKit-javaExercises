package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

	@Test
	public void shouldReturnClubs() {
		Card card = new Card(Values.ACE, Suits.CLUBS);
		assertEquals(Suits.CLUBS, card.getSuit());
	}
	@Test
	public void shouldReturnAce() {
		Card card = new Card(Values.ACE, Suits.CLUBS);
		assertEquals(Values.ACE, card.getValue());
	}
}
