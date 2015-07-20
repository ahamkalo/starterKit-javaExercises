package com.capgemini.taxi;

import java.util.Comparator;

public class TaxiComparator implements Comparator<Taxi> {
	public int compare(Taxi taxi, Taxi otherTaxi) {
		return Integer.compare(taxi.getDistance(), otherTaxi.getDistance());
	}
}
