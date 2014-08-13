package ladder;

import junit.framework.TestCase;

public class LadderTest extends TestCase {
	Ladder ladder;
	@Override
	protected void setUp() throws Exception {
		ladder = new Ladder(new NaturalNumber(3), new NaturalNumber(4));
	}
	
	public void testDrawLineAndRun() throws Exception {
		//1 -1  0  0 
		//0  1 -1  0
		//1 -1  1 -1
		ladder.DrawLine(new NaturalNumber(1), new NaturalNumber(1));
		ladder.DrawLine(new NaturalNumber(2), new NaturalNumber(2));
		ladder.DrawLine(new NaturalNumber(3), new NaturalNumber(1));
		ladder.DrawLine(new NaturalNumber(3), new NaturalNumber(3));
		ladder.Print();
		assertEquals(1, ladder.Run(new NaturalNumber(3)));
		assertEquals(4, ladder.Run(new NaturalNumber(1)));
	}
	
	public void testDrawLineException_사다리높이미만()throws Exception {
		try{
			ladder.DrawLine(new NaturalNumber(0),new NaturalNumber(3));
			fail();
		}catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	public void testDrawLineException_사다리높이초과()throws Exception {
		try{
			ladder.DrawLine(new NaturalNumber(4),new NaturalNumber(3));
			fail();
		}catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	public void testDrawLineException_사람수미만()throws Exception {
		try{
			ladder.DrawLine(new NaturalNumber(2),new NaturalNumber(0));
			fail();
		}catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	public void testDrawLineException_사람수초과()throws Exception {
		try{
			ladder.DrawLine(new NaturalNumber(2), new NaturalNumber(4));
			fail();
		}catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	public void testRunException_사람수미만() throws Exception {
		try{
			ladder.Run(new NaturalNumber(0));
			fail();
		}catch(IllegalArgumentException e){
			assertTrue(true);
		}	
	}
	
	public void testRunException_사람수초과() throws Exception {
		try{
			ladder.Run(new NaturalNumber(5));
			fail();
		}catch(IllegalArgumentException e){
			assertTrue(true);
		}	
	}
	
	
}
