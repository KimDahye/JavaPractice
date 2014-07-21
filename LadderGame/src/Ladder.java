import java.util.Random;

public class Ladder {
	int cols;
	int rows;
	int[][] board;

	public Ladder(int peopleNum, int height) {
		cols = peopleNum * 2 + 1;
		rows = height + 2 + 1;
		board = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == rows - 1) {
					board[i][j] = -1;
					continue;
				}

				if (j == 0 || j == (cols - 1)) {
					board[i][j] = -1;
					continue;
				}
				if (j % 2 == 1) {
					board[i][j] = 1;
					continue;
				}
				board[i][j] = 0;
			}
		}

		board[1][2] = 1;
		board[2][8] = 1;
		board[3][4] = 1;
		board[3][10] = 1;
		board[4][6] = 1;
		board[5][4] = 1;
		board[5][10] = 1;
		board[6][2] = 1;
		board[6][8] = 1;
		board[7][6] = 1;
		board[7][10] = 1;
		board[8][4] = 1;
		board[8][8] = 1;
		board[9][2] = 1;
		board[10][6] = 1;

		/* random으로 긋기 */
		// for (int i = 1; i < rows - 2; i++){
		// Random random = new Random();
		// int j = random.nextInt(cols - 3) + 1;
		// if (j % 2 == 0) {
		// board[i][j] = 1;
		// continue;
		// }
		// }

	}

	public boolean isEnd(Node presentPos) {
		int row = presentPos.getRow();
		int col = presentPos.getCol();
		if (board[row + 1][col] == -1) {
			return true;
		}

		return false;
	}

	public boolean isCrossable(Node presentPos) {
		int row = presentPos.getRow();
		int col = presentPos.getCol();
		if (board[row][col - 1] == 1 || board[row][col] == 1) {
			return true;
		}

		return false;
	}

	public void print() {
		for (int i = 0; i < rows - 1; i++) {
			for (int j = 1; j < cols - 1; j++) {
				if (board[i][j] == 1 && j % 2 == 1) {
					System.out.print("|");
					continue;
				}

				if (board[i][j] == 1) {
					System.out.print("-");
					continue;
				}

				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
