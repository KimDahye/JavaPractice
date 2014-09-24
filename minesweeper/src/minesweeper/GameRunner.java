package minesweeper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import minesweeper.Cell.Status;
import minesweeper.Cell.Type;

class GameRunner {
	BoardCreator boardCreator;
	final private int NUM_OF_MINES;
	final static int CLICKED = 0; //얘네 enum으로 바꿀까 고민중...
	final static int FLAGED = 1;
	Scanner scanner = new Scanner(System.in);
	
	enum GameStatus { 
		NOT_ENDED, WIN, LOSE; 
	}
	
	GameRunner(BoardCreator boardCreator, int NUM_OF_MINES){
		this.boardCreator = boardCreator;
		this.NUM_OF_MINES = NUM_OF_MINES;
	}
	
	void run(){
		while(whatsGameStatus() == GameStatus.NOT_ENDED){
			printCurrentBoard();
			Point point = receivePoint();
			int status = receiveStatus();
			changeStatusBoard(point, status);
		}
		printCurrentBoard();
		printEndMessage();
	}

	private void printCurrentBoard(){
		boardCreator.printBoard();
	}
	
	private Point receivePoint(){
		return UserInputReceiver.getPoint(boardCreator.getWidth(), boardCreator.getHeight());
	}
	
	private int receiveStatus(){
		return UserInputReceiver.getStatus();
	}
	
	private GameStatus whatsGameStatus(){
		return GameJudge.judge(boardCreator.getBoard(), NUM_OF_MINES);
	}
	
	private void printEndMessage(){
		if(whatsGameStatus() == GameStatus.WIN){
			System.out.println("WIN! 축하합니다 ^_^");
			return;
		}
		System.out.println("LOSE~ 지뢰를 밟으셨네요 ㅠㅠ");
	}
	
	private void changeStatusBoard(Point point, int status) {
		if(status == FLAGED){
			changeStatus(point, Status.FLAGED);
		}
		else if(status == CLICKED){
			if(!boardCreator.getBoard().get(point).isSameTypeWith(Type.ZERO)){
				changeStatus(point, Status.CLICKED);
				return;
			}
			changeStatus(point, Status.CLICKED);
			changeStatusContinuously(point);
		}
	}
	
	boolean changeStatus(Point point, Status status){
		isValidPoint(point);
		HashMap<Point, Cell> board = boardCreator.getBoard();
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
	
	int changeStatusContinuously(Point point){
		ArrayList<Point> pointsOfZeros = new ArrayList<Point>(); 
		int x = point.getX();
		int y = point.getY();
		int result = 0;
		if(isValidPoint(new Point(x-1, y+1)) && changeStatus(new Point(x-1, y+1), Status.CLICKED)){
			pointsOfZeros.add(new Point(x-1, y+1));
		}
		if(isValidPoint(new Point(x, y+1)) && changeStatus(new Point(x, y+1), Status.CLICKED)){
			pointsOfZeros.add(new Point(x, y+1));
		}
		if(isValidPoint(new Point(x+1, y+1)) && changeStatus(new Point(x+1, y+1), Status.CLICKED)){
			pointsOfZeros.add(new Point(x+1, y+1));
		}
		if(isValidPoint(new Point(x+1, y)) && changeStatus(new Point(x+1, y), Status.CLICKED)){
			pointsOfZeros.add(new Point(x+1, y));
		}
		if(isValidPoint(new Point(x+1, y-1)) && changeStatus(new Point(x+1, y-1), Status.CLICKED)){
			pointsOfZeros.add(new Point(x+1, y-1));
		}
		if(isValidPoint(new Point(x, y-1)) && changeStatus(new Point(x, y-1), Status.CLICKED)){
			pointsOfZeros.add(new Point(x, y-1));
		}
		if(isValidPoint(new Point(x-1, y-1)) && changeStatus(new Point(x-1, y-1), Status.CLICKED)){
			pointsOfZeros.add(new Point(x-1, y-1));
		}
		if(isValidPoint(new Point(x-1, y)) && changeStatus(new Point(x-1, y), Status.CLICKED)){
			pointsOfZeros.add(new Point(x-1, y));
		}

		for(Point pointOfZero : pointsOfZeros){
			result = result + changeStatusContinuously(pointOfZero);
		}
		
		return result;	
	}
	
	//없어질 예정
	boolean isValidPoint(Point point){
		if(point == null){
			return false;
		}
		if(point.getX() < 1)
		{
			System.out.println("x값은 1 이상이어야 합니다.");
			return false;
		}
		if(point.getY() < 1){
			System.out.println("y값은 1 이상이어야 합니다.");
			return false;
		}
		if(point.getX() > boardCreator.getWidth()){
			System.out.println(String.format("x값이 가로 최대 범위를 초과하였습니다. 가로 최대범위는 %d. @mineSweeperGame", boardCreator.getWidth()));
			return false;
		}
		if(point.getY() > boardCreator.getHeight()){
			System.out.println(String.format("y값이 세로 최대 범위를 초과하였습니다. 세로 최대범위는 %d. @mineSweeperGame", boardCreator.getHeight()));
			return false;
		}
		return true;
	}
	

}
