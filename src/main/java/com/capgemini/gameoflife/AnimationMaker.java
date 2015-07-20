package com.capgemini.gameoflife;

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
		board.display(figure);

		for (int i = 0; i < numberOfIteration - 1; i++) {

			board.executeIteration();
			System.out.println();
			board.display(figure);
		}
	}
}
