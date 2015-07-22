package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	List<String> lines;
	List<Deal> deals;

	@Before
	public void before() {
		lines = new ArrayList<String>();
		deals = new ArrayList<Deal>();
	}

	@Test
	public void shouldReturn2Wins() {
		List<Deal> deals = new ArrayList<Deal>(
				Arrays.asList(new Deal(new Hand("KS 7S 5S 3S 2S"), new Hand("TC 8C 6C 4C 9C")),
						new Deal(new Hand("KS 7S 5S 3S 2S"), new Hand("TC 8C 6C 4C 9C"))));
		assertEquals(2, Game.getNumberOfFirstPlayerWins(deals));
	}
	
	@Test
	public void shouldProperlyCreateDeal() {
		List<String> lines = new ArrayList<String>(Arrays.asList("KS 7S 5S 3S 2S TC 8C 6C 4C 9C"));
		List<Deal> deals = new ArrayList<Deal>();
		deals = Game.createDeals(lines);
				
		assertEquals(Values.FIVE, deals.get(0).getHands().get(0).getCardsFromHand().get(2).getValue());
		assertEquals(Suits.CLUBS, deals.get(0).getHands().get(1).getCardsFromHand().get(3).getSuit());
	}
}
