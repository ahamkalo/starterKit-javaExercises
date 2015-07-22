package com.capgemini.gameoflife;

import static org.junit.Assert.*;

import org.junit.Test;

public class FigureTest {

	@Test
	public void shouldCreateBlinkerkFigure() {
		Figure blinkerFigure = new Figure(Figures.BLINKER);
		boolean[][] array = blinkerFigure.getFigure();
		assertTrue(array[1][2]);
		assertTrue(array[2][2]);
		assertTrue(array[3][2]);
		assertFalse(array[1][1]);
	}
	@Test
	public void shouldCreateBlankFigure() {
		Figure blankFigure = new Figure(Figures.BLANK);
		boolean[][] array = blankFigure.getFigure();
		for (boolean[] row : array) {
			for (boolean state : row) {
				assertFalse(state);
			}
		}
	}
}
