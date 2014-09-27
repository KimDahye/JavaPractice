package cellSetter;

import java.util.HashMap;

import minesweeper.Cell;
import minesweeper.Point;
import minesweeper.Cell.Type;

public class WallSetter extends CellSetter{
	public WallSetter(int width, int height, HashMap<Point, Cell> board){
		super(width, height, board);
	}
	
	public void setWalls(){
		for(int x=0; x < width+2; x++){
			board.put(new Point(x,0), new Cell(Type.WALL));
			board.put(new Point(x,height+1), new Cell(Type.WALL));
		}
		
		for(int y = 1; y < height+1; y++){
			board.put(new Point(0,y), new Cell(Type.WALL));
			board.put(new Point(width+1,y), new Cell(Type.WALL));
		}
	}
}
