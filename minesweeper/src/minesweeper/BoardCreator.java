package minesweeper;

import java.util.HashMap;

import minesweeper.Cell.Status;
import minesweeper.Cell.Type;

abstract class BoardCreator {
	private HashMap<Point , Cell> board = new HashMap<Point , Cell>();
	private final int width;
	private final int height;
	private MineSetter mineSetter;
	
	BoardCreator(int width, int height, MineSetter mineSetter) {
		this.width = width;
		this.height = height;
		this.mineSetter = mineSetter;
	}
	
	void setWalls(){
		WallSetter wallSetter = new WallSetter(width, height, board);
		wallSetter.setWalls();
	}
	
	void setMines(int n){
		mineSetter.setMines(n);
	}

	void setNumbers(){
		NumberSetter numberSetter = new NumberSetter(width, height, board);
		numberSetter.setNumbers();
	}
	
	HashMap<Point , Cell> getBoard(){
		return board;
	}
}
