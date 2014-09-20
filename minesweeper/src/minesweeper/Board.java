package minesweeper;
import minesweeper.Cell.Status;
import minesweeper.Cell.Type;

class Board {
	private Cell[][] board;
	int row;
	int col;
	
	Board(int row, int col) {
		this.row = row;
		this.col = col;
		board = new Cell[row+2][col+2];
		for(int i = 0; i<row+2; i++){
			for(int j = 0; j<col+2; j++){
				if(i == 0 || j == 0 || i == row+1 || j == col+1){
					board[i][j] = new Cell(Type.WALL, Status.UNCHECKED);
					continue;
				}
				board[i][j] = new Cell(Type.ZERO, Status.UNCHECKED);
			}
		}
	}
	
	void setMine(int row, int col){
		if(row > this.row || row < 1){
			throw new IllegalArgumentException("좌표의 row값이 board의 row 범위를 초과하였습니다.");
		}
		if(col > this.col || col < 1){
			throw new IllegalArgumentException("좌표의 col값이 board의 col 범위를 초과하였습니다.");
		}
		board[row][col] = new Cell(Type.MINE, Status.UNCHECKED);
	}
	
	void setNumber(int row, int col){
		if(row > this.row || row < 1){
			throw new IllegalArgumentException("좌표의 row값이 board의 row 범위를 초과하였습니다.");
		}
		if(col > this.col || col < 1){
			throw new IllegalArgumentException("좌표의 col값이 board의 col 범위를 초과하였습니다.");
		}
		if(board[row][col].isSameTypeWith(Type.MINE)){
			return;
		}
		int count = howManyMinesAround(row, col);
		board[row][col] = new Cell(count, Status.UNCHECKED);
	}
	
	private int howManyMinesAround(int row, int col){
		if(row > this.row || row < 1){
			throw new IllegalArgumentException("좌표의 row값이 board의 row 범위를 초과하였습니다.");
		}
		if(col > this.col || col < 1){
			throw new IllegalArgumentException("좌표의 col값이 board의 col 범위를 초과하였습니다.");
		}
		
		int count = 0;
		if(board[row-1][col-1].isSameTypeWith(Type.MINE)){
			count++;
		}
		if(board[row-1][col].isSameTypeWith(Type.MINE)){
			count++;
		}
		if(board[row-1][col+1].isSameTypeWith(Type.MINE)){
			count++;
		}
		if(board[row][col-1].isSameTypeWith(Type.MINE)){
			count++;
		}
		if(board[row][col+1].isSameTypeWith(Type.MINE)){
			count++;
		}
		if(board[row+1][col-1].isSameTypeWith(Type.MINE)){
			count++;
		}
		if(board[row+1][col].isSameTypeWith(Type.MINE)){
			count++;
		}
		if(board[row+1][col+1].isSameTypeWith(Type.MINE)){
			count++;
		}
		return count;
	}
	
	void changeStatus(int row, int col, Status status){
		if(row > this.row || row < 1){
			throw new IllegalArgumentException("좌표의 row값이 board의 row 범위를 초과하였습니다.");
		}
		if(col > this.col || col < 1){
			throw new IllegalArgumentException("좌표의 col값이 board의 col 범위를 초과하였습니다.");
		}
		Cell tempCell = board[row][col];
		board[row][col] = new Cell(tempCell.getType(), status);
	}
	
	boolean isEqual(int row, int col, Cell cell) {
		if(row > this.row+1 || row < 0){
			throw new IllegalArgumentException("좌표의 row값이 board의 row 범위를 초과하였습니다.");
		}
		if(col > this.col+1 || col < 0){
			throw new IllegalArgumentException("좌표의 col값이 board의 col 범위를 초과하였습니다.");
		}
		if(board[row][col].equals(cell)){
			return true;
		}
		return false;
	}
	
}
