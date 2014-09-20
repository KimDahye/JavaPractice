package minesweeper;
import minesweeper.Cell.Status;
import minesweeper.Cell.Type;
import junit.framework.TestCase;

public class BoardTest extends TestCase {
	int row;
	int col;
	Board board;
	
	@Override
	protected void setUp() throws Exception {
		row = 6;
		col = 6;
		board = new Board(row, col);
		// 0 0 0 0 0 *
		// 0 0 * * 0 0
		// 0 * 0 0 0 0
		// 0 0 0 * 0 0
		// 0 * 0 0 0 0
		// 0 0 0 * 0 0
		board.setMine(1, 6);
		board.setMine(2, 3);
		board.setMine(2, 4);
		board.setMine(3, 2);
		board.setMine(4, 4);
		board.setMine(5, 2);
		board.setMine(6, 4);
	}
	
	public void testInitialize() throws Exception {
		assertTrue(board.isEqual(row, col, new Cell(Type.ZERO, Status.UNCHECKED)));
		assertTrue(board.isEqual(0, col+1, new Cell(Type.WALL, Status.UNCHECKED)));
	}
	
	public void testSetMine() throws Exception {
		assertTrue(board.isEqual(1, 6, new Cell(Type.MINE, Status.UNCHECKED)));
		assertTrue(board.isEqual(3, 2, new Cell(Type.MINE, Status.UNCHECKED)));
	}
	
	public void testSetNumbers() throws Exception{
		// 0 1 2 2 2 *
		// 1 2 * * 2 0
		// 1 * 4 3 2 0
		// 2 2 3 * 1 0
		// 1 * 3 2 2 0
		// 1 1 2 * 1 0
		board.setNumber(3,3);
		board.setNumber(3,4);
		board.setNumber(1,1);
		assertTrue(board.isEqual(3, 3, new Cell(Type.FOUR, Status.UNCHECKED)));
		assertTrue(board.isEqual(3, 4, new Cell(Type.THREE, Status.UNCHECKED)));
		assertTrue(board.isEqual(1, 1, new Cell(Type.ZERO, Status.UNCHECKED)));
	}
	
	public void testChangeStatus() throws Exception {
		// 코드 넣기 
	}
	
	
	
	
	
}
