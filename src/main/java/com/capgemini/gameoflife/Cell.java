package com.capgemini.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	private int x;
	private int y;
	private boolean currentState;
	private boolean nextState;
	private List<Cell> neighbours = new ArrayList<Cell>();

	public Cell(int x, int y, boolean state) {
		this.x = x;
		this.y = y;
		currentState = state;
	}
	
	public void addNeighbours(Cell neighbour) {
		neighbours.add(neighbour);
	}

	public boolean isAlive() {
		return currentState;
	}


	public void updateNextState() {
		int count = 0;
		for (Cell neighbour : neighbours) {
			if (neighbour.isAlive()) {
				count++;
			}
		}
		switch (count) {
		case 2:
			if (isAlive()) {
				this.nextState = true;
			} else {
				this.nextState = false;
			}
			break;
		case 3:
			this.nextState = true;
			break;
		default:
			this.nextState = false;
		}

	}
	
	public void updateCurrentState(){
		this.currentState = this.nextState;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean getNextState() {
		return nextState;
	}

	public List<Cell> getNeighbours() {
		return neighbours;
	}

	@Override
	public boolean equals(Object obj) {
		Cell other = (Cell) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
