package com.capgemini.gameoflife;

import java.util.List;

public class AnimationMaker {

	public static void main(String[] args) {
		Figure gliderFigure = new Figure(Figures.GLIDER);
		Board board = new Board(gliderFigure);
		displayAnimation(board, gliderFigure, 5);
		
		Figure blinkerFigure = new Figure(Figures.BLINKER);
		board = new Board(blinkerFigure);
		displayAnimation(board, blinkerFigure, 5);
		
		Figure frogFigure = new Figure(Figures.FROG);
		board = new Board(frogFigure);
		displayAnimation(board, frogFigure, 5);
	}

	public static void displayAnimation(Board board, Figure figure, int numberOfIteration) {
		display(figure, board.getCells());

		for (int i = 0; i < numberOfIteration - 1; i++) {

			board.executeIteration();
			System.out.println();
			display(figure, board.getCells());
		}
	}
	
	public static void display(Figure figure, List<Cell> cells) {
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
}
