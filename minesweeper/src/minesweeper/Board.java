package minesweeper;
import java.util.HashMap;

import minesweeper.Cell.Status;
import minesweeper.Cell.Type;;

class Board {
	private HashMap<Point , Cell> board = new HashMap<Point , Cell>();
	private final int width;
	private final int height;
	
	Board(int width, int height) {
		this.width = width;
		this.height = height;
		
		// wall 초기화
		for(int x=0; x < width+2; x++){
			board.put(new Point(x,0), new Cell(Type.WALL));
			board.put(new Point(x,height+1), new Cell(Type.WALL));
		}
		
		for(int y = 1; y < height+1; y++){
			board.put(new Point(0,y), new Cell(Type.WALL));
			board.put(new Point(width+1,y), new Cell(Type.WALL));
		}
	}
	
	void setMine(Point point){
		//랜덤으로 할 수 있는 애가 있을 거고 랜덤이 아닌 수동으로 할 수 있는 애가 있을 거다.
		if(point.getX() > width){
			throw new IllegalArgumentException("x값이 유용한 범위가 아닙니다.");
		}
		if(point.getY() > height){
			throw new IllegalArgumentException("y값이 유용한 범위가 아닙니다.");
		}
		board.put(point, new Cell(Type.MINE));
	}
	
	void setNumber(Point point){
		if(point.getX() > width){
			throw new IllegalArgumentException("x값이 유용한 범위가 아닙니다.");
		}
		if(point.getY() > height){
			throw new IllegalArgumentException("y값이 유용한 범위가 아닙니다.");
		}
		if(board.containsKey(point) && board.get(point).isSameTypeWith(Type.MINE)){
			return;
		}
		int count = howManyMinesAround(point);
		board.put(point, new Cell(count));
	}
	
	private int howManyMinesAround(Point point){
		if(point.getX() > width){
			throw new IllegalArgumentException("x값이 유용한 범위가 아닙니다.");
		}
		if(point.getY() > height){
			throw new IllegalArgumentException("y값이 유용한 범위가 아닙니다.");
		}
		
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
		if(board.containsKey(new Point(x,y+1)) && board.get(new Point(x,y+1)).isSameTypeWith(Type.MINE)){
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
	
	void changeStatus(Point point, Status status){
		if(point.getX() > width){
			throw new IllegalArgumentException("x값이 유용한 범위가 아닙니다.");
		}
		if(point.getY() > height){
			throw new IllegalArgumentException("y값이 유용한 범위가 아닙니다.");
		}
		if(board.get(point) != null){
			board.get(point).setStatus(status);
		}
	}
	
	boolean isEqual(Point point, Cell cell) {
		if(point.getX() > width){
			throw new IllegalArgumentException("x값이 유용한 범위가 아닙니다.");
		}
		if(point.getY() > height){
			throw new IllegalArgumentException("y값이 유용한 범위가 아닙니다.");
		}
		
		if(board.get(point).equals(cell)){
			return true;
		}
		return false;
	}
}
