import junit.framework.TestCase;

public class LadderGameTest extends TestCase {
	Ladder ladder;
	
	public void setUp(){
		int peopleNum = 6;
		int height = 10;
		ladder = new Ladder(peopleNum, height);
	}

	public void testLadderPrint() {
		ladder.print();
	}
	
	public void testMinimi(){
		Minimi m1 = new Minimi(1); 
		m1.run(ladder);
		assertEquals(6,m1.printResult());
	
	}
	
}
