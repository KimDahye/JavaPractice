package minesweeper;

import java.util.HashMap;

public abstract class CellSetter {
	HashMap<Point , Cell> board = new HashMap<Point , Cell>();
	final int width;
	final int height;
	
	CellSetter(int width, int height, HashMap<Point, Cell> board){
		this.board = board;
		this.width = width;
		this.height = height;
	}
	
	void isValidPoint(Point point){
		if(point.getX() < 1){
			throw new IllegalArgumentException("x값은 1 이상이어야 합니다.");
		}
		if(point.getY() < 1){
			throw new IllegalArgumentException("y값은 1 이상이어야 합니다.");
		}
		if(point.getX() > width){
			throw new IllegalArgumentException(String.format("x값이 가로 최대 범위를 초과하였습니다. 가로 최대범위는 %d", width));
		}
		if(point.getY() > height){
			throw new IllegalArgumentException(String.format("y값이 세로 최대 범위를 초과하였습니다. 세로 최대범위는 %d", height));
		}
	}
}
