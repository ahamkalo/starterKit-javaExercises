package com.capgemini.gameoflife;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	Board board;
	
	@Before
	public void before() {
		board = new Board();
	}

	@Test
	public void shouldProperlyAddNeighboursToCell() {
		List<Cell> cells = new ArrayList<Cell>(Arrays.asList(new Cell(0, 0, false), new Cell(1, 0, false),
				new Cell(0, 1, false)));

		cells = board.addNeighboursToCells(cells);
		List<Cell> neighbours = cells.get(1).getNeighbours();

		assertTrue(neighbours.contains(new Cell(0, 0, false)));
		assertTrue(neighbours.contains(new Cell(0, 1, false)));
		assertFalse(neighbours.contains(new Cell(1, 1, false)));
		assertFalse(neighbours.contains(new Cell(1, 0, false)));
	}

	@Test
	public void shouldProperlyCreateCellList() {
		boolean[][] array = new boolean[][] { { false, true, false }, { false, true, false }, { false, true, false } };
		List<Cell> cells = board.createCellListFrom(array);
		assertTrue(cells.get(1).isAlive());
		assertFalse(cells.get(3).isAlive());
	}
}
