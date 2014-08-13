package ladder;

import junit.framework.TestCase;

public class RowTest extends TestCase {
	Row row;
	@Override
	protected void setUp() throws Exception {
		row = new Row(new NaturalNumber(3));
	}
	
	public void testDrawLineAndMove() {
		//0 1 -1
		row.DrawLine(new NaturalNumber(2));
		assertEquals(new NaturalNumber(3), row.Move(new NaturalNumber(2)));
		assertEquals(new NaturalNumber(1), row.Move(new NaturalNumber(1)));
		assertEquals(new NaturalNumber(2), row.Move(new NaturalNumber(3)));
	}
	
	public void testDrawLineException_그린곳_또그리기_왼쪽() throws Exception {
		try{
			row.DrawLine(new NaturalNumber(2));
			row.DrawLine(new NaturalNumber(1));
			fail();
		}catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	public void testDrawLineException_그린곳_또그리기_오른쪽(){
		try{
			row.DrawLine(new NaturalNumber(1));
			row.DrawLine(new NaturalNumber(2));
			fail();
		}catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	public void testDrawLine_Exception_배열범위초과() throws Exception {
		try{
			row.DrawLine(new NaturalNumber(3));
			fail();
		}catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	public void testMoveException_배열범위미만() throws Exception {
		try{
			row.Move(new NaturalNumber(0));
			fail();
		}catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	public void testMoveException_배열범위초과() throws Exception {
		try{
			row.Move(new NaturalNumber(4));
			fail();
		}catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
}
