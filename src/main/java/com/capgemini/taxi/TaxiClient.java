package com.capgemini.taxi;

import java.util.ArrayList;

public class TaxiClient implements Observer{
	protected ArrayList<Taxi> nearestTaxis;
	private Position position;
	protected String name;
	protected String city;
	
	public TaxiClient(Position position, String name) {
		this.position = position;
		this.name = name;
		city = "none";
		nearestTaxis = new ArrayList<Taxi>();
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void update(ArrayList<Taxi> nearestTaxis) {
		this.nearestTaxis = nearestTaxis;
		System.out.println();
		System.out.println("The nearest availble taxis for : " + name + " in " + city);
		for (Taxi taxi : nearestTaxis) {
			System.out.println("Id: " + taxi.getId() + ", " + taxi.getDistance() + " meters from his location.");
		}
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;

	}

}
