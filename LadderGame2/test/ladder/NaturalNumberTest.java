package ladder;

import junit.framework.TestCase;

public class NaturalNumberTest extends TestCase {
	public void testNaturalNumberCreate() throws Exception {
		NaturalNumber n = new NaturalNumber(3);
		assertEquals(n.getNumber(),3);
	}
	
	public void testCreateException() throws Exception {
		try{
			NaturalNumber n = new NaturalNumber(0);
			fail();
		}catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	public void testEquals() throws Exception {
		assertEquals(new NaturalNumber(1), new NaturalNumber(1));
	}
}
