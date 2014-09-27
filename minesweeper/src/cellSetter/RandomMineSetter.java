package cellSetter;

import java.util.HashMap;
import java.util.Random;

import minesweeper.Cell;
import minesweeper.Point;

public class RandomMineSetter implements MineSetter {
	ManualMineSetter manualMineSetter;
	public RandomMineSetter(int width, int height, HashMap<Point, Cell> board) {
		manualMineSetter = new ManualMineSetter(width, height, board);
	}

	@Override
	public void setMine(Point point) {
		throw new UnsupportedOperationException("RandomMineSetter에서는 setMine(Point point) 메서드를 호출할 수 없습니다.");
	}

	@Override
	public void setMines(int n) {
		int count = 0;
		while(count < n){
			int x = RandomMinMax(1, manualMineSetter.width);
			int y = RandomMinMax(1, manualMineSetter.height);
			Point point = new Point(x,y);
			if(!manualMineSetter.getBoard().containsKey(point)){
				manualMineSetter.setMine(point);
				count++;
			}
		}
	}
	
	public HashMap<Point, Cell> getBoard(){
		return manualMineSetter.getBoard();
	}
	
	private int RandomMinMax(int min, int max){
		Random random = new Random();
		return random.nextInt(max)+min;
	}
}
