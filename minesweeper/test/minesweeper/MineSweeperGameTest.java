package minesweeper;

import junit.framework.TestCase;

public class MineSweeperGameTest extends TestCase {
	public void testGameSet() throws Exception {
		/*		
		 * ManualMineSetter 이렇게 셋팅해둠 테스트 후 에 바꾸기!
		 * 
		 * board.setMine(new Point(2, 2));
		 * board.setMine(new Point(2, 4));
		 * board.setMine(new Point(3, 5));
		 * board.setMine(new Point(4, 3));
		 * board.setMine(new Point(4, 5));
		 * board.setMine(new Point(6, 6));
		*/
		MineSweeperGame game = new MineSweeperGame(BoardCreatorFactory.manualBoarderCreator(6, 6), 6);
		game.run();
		// 0 1 2 2 2 *
		// 1 2 * * 2 1
		// 1 * 4 3 2 0
		// 2 2 3 * 1 0
		// 1 * 2 1 1 0
		// 1 1 1 0 0 0
	}
	
	public void testRun() throws Exception {
		
	}

}
