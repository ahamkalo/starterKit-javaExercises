package com.capgemini.taxi;

import java.util.ArrayList;

public interface Observer {
	String getCity();
	void setCity(String city);
	Position getPosition();
	void update(ArrayList<Taxi> nearestTaxis);
}
