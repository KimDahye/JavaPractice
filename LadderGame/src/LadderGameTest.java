import junit.framework.TestCase;

public class LadderGameTest extends TestCase {
	Ladder ladder;
	
	public void setUp(){
		int peopleNum = 6;
		int height = 10;
		ladder = new Ladder(peopleNum, height);
		System.out.println("set up!");
	}

	public void testLadderPrint() {
		ladder.print();
	}
	
	public void testMinimi(){
		Minimi m1 = new Minimi(1); 
		m1.run(ladder);
		assertEquals(6,m1.printResult());
		
		Minimi m3 = new Minimi(3);
		m3.run(ladder);
		assertEquals(5, m3.printResult());
		
		Minimi m6 = new Minimi(6);
		m6.run(ladder);
		assertEquals(3, m6.printResult());
	}
	
}
