package minesweeper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String redoCheck= null;
		do{
			int width = receiveNum("가로", 0);
			int height = receiveNum("세로", 0);
			int numOfMine = receiveNum("지뢰", width*height-1);
			runMineSweeper(width, height, numOfMine);
			redoCheck = receiveString();
		}while(redoCheck.equals("y"));
		printProgramEndMessage();
	}
	
	private static void runMineSweeper(int width, int height, int numOfMine){
		BoardCreator boardCreator = BoardCreatorFactory.randomBoarderCreator(width, height);
		MineSweeperGame game = new MineSweeperGame(boardCreator, numOfMine);
		game.run();
	}
	private static void printProgramEndMessage() {
		System.out.println("BYE~");
	}

	private static String receiveString() {
		String result;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("다시 하시겠습니까?(다시 하시려면 y 를 입력, 끝내시려면 아무키 입력)");
		result = scanner.nextLine();
		return result;
	}

	static private int receiveNum(String what, int max){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int x = 0;
		boolean check = true;
		do{
			try{
				System.out.println(what+"는 몇 개로 하시겠습니까?");
				x = scanner.nextInt();
				if(what.equals("지뢰")){
					isValidMineNum(x, max);
				}
				else{
					isValidWidthOrHeight(x);
				}
				check = false;
			}catch(InputMismatchException e){
				scanner.nextLine();
				System.out.println("숫자로 입력하세요.");
				continue;
			}catch(Exception e){
				System.out.println(e.getMessage());
				continue;
			}
		}while(check);
		return x;
	}

	static private void isValidWidthOrHeight(int n) {
		if(n < 4){
			throw new IllegalArgumentException("4 이상으로 입력해주세요.");
		}
		if(n > 40){
			throw new IllegalArgumentException("40 이하로 입력해주세요. 콘솔게임이라 40 초과하면 게임하기가 어렵습니다.");
		}
	}
	
	static private void isValidMineNum(int numOfMine, int max){
		if(numOfMine > max){
			throw new IllegalArgumentException(String.format("지뢰 개수는 %d까지입니다.", max));
		}
		if(numOfMine < 1){
			throw new IllegalArgumentException("지뢰 개수는 1 이상입니다.");
		}
	}
}
