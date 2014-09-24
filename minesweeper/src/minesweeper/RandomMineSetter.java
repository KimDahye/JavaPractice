package minesweeper;

import java.util.HashMap;

public class RandomMineSetter implements MineSetter {
	ManualMineSetter manualMineSetter;
	RandomMineSetter(int width, int height, HashMap<Point, Cell> board) {
		manualMineSetter = new ManualMineSetter(width, height, board);
	}

	@Override
	public void setMine(Point point) {
		throw new UnsupportedOperationException("RandomMineSetter에서는 setMine(Point point) 메서드를 호출할 수 없습니다.");
	}

	@Override
	public void setMines(int n) {
		// TODO Auto-generated method stub
		//Random하게 지뢰 n개 배치하는 메소드.
	}
	
	public HashMap<Point, Cell> getBoard(){
		return manualMineSetter.getBoard();
	}
}
