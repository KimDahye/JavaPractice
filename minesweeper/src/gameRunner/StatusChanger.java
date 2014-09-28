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
			board.get(point).flaged();
			return;
		}
		else if(status == Status.CLICKED){
			if(!board.get(point).isSameTypeWith(Type.ZERO)){
				board.get(point).clicked();
				return;
			}
			board.get(point).clicked();
			clickSurroundingPoints(point);
		}
	}
	
	private boolean isNonClickedZero(Point point){
		point.isValidContainingWall(width, height);
		
		if(board.get(point) == null){
			throw new IllegalArgumentException("해당 좌표에 Cell이 아직 할당되지 않아서 상태값을 바꿀 수 없습니다.");
		}

		if(board.get(point).isSameStatusWith(Status.CLICKED)){
			return false;
		}
		if(!board.get(point).isSameTypeWith(Type.ZERO)){
			board.get(point).clicked();
			return false;
		}
		board.get(point).clicked();
		return true;
	}
	
	private int clickSurroundingPoints(Point point){
		ArrayList<Point> pointsOfZeros = new ArrayList<Point>(); 
		ArrayList<Point> surroundingPoints = NumberSetter.getSurroundingPoints(new Point(point.getX(), point.getY()));
		int result = 0;
		
		for(Point surroundingPoint : surroundingPoints){
			if(isNonClickedZero(surroundingPoint)){
				pointsOfZeros.add(surroundingPoint);
			}
		}

		for(Point pointOfZero : pointsOfZeros){
			result = result + clickSurroundingPoints(pointOfZero);
		}
		
		return result;
	}
}
