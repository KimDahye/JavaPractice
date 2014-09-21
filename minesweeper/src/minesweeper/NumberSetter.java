package minesweeper;

import java.util.HashMap;

import minesweeper.Cell.Type;

public class NumberSetter extends CellSetter{
	NumberSetter(int width, int height, HashMap<Point, Cell> board){
		super(width, height, board);
	}
	
	void setNumbers(){
		for(int x = 1; x<width+1; x++){
			for(int y = 1; y <height+1; y++){
				setNumber(new Point(x,y));
			}
		}
	}
	
	void setNumber(Point point){
		isValidPoint(point);
		if(board.containsKey(point) && board.get(point).isSameTypeWith(Type.MINE)){
			return;
		}
		int count = howManyMinesAround(point);
		board.put(point, new Cell(count));
	}
	
	private int howManyMinesAround(Point point){
		isValidPoint(point);
		
		int count = 0;
		int x = point.getX();
		int y = point.getY();
		if(board.containsKey(new Point(x-1,y-1)) && board.get(new Point(x-1,y-1)).isSameTypeWith(Type.MINE)){
			count++;
		}
		if(board.containsKey(new Point(x-1,y)) && board.get(new Point(x-1,y)).isSameTypeWith(Type.MINE)){
			count++;
		}
		if(board.containsKey(new Point(x-1,y+1)) && board.get(new Point(x-1,y+1)).isSameTypeWith(Type.MINE)){
			count++;
		}
		if(board.containsKey(new Point(x,y-1)) && board.get(new Point(x,y-1)).isSameTypeWith(Type.MINE)){
			count++;
		}
		if(board.containsKey(new Point(x,y+1)) && board.get(new Point(x,y+1)).isSameTypeWith(Type.MINE)){
			count++;
		}
		if(board.containsKey(new Point(x+1,y-1)) && board.get(new Point(x+1,y-1)).isSameTypeWith(Type.MINE)){
			count++;
		}
		if(board.containsKey(new Point(x+1,y)) && board.get(new Point(x+1,y)).isSameTypeWith(Type.MINE)){
			count++;
		}
		if(board.containsKey(new Point(x+1,y+1)) && board.get(new Point(x+1,y+1)).isSameTypeWith(Type.MINE)){
			count++;
		}
		
		return count;
	}
}
