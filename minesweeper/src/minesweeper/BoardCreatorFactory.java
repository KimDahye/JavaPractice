package minesweeper;

import java.util.HashMap;

import cellSetter.ManualMineSetter;
import cellSetter.RandomMineSetter;

public class BoardCreatorFactory {
	private BoardCreatorFactory() {}
	
	static BoardCreator randomBoarderCreator(int width, int height) {
		RandomMineSetter mineSetter = new RandomMineSetter(width, height, new HashMap<Point, Cell>());
		return new BoardCreator(width, height, mineSetter);
	}
	
	static BoardCreator manualBoarderCreator(int width, int height) {
		ManualMineSetter mineSetter = new ManualMineSetter(width, height, new HashMap<Point, Cell>());
		return new BoardCreator(width, height, mineSetter);
	}
}
