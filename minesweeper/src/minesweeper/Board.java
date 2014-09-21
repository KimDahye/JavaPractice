//BoardCreator 클래스, MineSweeperGame 클래스의 일부로 대체될 예정(즉, 이 클래스는 곧 사라질 클래스임)
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
	
	void setMine(Point point){
		isValidPoint(point);
		board.put(point, new Cell(Type.MINE));
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
	
	boolean changeStatus(Point point, Status status){
		isValidPoint(point);
		if(board.get(point) == null){
			throw new IllegalArgumentException("해당 좌표에 Cell이 아직 할당되지 않아서 상태값을 바꿀 수 없습니다.");
		}
		//원래 해당 좌표 셀의 상태가 CLICKED가 아니었는데, 바꾸려는 상태가 CLICKED이고, 타입이 Zero이면 true를 return.
		if(board.get(point).isSameStatusWith(Status.CLICKED)){
			board.get(point).setStatus(status);
			return false;
		}
		if(status != Status.CLICKED){
			board.get(point).setStatus(status);
			return false;
		}
		if(!board.get(point).isSameTypeWith(Type.ZERO)){
			board.get(point).setStatus(status);
			return false;
		}
		board.get(point).setStatus(status);
		return true;
	}
	
	boolean isEqual(Point point, Cell cell) {
		if(point.getX() > width){
			throw new IllegalArgumentException(String.format("x값이 가로 최대 범위를 초과하였습니다. 가로 최대범위는 %d", width));
		}
		if(point.getY() > height){
			throw new IllegalArgumentException(String.format("y값이 세로 최대 범위를 초과하였습니다. 세로 최대범위는 %d", height));
		}	
		if(board.get(point).equals(cell)){
			return true;
		}
		return false;
	}
}
