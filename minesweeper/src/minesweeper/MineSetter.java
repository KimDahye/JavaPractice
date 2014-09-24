package minesweeper;

import java.util.HashMap;

interface MineSetter{
	void setMine(Point point);
	void setMines(int n);
	HashMap<Point, Cell> getBoard();
}
