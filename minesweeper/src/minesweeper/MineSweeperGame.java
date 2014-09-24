package minesweeper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import minesweeper.Cell.Status;
import minesweeper.Cell.Type;

class MineSweeperGame {
	BoardCreator boardCreator;
	final private int MAX_MINE_NUM;  
	final static int CLICKED = 0;
	final static int FLAGED = 1;
	
	enum GameStatus { 
		NOTENDED, WIN, LOSE; 
	}
	
	MineSweeperGame(BoardCreator boardCreator, int n){
		this.boardCreator = boardCreator;
		MAX_MINE_NUM = n;
		boardCreator.setWalls();
		boardCreator.setMines(n);
		boardCreator.setNumbers();
	}
	
	void run(){
		Scanner scanner = new Scanner(System.in);
		while(whatsGameStatus() == GameStatus.NOTENDED){
			Point point;
			int status;
			try{
				boardCreator.printBoard();
				System.out.println("x좌표를 입력하세요.");
				int x = Integer.parseInt(scanner.nextLine());
				System.out.println("y좌표를 입력하세요.");
				int y = Integer.parseInt(scanner.nextLine());			
				point = new Point(x, y);
		
				if(!isValidPoint(point)){
					System.out.println("좌표 범위가 올바르지 않습니다.");
					continue;
				}
			
				System.out.println("어떻게 상태를 바꾸시겠습니까? 클릭(0), 깃발(1)");
				status = Integer.parseInt(scanner.nextLine());
				
			}catch(NumberFormatException e){
				continue;
			}
			
			if((int)status == FLAGED){
				changeStatus(point, Status.FLAGED);
			}
			else if((int)status == CLICKED){
				if(!boardCreator.getBoard().get(point).isSameTypeWith(Type.ZERO)){
					changeStatus(point, Status.CLICKED);
					continue;
				}
				changeStatus(point, Status.CLICKED);
				changeStatusContinuously(point);
			}
		}
		scanner.close();
		if(whatsGameStatus() == GameStatus.WIN){
			System.out.println("게임 승리! 축하합니다 ^_^");
			return;
		}
		System.out.println("게임 패배! 지뢰를 밟으셨네요..ㅠㅠ");
	}
	
	GameStatus whatsGameStatus(){
		HashMap<Point, Cell> board = boardCreator.getBoard();
		int count = 0;
		for(Point key : board.keySet()){
			if(board.get(key).isSameTypeWith(Type.MINE)){
				if(board.get(key).isSameStatusWith(Status.CLICKED)){
					return GameStatus.LOSE;
				}
				if(board.get(key).isSameStatusWith(Status.FLAGED)){
					count++;
				}
			}
		}
		
		if(count == MAX_MINE_NUM){
			return GameStatus.WIN;
		}
		
		return GameStatus.NOTENDED;
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
	
	boolean isValidPoint(Point point){
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
