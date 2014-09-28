package minesweeper;

import java.util.HashMap;

import cell.Cell;
import cellSetter.MineSetter;
import cellSetter.NumberSetter;
import cellSetter.WallSetter;

public class BoardCreator {
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
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public HashMap<Point, Cell> getBoard(){
		return mineSetter.getBoard();
	}
	
	public void printBoard(){
		for(int y = height; y > 0; y--){
			System.out.print(y+"\t");
			for(int x = 1; x<width+1; x++){
				System.out.print(mineSetter.getBoard().get(new Point(x,y)));
			}
			System.out.println();
		}
		System.out.print(" \t");
		for(int x = 1; x<width+1; x++){
			if(x > 9){
				System.out.print(String.format("%d ", x));
				continue;
			}
			System.out.print(String.format(" %d ", x));
		}
		System.out.println();
	}
}
