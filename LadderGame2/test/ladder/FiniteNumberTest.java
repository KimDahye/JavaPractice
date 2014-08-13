package ladder;

import junit.framework.TestCase;

public class FiniteNumberTest extends TestCase {
	public void testCreate() throws Exception {
		FiniteNumber fn = new FiniteNumber(3, new NaturalNumber(3));
		assertEquals(3, fn.getNumber());
	}
	
	public void testCreateRandomly() throws Exception {
		FiniteNumber fn = new FiniteNumber(new NaturalNumber(3));
		if(fn.getNumber() < 0 || fn.getNumber() > 3){
			fail();
		}
		assertTrue(true);
	}
}
