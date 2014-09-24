package minesweeper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputReceiver {
	final static int CLICKED = 0; //얘네 enum으로 바꿀까 고민중...
	final static int FLAGED = 1;
	
	private UserInputReceiver(){}
	
	static Point getPoint(int width, int height){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Point point = null;
		do{
			try{
				System.out.println("x좌표를 입력하세요.");
				int x = scanner.nextInt();
				System.out.println("y좌표를 입력하세요.");
				int y = scanner.nextInt();			
				point = new Point(x, y);		
			}catch(InputMismatchException e){
				scanner.nextLine();
				System.out.println("좌표를 숫자로 입력해주세요.");
				continue;
			}catch(Exception e){
				e.getMessage();
				continue;
			}
		}while(!isValidPoint(point, width, height));
		return point;
	}
	
	static int getStatus(){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int result = -1;
		do{
			try{
				System.out.println("어떻게 상태를 바꾸시겠습니까? 클릭(0), 깃발(1)");
				result = scanner.nextInt();
			}catch(InputMismatchException e){
				scanner.nextLine();
				System.out.println("상태를 숫자로 입력해주세요.");
				continue;
			}
		}while(!isValidStatus(result));
		return result;
	}
	
	private static boolean isValidPoint(Point point, int width, int height){
		if(point == null){
			return false;
		}
		if(point.getX() < 1)
		{
			System.out.println("x값은 1 이상이어야 합니다.");
			return false;
		}
		if(point.getY() < 1){
			System.out.println("y값은 1 이상이어야 합니다.");
			return false;
		}
		if(point.getX() > width){
			System.out.println(String.format("x값이 가로 최대 범위를 초과하였습니다. 가로 최대범위는 %d. @mineSweeperGame", width));
			return false;
		}
		if(point.getY() > height){
			System.out.println(String.format("y값이 세로 최대 범위를 초과하였습니다. 세로 최대범위는 %d. @mineSweeperGame", height));
			return false;
		}
		return true;
	}
	
	private static boolean isValidStatus(int status){
		if(status == CLICKED || status == FLAGED){
			return true;
		}
		return false;
	}
}
