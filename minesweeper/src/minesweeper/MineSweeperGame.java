package minesweeper;

import gameRunner.GameRunner;

class MineSweeperGame {
	BoardCreator boardCreator;
	final private int NUM_OF_MINES;  
	
	MineSweeperGame(BoardCreator boardCreator, int n){
		this.boardCreator = boardCreator;
		NUM_OF_MINES = n;
		boardCreator.setWalls();
		boardCreator.setMines(n);
		boardCreator.setNumbers();
	}
	
	void run(){
		GameRunner gameRunner = new GameRunner(boardCreator, NUM_OF_MINES);
		gameRunner.run();
	}
}
