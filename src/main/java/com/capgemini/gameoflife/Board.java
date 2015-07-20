package com.capgemini.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<Cell> cells = new ArrayList<Cell>();
	
	public Board(){

	}
	
	public Board(Figure figure){
		cells = createCellListFrom(figure.getFigure());
		cells = addNeighboursToCells(cells);
	}

	public List<Cell> addNeighboursToCells(List<Cell> cells) {
		for (Cell cell : cells) {
			for (int i = cell.getX() - 1; i <= cell.getX() + 1; i++) {
				for (int j = cell.getY() - 1; j <= cell.getY() + 1; j++) {
					
					Cell newCell = new Cell(i, j, false);
					
					if (isInListCloneOf(newCell, cells) && !cell.equals(newCell)) {
						int indexOfCloneOfNewCell = cells.indexOf(newCell);
						cell.addNeighbours(cells.get(indexOfCloneOfNewCell));
					}
				}
			}
		}
		return cells;
	}

	private boolean isInListCloneOf(Cell neighbour, List<Cell> cells) {
		if (cells.indexOf(neighbour) >= 0) {
			return true;
		}
		return false;
	}

	public List<Cell> createCellListFrom(boolean[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				cells.add(new Cell(i, j, array[i][j]));
			}
		}
		return cells;
	}

	public void executeIteration() {
		for (Cell cell : cells) {
			cell.updateNextState();
		}

		for (Cell cell : cells) {
			cell.updateCurrentState();
		}
	}

	public void display(Figure figure) {
		int rowLength = figure.getFigure()[0].length;
		int i = 0;
		System.out.println();
		for (Cell cell : cells) {
			if (cell.isAlive()) {
				System.out.print("# ");
			} else {
				System.out.print(". ");
			}

			i++;
			if (i == rowLength) {
				System.out.println();
				i = 0;
			}
		}
	}

	public List<Cell> getCells() {
		return cells;
	}
}
