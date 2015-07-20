package com.capgemini.taxi;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClientTest {

	@Test
	public void shouldProperlyCreateObject() {
		FemaleClient client = new FemaleClient(new Position(1,3),"Jan");
		assertEquals(1, client.getPosition().getXPosition());
		assertEquals(3, client.getPosition().getYPosition());
	}
	@Test
	public void shouldProperlySetPosition() {
		FemaleClient client = new FemaleClient(new Position(1,3),"Jan");
		client.setPosition(new Position(2,4));
		assertEquals(2, client.getPosition().getXPosition());
		assertEquals(4, client.getPosition().getYPosition());
	}


}
