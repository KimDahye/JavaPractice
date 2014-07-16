import junit.framework.TestCase;


public class StringCalculatorTest extends TestCase {

	public void testWhenEmpty() {
		int result = StringCalculator.add("");
		assertEquals(0, result);
	}

	public void testWhenOneChar() {
		int result = StringCalculator.add("1");
		assertEquals(1, result);		
	}

	public void testWhenTwoCahr() {
		int result = StringCalculator.add("1,2");
		assertEquals(3, result);		
	}
	public void testWhenThreeCahrComma() {
		int result = StringCalculator.add("1,2,10");
		assertEquals(13, result);		
	}
	
	public void testWhenThreeCahrNewLine() {
		int result = StringCalculator.add("1\n2\n10");
		assertEquals(13, result);		
	}
	
	public void testWhenThreeCahrCommaNewLine() {
		int result = StringCalculator.add("1,2\n10");
		assertEquals(13, result);		
	}
	
	

}
