package minesweeper;

import java.util.HashMap;
import java.util.Scanner;

import minesweeper.Cell.Type;

public class ManualMineSetter extends CellSetter implements MineSetter {
	ManualMineSetter(int width, int height, HashMap<Point, Cell> board) {
		super(width, height, board);
	}

	MineSetter mineSetter;
	
	public void setMines(int n) {
		Scanner scanner = new Scanner(System.in);
		for(int count = 0; count<n; count++){
			int x, y;
			System.out.println("지뢰를 넣을 x 좌표를 입력하세요: ");
			x = Integer.parseInt(scanner.nextLine());
			System.out.println("지뢰를 넣을 y 좌표를 입력하세요: ");
			y = Integer.parseInt(scanner.nextLine());
			setMine(new Point(x,y));
		}
		scanner.close();
	}
	
	@Override
	public void setMine(Point point) {
		// TODO Auto-generated method stub
		isValidPoint(point);
		board.put(point, new Cell(Type.MINE));
	}
}
