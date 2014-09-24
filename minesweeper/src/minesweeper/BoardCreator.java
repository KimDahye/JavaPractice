package minesweeper;

import java.util.HashMap;


class BoardCreator {
	private final int width;
	private final int height;
	private MineSetter mineSetter;
	
	BoardCreator(int width, int height, MineSetter mineSetter) {
		this.width = width;
		this.height = height;
		this.mineSetter = mineSetter;
	}
	
	void setWalls(){
		WallSetter wallSetter = new WallSetter(width, height, mineSetter.getBoard());
		wallSetter.setWalls();
	}
	
	void setMines(int n){
		mineSetter.setMines(n);
	}

	void setNumbers(){
		NumberSetter numberSetter = new NumberSetter(width, height, mineSetter.getBoard());
		numberSetter.setNumbers();
	}
	
	int getWidth(){
		return width;
	}
	
	int getHeight(){
		return height;
	}
	
	HashMap<Point, Cell> getBoard(){
		return mineSetter.getBoard();
	}
	
	void printBoard(){
		for(int y = height; y > 0; y--){
			for(int x = 1; x<width+1; x++){
				System.out.print(mineSetter.getBoard().get(new Point(x,y)));
			}
			System.out.println();
		}
	}
}
