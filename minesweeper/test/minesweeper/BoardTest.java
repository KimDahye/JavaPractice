package minesweeper;
import minesweeper.Cell.Status;
import minesweeper.Cell.Type;
import junit.framework.TestCase;

public class BoardTest extends TestCase {
	int width;
	int height;
	Board board;
	
	@Override
	protected void setUp() throws Exception {
		width = 6;
		height = 6;
		board = new Board(width, height);
		// 0 0 0 0 0 *
		// 0 0 * * 0 0
		// 0 * 0 0 0 0
		// 0 0 0 * 0 0
		// 0 * 0 0 0 0
		// 0 0 0 * 0 0
		board.setMine(new Point(2, 2));
		board.setMine(new Point(2, 4));
		board.setMine(new Point(3, 5));
		board.setMine(new Point(4, 1));
		board.setMine(new Point(4, 3));
		board.setMine(new Point(4, 5));
		board.setMine(new Point(6, 6));
	}
	
	public void testSetMine() throws Exception {
		assertTrue(board.isEqual(new Point(2, 2), new Cell(Type.MINE)));
		assertTrue(board.isEqual(new Point(3, 5), new Cell(Type.MINE)));
	}
	
	public void testSetNumbers() throws Exception{
		// 0 1 2 2 2 *
		// 1 2 * * 2 1
		// 1 * 4 3 2 0
		// 2 2 3 * 1 0
		// 1 * 3 2 2 0
		// 1 1 2 * 1 0
		board.setNumber(new Point(3,3));
		board.setNumber(new Point(3,4));
		board.setNumber(new Point(1,1));
		board.setNumber(new Point(3,2));
		board.setNumber(new Point(4,4));
		board.setNumber(new Point(5,6));
		assertTrue(board.isEqual(new Point(3, 4), new Cell(Type.FOUR)));
		assertTrue(board.isEqual(new Point(1, 1), new Cell(Type.ONE)));
		assertTrue(board.isEqual(new Point(3, 3), new Cell(Type.THREE)));
		assertTrue(board.isEqual(new Point(3,2), new Cell(Type.THREE)));
		assertTrue(board.isEqual(new Point(4,4), new Cell(Type.THREE)));
		assertTrue(board.isEqual(new Point(5,6), new Cell(Type.TWO)));
	}
	
	public void testChangeStatus() throws Exception {
		// 코드 넣기 
	}
	
	
	
	
	
}
