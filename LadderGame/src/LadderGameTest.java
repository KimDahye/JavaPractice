import junit.framework.TestCase;

public class LadderGameTest extends TestCase {

	public void testLadderPrint() {
		int peopleNum = 6;
		int height = 10;
		Ladder ladder = new Ladder(peopleNum, height);
		ladder.print();
	}
	
}
