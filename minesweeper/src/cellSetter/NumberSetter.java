package cellSetter;

import java.util.ArrayList;
import java.util.HashMap;

import minesweeper.Cell;
import minesweeper.Point;
import minesweeper.Cell.Type;

public class NumberSetter extends CellSetter{
	public NumberSetter(int width, int height, HashMap<Point, Cell> board){
		super(width, height, board);
	}
	
	public void setNumbers(){
		for(int x = 1; x<width+1; x++){
			for(int y = 1; y <height+1; y++){
				setNumber(new Point(x,y));
			}
		}
	}
	
	void setNumber(Point point){
		point.isValid(width, height);
		if(board.containsKey(point) && board.get(point).isSameTypeWith(Type.MINE)){
			return;
		}
		int count = howManyMinesAround(point);
		board.put(point, new Cell(count));
	}

	private int howManyMinesAround(Point point){
		point.isValid(width, height);
		int count = 0;
		ArrayList<Point> surroundingPoints = getSurroundingPoints(new Point(point.getX(), point.getY()));
		for(Point surroundingPoint : surroundingPoints){
			if(board.containsKey(surroundingPoint) && board.get(surroundingPoint).isSameTypeWith(Type.MINE)){
				count++;
			}
		}
		return count;
	}

	public static ArrayList<Point> getSurroundingPoints(Point point) {
		ArrayList<Point> result = new ArrayList<Point>();
		int x = point.getX();
		int y = point.getY();
		for(int height = y-1; height< y+2; height++){
			for(int width = x-1; width< x+2; width++){
				if(width == x && height == y){
					continue;
				}
				result.add(new Point(width, height));
			}
		}
		return result;
	}
}
