package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import org.junit.Test;

public class SuitsTest {

	@Test
	public void shouldReturnClubs() {
		assertEquals(Suits.CLUBS, Suits.findByKey("C"));
	}

	@Test
	public void shouldNotReturnClubs() {
		assertNotEquals(Suits.CLUBS, Suits.findByKey("S"));
	}

	@Test
	public void shouldReturnNull() {
		assertEquals(null, Suits.findByKey("P"));
	}
}
