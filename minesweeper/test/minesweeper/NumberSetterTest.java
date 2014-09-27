package minesweeper;

import java.util.HashMap;

import cellSetter.ManualMineSetter;
import cellSetter.NumberSetter;
import cellSetter.WallSetter;
import minesweeper.Cell.Type;
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
		
		assertTrue(manualMineSetter.getBoard().get(new Point(3,3)).isSameTypeWith(Type.THREE));
		assertTrue(manualMineSetter.getBoard().get(new Point(2,4)).isSameTypeWith(Type.TWO));
		assertTrue(manualMineSetter.getBoard().get(new Point(2,1)).isSameTypeWith(Type.ONE));
		assertTrue(manualMineSetter.getBoard().get(new Point(3,1)).isSameTypeWith(Type.ZERO));
	}

}
