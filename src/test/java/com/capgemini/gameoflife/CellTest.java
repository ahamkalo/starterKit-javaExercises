package com.capgemini.gameoflife;

import static org.junit.Assert.*;

import org.junit.Test;

public class CellTest {

	@Test
	public void shouldReturnIsAlive() {
		Cell cell = new Cell(1,1,true);
		assertTrue(cell.isAlive());
	}
	@Test
	public void shouldReturnIsNotAlive() {
		Cell cell = new Cell(1,1,false);
		assertFalse(cell.isAlive());
	}
	@Test
	public void shouldSetNextStateToFalseFor1AliveNeighbour() {
		Cell cell = new Cell(1,1,true);
		cell.addNeighbours(new Cell(0,0,true));
		cell.updateNextState();

		assertFalse(cell.getNextState());
	}
	@Test
	public void shouldSetNextStateToFalseFor2AliveNeighbour() {
		Cell cell = new Cell(1,1,false);
		cell.addNeighbours(new Cell(0,0,true));
		cell.addNeighbours(new Cell(0,1,true));
		cell.updateNextState();

		assertFalse(cell.getNextState());
	}
	@Test
	public void shouldSetNextStateToTrueFor2AliveNeighbour() {
		Cell cell = new Cell(1,1,true);
		cell.addNeighbours(new Cell(0,0,true));
		cell.addNeighbours(new Cell(0,1,true));
		cell.updateNextState();

		assertTrue(cell.getNextState());
	}
	@Test
	public void shouldSetNextStateToTrueFor3AliveNeighbour() {
		Cell cell = new Cell(1,1,false);
		cell.addNeighbours(new Cell(0,0,true));
		cell.addNeighbours(new Cell(0,1,true));
		cell.addNeighbours(new Cell(0,1,true));
		cell.updateNextState();
		
		assertTrue(cell.getNextState());
	}
	@Test
	public void shouldSetNextStateToFalseFor4AliveNeighbour() {
		Cell cell = new Cell(1,1,false);
		cell.addNeighbours(new Cell(0,0,true));
		cell.addNeighbours(new Cell(0,1,true));
		cell.addNeighbours(new Cell(0,1,true));
		cell.addNeighbours(new Cell(0,1,true));
		cell.updateNextState();
		
		assertFalse(cell.getNextState());
	}
	@Test
	public void shouldUpdateCurrentStateToTrue() {
		Cell cell = new Cell(1,1,false);
		cell.addNeighbours(new Cell(0,0,true));
		cell.addNeighbours(new Cell(0,1,true));
		cell.addNeighbours(new Cell(0,1,true));
		cell.updateNextState();
		cell.updateCurrentState();
		
		assertTrue(cell.isAlive());
	}
	@Test
	public void shouldUpdateCurrentStateToFalse() {
		Cell cell = new Cell(1,1,false);

		cell.updateNextState();
		cell.updateCurrentState();
		
		assertFalse(cell.isAlive());
	}
	@Test
	public void shouldReturnThatCellsAreEqual() {
		assertEquals(new Cell(1,1,false),new Cell(1,1,false));
	}
	@Test
	public void shouldReturnThatCellsAreNotEqual() {
		assertNotEquals(new Cell(1,1,false),new Cell(2,1,false));
	}
}
