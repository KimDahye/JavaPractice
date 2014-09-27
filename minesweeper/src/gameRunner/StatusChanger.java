package gameRunner;

import java.util.ArrayList;
import java.util.HashMap;

import cellSetter.NumberSetter;
import minesweeper.Cell;
import minesweeper.Point;
import minesweeper.Cell.Status;
import minesweeper.Cell.Type;

public class StatusChanger {
	private HashMap<Point, Cell> board;
	private final int width;
	private final int height;
	
	StatusChanger(HashMap<Point, Cell> board, int width, int height){
		this.board = board;
		this.width = width;
		this.height = height;
	}
	
	void changeStatus(Point point, Status status) {
		if(status == Status.FLAGED){
			changeStatusOnce(point, status);
		}
		else if(status == Status.CLICKED){
			if(!board.get(point).isSameTypeWith(Type.ZERO)){
				changeStatusOnce(point, status);
				return;
			}
			changeStatusOnce(point, status);
			changeStatusContinuously(point);
		}
	}
	
	private boolean changeStatusOnce(Point point, Status status){
		point.isValidContainingWall(width, height);
		
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
	
	private int changeStatusContinuously(Point point){
		ArrayList<Point> pointsOfZeros = new ArrayList<Point>(); 
		ArrayList<Point> surroundingPoints = NumberSetter.getSurroundingPoints(new Point(point.getX(), point.getY()));
		int result = 0;
		
		for(Point surroundingPoint : surroundingPoints){
			if(changeStatusOnce(surroundingPoint, Status.CLICKED)){
				pointsOfZeros.add(surroundingPoint);
			}
		}

		for(Point pointOfZero : pointsOfZeros){
			result = result + changeStatusContinuously(pointOfZero);
		}
		
		return result;
	}
}
