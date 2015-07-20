package com.capgemini.pokerHands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Hand implements Comparable<Hand> {
	private List<Card> cardsInHand;
	private Rank rank;
	private TreeMap<Values, Integer> map;

	public Hand(String cardsString) {
		cardsInHand = new ArrayList<Card>();
		map = new TreeMap<Values, Integer>();

		addCardsToHand(cardsString);
		putToTreeMap();
		setRank();
	}

	private TreeMap<Values, Integer> deepMapCopy(TreeMap<Values, Integer> original) {

		TreeMap<Values, Integer> copy = new TreeMap<Values, Integer>();
		for (Entry<Values, Integer> entry : original.entrySet()) {
			copy.put(entry.getKey(), entry.getValue());
		}
		return copy;
	}

	public TreeMap<Values, Integer> getMap() {
		return map;
	}

	public int compareTo(Hand otherHand) {
		int comparisonResult = rank.compareTo(otherHand.rank);
		if (isNotEqualZero(comparisonResult)) {
			return comparisonResult;
		} else {
			comparisonResult = compareHandsWithEqualRanks(otherHand);
		}
		return comparisonResult;
	}

	private int compareHandsWithEqualRanks(Hand otherHand) {
		int comparisonResult;
		int max = maximumValueInMap(map);
		switch (max) {
		case 4:
		case 3:
			comparisonResult = getKeyWithValue(max).compareTo(otherHand.getKeyWithValue(max));
			break;
		default:
			comparisonResult = compare(otherHand);
		}
		return comparisonResult;
	}

	public Rank getRank() {
		return rank;
	}

	public List<Card> getCardsFromHand() {
		return cardsInHand;
	}

	private void addCardsToHand(String cardsString) {
		for (String cardString : cardsString.split(" ")) {
			cardsInHand.add(new Card(Values.findByKey(cardString.substring(0, 1)),
					Suits.findByKey(cardString.substring(1, 2))));
		}
	}

	private void putToTreeMap() {
		for (Card card : cardsInHand) {
			if (map.containsKey(card.getValue())) {
				int value = map.get(card.getValue());
				map.put(card.getValue(), ++value);
			} else {
				map.put(card.getValue(), 1);
			}
		}
	}

	private void setRank() {
		switch (maximumValueInMap(map)) {
		case 4:
			rank = Rank.FOUR_OF_A_KIND;
			break;
		case 3:
			rank = Rank.THREE_OF_A_KIND;
			if (hasPair()) {
				rank = Rank.FULL_HOUSE;
			}
			break;
		case 2:
			rank = Rank.ONE_PAIR;
			if (hasTwoPairs()) {
				rank = Rank.TWO_PAIRS;
			}
			break;
		case 1:
			if (isHighCard()) {
				rank = Rank.HIGH_CARD;
			}
			if (isStraight()) {
				rank = Rank.STRAIGHT;
			}
			if (isFlush()) {
				rank = Rank.FLUSH;
			}
			if (isStraightFlush()) {
				rank = Rank.STRAIGHT_FLUSH;
			}
			if (isRoyalFlush()) {
				rank = Rank.ROYAL_FLUSH;
			}
			break;
		default:
		}
	}

	private boolean isNotEqualZero(int result) {
		return result != 0;
	}

	private int compare(Hand otherHand) {
		TreeMap<Values, Integer> mapCopy = deepMapCopy(map);
		TreeMap<Values, Integer> otherMapCopy = deepMapCopy(otherHand.map);

		int temporaryResult = getKeyWithValue(1).compareTo(otherHand.getKeyWithValue(1));
		mapCopy.remove(getKeyWithValue(1));
		otherMapCopy.remove(otherHand.getKeyWithValue(1));

		if (mapCopy.size() == 3) {
			int result = getKeyWithValue(2).compareTo(otherHand.getKeyWithValue(2));
			if (isNotEqualZero(result)) {
				return result;
			}
			mapCopy.remove(getKeyWithValue(2));
			otherMapCopy.remove(otherHand.getKeyWithValue(2));
		}

		while (mapCopy.lastKey().compareTo(otherMapCopy.lastKey()) == 0) {
			mapCopy.remove(mapCopy.lastKey());
			otherMapCopy.remove(otherMapCopy.lastKey());
			if (mapCopy.isEmpty()) {
				return temporaryResult;
			}
		}

		return mapCopy.lastKey().compareTo(otherMapCopy.lastKey());
	}

	private Integer maximumValueInMap(TreeMap<Values, Integer> map) {
		return Collections.max(map.values());
	}

	private boolean hasTwoPairs() {
		if (map.containsValue(2) && map.size() == 3) {
			return true;
		}
		return false;
	}

	private boolean hasPair() {
		if (map.containsValue(2)) {
			return true;
		}
		return false;
	}

	private boolean isHighCard() {
		if (!haveCardsTheSameSuit() && !hasConsecutiveValues()) {
			return true;
		}
		return false;
	}

	private boolean isFlush() {
		if (haveCardsTheSameSuit() && !hasConsecutiveValues()) {
			return true;
		}
		return false;
	}

	private boolean isStraightFlush() {
		if (haveCardsTheSameSuit() && hasConsecutiveValues() && !hasContainAce()) {
			return true;
		}
		return false;
	}

	private boolean isStraight() {
		if (!haveCardsTheSameSuit() && hasConsecutiveValues()) {
			return true;
		}
		return false;
	}

	private boolean isRoyalFlush() {
		if (haveCardsTheSameSuit() && hasConsecutiveValues() && hasContainAce()) {
			return true;
		}
		return false;
	}

	private boolean haveCardsTheSameSuit() {
		Suits suit = cardsInHand.get(0).getSuit();
		for (Card card : cardsInHand) {
			if (!card.getSuit().equals(suit)) {

				return false;
			}
		}
		return true;
	}

	private boolean hasConsecutiveValues() {
		if ((map.lastKey().ordinal() - map.firstKey().ordinal()) == 4) {
			return true;
		}
		return false;
	}

	private boolean hasContainAce() {
		if (map.containsKey(Values.ACE)) {
			return true;
		}
		return false;
	}

	private Values getKeyWithValue(int value) {
		for (Values key : map.keySet()) {
			if (map.get(key).equals(value)) {
				return key;
			}
		}
		return null;
	}
}
