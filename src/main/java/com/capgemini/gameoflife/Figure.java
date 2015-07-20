package com.capgemini.gameoflife;

public class Figure {
	private static final int X_LENGTH = 6;
	private static final int Y_LENGTH = 6;
	private boolean[][] array;

	public Figure(Figures figure) {
		array = createBooleanArray(X_LENGTH, Y_LENGTH);
		switch (figure) {
		case BLANK:
			break;
		case GLIDER:
			setGliderFigure();
			break;
		case BLINKER:
			setBlinkerFigure();
			break;
		case FROG:
			setFrogFigure();
			break;
		default:
		}
	}
	
	private boolean[][] createBooleanArray(int x, int y) {
		boolean[][] array = new boolean[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				array[i][j] = false;
			}
		}

		return array;
	}

	private void setGliderFigure() {
		array[0][1] = true;
		array[1][2] = true;
		array[2][0] = true;
		array[2][1] = true;
		array[2][2] = true;
	}
	
	private void setFrogFigure() {
		array[1][2] = true;
		array[2][2] = true;
		array[3][2] = true;
		array[2][3] = true;
		array[3][3] = true;
		array[4][3] = true;
		
	}

	private void setBlinkerFigure() {
		array[1][2] = true;
		array[2][2] = true;
		array[3][2] = true;
	}
	
	public boolean[][] getFigure(){
		return array;
	}
}
