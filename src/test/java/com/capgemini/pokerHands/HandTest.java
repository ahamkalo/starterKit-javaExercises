package com.capgemini.pokerHands;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class HandTest {
	private static List<String> cardSetsAscending;
	static List<String> cardSets;
	static List<String> otherCardSets;

	@BeforeClass
	public static void beforeClass() {
		cardSetsAscending = new ArrayList<String>(
				Arrays.asList("9C 8S AD 2H 4S", "8C 8S 3D 4H 5S", "8C 8S AD AH 4S", "TS TC TH KS AS", "2S 3S 4C 5S 6S",
						"2S 3S 4S 5S 8S", "5C 5S 5D 8H 8S", "5C 5S 5D 5H 8S", "2S 3S 4S 5S 6S", "TS JS QS KS AS"));
	}

	@Test
	public void shouldSetProperlyRank() {
		for (int i = 0; i < cardSetsAscending.size(); i++) {
			assertEquals(i, new Hand(cardSetsAscending.get(i)).getRank().ordinal());
		}
	}

	@Test
	public void shouldAddProperlyCardsToHand() {
		assertEquals(Values.SIX, new Hand("AC 8C 2S QH 6D").getCardsFromHand().get(4).getValue());
		assertEquals(Suits.SPADES, new Hand("AC 8C 2S QH 6D").getCardsFromHand().get(2).getSuit());
	}

	@Test
	public void shouldAddProperlyCardsToMap() {
		Hand hand = new Hand("AC AS 2S QH 6D");
		assertTrue(hand.getMap().containsKey(Values.ACE));
		assertFalse(hand.getMap().containsKey(Values.FIVE));

		assertEquals((Integer) 2, hand.getMap().get(Values.ACE));
		assertEquals((Integer) 1, hand.getMap().get(Values.SIX));
	}

	@Test
	public void shouldFirstHandWinForOtherRanks() {
		assertTrue(new Hand(cardSetsAscending.get(1)).compareTo(new Hand(cardSetsAscending.get(0))) > 0);
	}

	@Test
	public void shouldSecondHandWinForOtherRanks() {
		assertTrue(new Hand(cardSetsAscending.get(0)).compareTo(new Hand(cardSetsAscending.get(1))) < 0);
	}

	@Test
	public void shouldReturnTie() {
		cardSets = new ArrayList<String>(Arrays.asList("9S 8C AH 2C 4C", "8D 8H 3C 4C 5H", "8D 8H AC AS 4C",
				"2S 3S 4C 5S 6S", "2S 3S 4S 5S 8S", "2S 3S 4S 5S 6S", "TS JS QS KS AS"));
		for (String cardSet : cardSets) {
			assertTrue(new Hand(cardSet).compareTo(new Hand(cardSet)) == 0);
		}
	}

	@Test
	public void shouldFirstHandWinForTheSameRanks() {
		String errorMessage;
		otherCardSets = new ArrayList<String>(
				Arrays.asList("8C 8S 8D 8H 4S", "7C 7S 7D 7H AC", "8C 8S 8D KH 4S", "7C 7S 7D 3H AC", "8C 8S 8D KH KS",
						"7C 7S 7D 3H 3C", "KS 7S 5S 3S 2S", "TC 8C 6C 4C 9C", "5C 6S 7D 8H 9S", "2C 3S 4D 5H 6C",
						"4S 5S 6S 7S 8S", "2C 3C 4C 5C 6C", "8C 8S KD 4H 5S", "8D 8H 3D 6H 9C", "8C 8S KD 4H 5S",
						"7D 7H 3D 6H 9C", "7C 7S AD AH 4S", "7C 7S QD QH AC", "TC 8S AD 2H 4S", "9H 8D AC 2S 4C"));
		for (int i = 0; i < otherCardSets.size(); i = i + 2) {
			errorMessage = otherCardSets.get(i) + " vs " + otherCardSets.get(i + 1);
			assertTrue(errorMessage, new Hand(otherCardSets.get(i)).compareTo(new Hand(otherCardSets.get(i + 1))) > 0);
		}
	}
}
