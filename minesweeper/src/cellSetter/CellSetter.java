package cellSetter;

import java.util.HashMap;

import cell.Cell;
import minesweeper.Point;

public abstract class CellSetter {
	HashMap<Point , Cell> board = new HashMap<Point , Cell>();
	protected final int width;
	protected final int height;
	
	CellSetter(int width, int height, HashMap<Point, Cell> board){
		this.board = board;
		this.width = width;
		this.height = height;
	}
}
