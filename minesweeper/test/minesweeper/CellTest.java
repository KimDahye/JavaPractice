package minesweeper;
import cell.Cell;
import cell.MineCell;
import cell.NumberCell;
import junit.framework.TestCase;

public class CellTest extends TestCase {
	public void testPrintWhenUnchecked() throws Exception {
		Cell cell = new MineCell();
		assertEquals("[?]",cell.toString());
	}
	
	public void testPrintWhenFlaged() throws Exception {
		Cell cell = new NumberCell(0);
		cell.flaged();
		assertEquals("[\u2691]",cell.toString());
	}
	
	public void testWhenMineClicked() throws Exception {
		Cell cell = new MineCell();
		cell.clicked();
		assertEquals("[\u25CF]",cell.toString());
	}
	
	public void testWhenZeroClicked() throws Exception{
		Cell cell = new NumberCell(0);
		cell.clicked();
		assertEquals("[0]",cell.toString());
	}
	
	public void testWhenNumberClicked() throws Exception{
		Cell cell = new NumberCell(5);
		cell.clicked();
		assertEquals("[5]",cell.toString());
	}
}
