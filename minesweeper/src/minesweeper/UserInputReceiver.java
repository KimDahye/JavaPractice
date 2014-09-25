package minesweeper;

import java.util.InputMismatchException;
import minesweeper.Cell.Status;
import java.util.Scanner;

public class UserInputReceiver {
	
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
				System.out.println(e.getMessage());
				continue;
			}
		}while(!isValidPoint(point, width, height));
		return point;
	}
	
	static Status getStatus(){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Status resultStatus = null;
		do{
			try{
				System.out.println("어떻게 상태를 바꾸시겠습니까? 클릭(0), 깃발(1)");
				resultStatus = changeIntToStatus(scanner.nextInt());
			}catch(InputMismatchException e){
				scanner.nextLine();
				System.out.println("상태를 숫자로 입력해주세요.");
				continue;
			}catch(Exception e){
				System.out.println(e.getMessage());
				continue;
			}
		}while(!isValidStatus(resultStatus));
		return resultStatus;
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
	
	private static boolean isValidStatus(Status status){
		if(status == Status.CLICKED || status == Status.FLAGED){
			return true;
		}
		return false;
	}
	
	private static Status changeIntToStatus(int resultInt){
		if(resultInt == 0){
			return Status.CLICKED;
		}
		if(resultInt == 1){
			return Status.FLAGED;
		}
		throw new IllegalArgumentException();
	}
}
