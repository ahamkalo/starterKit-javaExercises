package com.capgemini.taxi;

import java.util.ArrayList;

public class TaxiClient implements Observer{
	protected ArrayList<Taxi> nearestTaxis;
	private Position position;
	private String name;
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

	}

	public String getCity() {
		return city;
	}

	public String getName() {
		return name;
	}

	public void setCity(String city) {
		this.city = city;
		
	}

	public ArrayList<Taxi> getNearestTaxis() {
		return nearestTaxis;
	}

}
