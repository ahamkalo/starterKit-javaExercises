package com.capgemini.taxi;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class TaxiClientTest {

	@Test
	public void shouldProperlyCreateObject() {
		FemaleClient client = new FemaleClient(new Position(1, 3), "Jan");
		assertEquals(1, client.getPosition().getXPosition());
		assertEquals(3, client.getPosition().getYPosition());
		assertEquals("none", client.getCity());
		assertEquals("Jan", client.getName());
	}

	@Test
	public void shouldProperlySetPosition() {
		FemaleClient client = new FemaleClient(new Position(1, 3), "Jan");
		client.setPosition(new Position(2, 4));
		assertEquals(2, client.getPosition().getXPosition());
		assertEquals(4, client.getPosition().getYPosition());
	}
	@Test
	public void shouldProperlySetCity() {
		FemaleClient client = new FemaleClient(new Position(1, 3), "Jan");
		client.setCity("Krakow");
		assertEquals("Krakow", client.getCity());
	}
	@Test
	public void shouldUpdateNearestTaxis() {
		FemaleClient client = new FemaleClient(new Position(1, 3), "Jan");
		ArrayList<Taxi> taxis = new ArrayList<Taxi>(
				Arrays.asList(new Taxi(1, new Position(1, 1)), new Taxi(2, new Position(2, 2))));
		assertEquals(0, client.getNearestTaxis().size());
		client.update(taxis);
		assertEquals(1, client.getNearestTaxis().get(0).getPosition().getXPosition());
		assertEquals(2, client.getNearestTaxis().get(1).getPosition().getYPosition());
		assertEquals(2, client.getNearestTaxis().size());
	}

}
