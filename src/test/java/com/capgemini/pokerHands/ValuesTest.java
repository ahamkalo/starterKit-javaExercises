package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValuesTest {
	@Test
	public void shouldReturnKing() {
		assertEquals(Values.KING, Values.findByKey("K"));
	}
	@Test
	public void shouldNotReturnKing() {
		assertNotEquals(Values.KING, Values.findByKey("T"));
	}
	@Test
	public void shouldReturnNull() {
		assertEquals(null, Values.findByKey("P"));
	}
}
