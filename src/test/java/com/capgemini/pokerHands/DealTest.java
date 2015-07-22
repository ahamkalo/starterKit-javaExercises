package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import org.junit.Test;

public class DealTest {
	
	@Test
	public void shouldWinFirstPlayer() {
		Deal deal = new Deal(new Hand("KS 7S 5S 3S 2S"), new Hand("TC 8C 6C 4C 9C"));
		assertEquals(Result.FIRST_PLAYER_WIN, deal.getWinner());
	}
	@Test
	public void shouldWinSecondPlayer() {
		Deal deal = new Deal(new Hand("TC 8C 6C 4C 9C"), new Hand("KS 7S 5S 3S 2S"));
		assertEquals(Result.SECOND_PLAYER_WIN, deal.getWinner());
	}
	@Test
	public void shouldReturnTie() {
		Deal deal = new Deal(new Hand("KS 7S 5S 3S 2S"), new Hand("KC 7C 5C 3C 2C"));
		assertEquals(Result.TIE, deal.getWinner());
	}
}
