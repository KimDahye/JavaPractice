package minesweeper;

import java.util.HashMap;

import cell.Cell;
import cellSetter.ManualMineSetter;
import cellSetter.NumberSetter;
import cellSetter.WallSetter;
import junit.framework.TestCase;

public class NumberSetterTest extends TestCase {
	int width;
	int height;
	ManualMineSetter manualMineSetter;
	
	@Override
	protected void setUp() throws Exception {
		width = 4;
		height = 4;
		manualMineSetter = new ManualMineSetter(width, height, new HashMap<Point, Cell>());
		WallSetter wallSetter = new WallSetter(width, height, manualMineSetter.getBoard());
		wallSetter.setWalls();
		
		manualMineSetter.setMine(new Point(1,1));
		manualMineSetter.setMine(new Point(2,3));
		manualMineSetter.setMine(new Point(3,4));
		manualMineSetter.setMine(new Point(4,3));
	}
	
	public void testSetNumbers() throws Exception {
		NumberSetter numberSetter = new NumberSetter(width, height, manualMineSetter.getBoard());
		numberSetter.setNumbers();
		
		//1 2 * 2
		//1 * 3 *
		//2 2 2 1
		//* 1 0 0
		manualMineSetter.getBoard().get(new Point(3,3)).clicked();
		manualMineSetter.getBoard().get(new Point(2,4)).clicked();
		manualMineSetter.getBoard().get(new Point(2,1)).clicked();
		manualMineSetter.getBoard().get(new Point(3,1)).clicked();

		assertEquals(manualMineSetter.getBoard().get(new Point(3,3)).toString(), "[3]");
		assertEquals(manualMineSetter.getBoard().get(new Point(2,4)).toString(), "[2]");
		assertEquals(manualMineSetter.getBoard().get(new Point(2,1)).toString(), "[1]");
		assertEquals(manualMineSetter.getBoard().get(new Point(3,1)).toString(), "[0]");
	}

}
