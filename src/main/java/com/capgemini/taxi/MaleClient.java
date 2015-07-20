package com.capgemini.taxi;

import java.util.ArrayList;

public class MaleClient extends TaxiClient {

	public MaleClient(Position position, String name) {
		super(position, name);
	}

	@Override
	public void update(ArrayList<Taxi> nearestTaxis) {
		this.nearestTaxis = nearestTaxis;
		System.out.println();
		System.out.println("The nearest availble taxis for : " + name + " in " + city);
		for (Taxi taxi : nearestTaxis) {
			System.out.println("Id: " + taxi.getId() + ", " + taxi.getDistance() + " meters from his location.");
		}
	}

}
