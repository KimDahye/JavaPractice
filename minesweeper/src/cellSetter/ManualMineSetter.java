package cellSetter;

import java.util.HashMap;
import java.util.Scanner;

import minesweeper.Cell;
import minesweeper.Point;
import minesweeper.Cell.Type;

public class ManualMineSetter extends CellSetter implements MineSetter {
	public ManualMineSetter(int width, int height, HashMap<Point, Cell> board) {
		super(width, height, board);
	}
	
	public void setMines(int n) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		for(int count = 0; count<n; count++){
			int x, y;
			System.out.println("지뢰를 넣을 x 좌표를 입력하세요: ");
			x = Integer.parseInt(scanner.nextLine());
			System.out.println("지뢰를 넣을 y 좌표를 입력하세요: ");
			y = Integer.parseInt(scanner.nextLine());
			setMine(new Point(x,y));
		}
	}
	
	@Override
	public void setMine(Point point) {
		point.isValid(width, height);
		board.put(point, new Cell(Type.MINE));
	}
	
	public HashMap<Point, Cell> getBoard(){
		return board;
	}
}
