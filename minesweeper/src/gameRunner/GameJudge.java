package gameRunner;

import gameRunner.GameRunner.GameStatus;

import java.util.HashMap;

import cell.Cell;
import cell.Cell.Status;
import cell.MineCell;
import minesweeper.Point;

public class GameJudge {
	private GameJudge(){	}
	
	static GameStatus judge(HashMap<Point, Cell> board, int NUM_OF_MINES){
		int count = 0;
		for(Point key : board.keySet()){
			Cell valueByKey = board.get(key);
			if(valueByKey instanceof MineCell && valueByKey.isSameStatusWith(Status.CLICKED)){
				return GameStatus.LOSE;
			}
			if(valueByKey instanceof MineCell && valueByKey.isSameStatusWith(Status.FLAGED)){
				count++;
			}
		}
		
		if(count != NUM_OF_MINES){
			return GameStatus.NOT_ENDED;
		}
		
		return GameStatus.WIN;
	}
}
