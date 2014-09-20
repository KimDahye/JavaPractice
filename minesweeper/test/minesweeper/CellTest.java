package minesweeper;
import junit.framework.TestCase;
import minesweeper.Cell.Status;
import minesweeper.Cell.Type;

public class CellTest extends TestCase {
	public void testPrintWhenUnchecked() throws Exception {
		Cell cell = new Cell(Type.MINE, Status.UNCHECKED);
		assertEquals("[?]",cell.toString());
	}
	
	public void testPrintWhenFlaged() throws Exception {
		Cell cell = new Cell(Type.ZERO, Status.FLAGED);
		assertEquals("[\u2691]",cell.toString());
	}
	
	public void testWhenMineClicked() throws Exception {
		Cell cell = new Cell(Type.MINE, Status.CLICKED);
		assertEquals("[\u25CF]",cell.toString());
	}
	
	public void testWhenZeroClicked() throws Exception{
		Cell cell = new Cell(Type.ZERO, Status.CLICKED);
		assertEquals("[ ]",cell.toString());
	}
	
	public void testWhenNumberClicked() throws Exception{
		Cell cell = new Cell(Type.FIVE, Status.CLICKED);
		assertEquals("[5]",cell.toString());
	}
}
