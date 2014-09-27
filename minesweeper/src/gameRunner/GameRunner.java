package gameRunner;

import minesweeper.BoardCreator;
import minesweeper.Point;
import minesweeper.Cell.Status;

public class GameRunner {
	BoardCreator boardCreator;
	final private int NUM_OF_MINES;

	enum GameStatus { 
		NOT_ENDED, WIN, LOSE; 
	}
	
	public GameRunner(BoardCreator boardCreator, int NUM_OF_MINES){
		this.boardCreator = boardCreator;
		this.NUM_OF_MINES = NUM_OF_MINES;
	}
	
	public void run(){
		while(whatsGameStatus() == GameStatus.NOT_ENDED){
			printCurrentBoard();
			Point point = receivePoint();
			Status status = receiveStatus();
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
	
	private Status receiveStatus(){
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
	
	private void changeStatusBoard(Point point, Status status){
		StatusChanger statusChanger = new StatusChanger(boardCreator.getBoard(), boardCreator.getWidth(), boardCreator.getHeight());
		statusChanger.changeStatus(point, status);
	}
}
