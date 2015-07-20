package com.capgemini.taxi;

import static org.junit.Assert.*;

import org.junit.Test;

public class PositionTest {

	@Test
	public void shouldProperlyCreateObject() {
		Position position = new Position(3,7);
		assertEquals(3, position.getXPosition());
		assertEquals(7, position.getYPosition());
	}
	@Test
	public void shouldProperlySetXValue() {
		Position position = new Position(3,7);
		position.setXPosition(2);
		assertEquals(2, position.getXPosition());
	}
	@Test
	public void shouldProperlySetYValue() {
		Position position = new Position(3,7);
		position.setYPosition(8);
		assertEquals(8, position.getYPosition());
	}

}
