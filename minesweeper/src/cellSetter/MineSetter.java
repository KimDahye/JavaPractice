package cellSetter;

import java.util.HashMap;

import minesweeper.Cell;
import minesweeper.Point;

public interface MineSetter{
	void setMine(Point point);
	void setMines(int n);
	HashMap<Point, Cell> getBoard();
}
