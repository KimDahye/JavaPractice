package minesweeper;

import junit.framework.TestCase;

public class PointTest extends TestCase {
	public void testCreate() throws Exception {
		Point pt = new Point(3,4);
		assertEquals(3, pt.getX());
		assertEquals(4, pt.getY());
	}
	
	public void testWhenXIsLowerThan1() throws Exception {
		try{
			new Point(0,4);
		}catch(Exception e){
			assertTrue(true);
		}
	}
	
	public void testWhenYIsLowerThan1() throws Exception {
		try{
			new Point(5,0);
		}catch(Exception e){
			assertTrue(true);
		}
	}
}
