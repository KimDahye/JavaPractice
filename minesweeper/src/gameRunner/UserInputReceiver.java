package gameRunner;

import java.util.InputMismatchException;
import minesweeper.Point;
import minesweeper.Cell.Status;

import java.util.Scanner;

public class UserInputReceiver {
	
	private UserInputReceiver(){}
	
	static Point getPoint(int width, int height){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Point point = null;
		boolean check = false;
		do{
			try{
				System.out.println("x좌표를 입력하세요.");
				int x = scanner.nextInt();
				System.out.println("y좌표를 입력하세요.");
				int y = scanner.nextInt();			
				point = new Point(x, y);
				point.isValid(width, height);
				check = true;
			}catch(InputMismatchException e){
				scanner.nextLine();
				System.out.println("좌표를 숫자로 입력해주세요.");
				continue;
			}catch(Exception e){
				System.out.println(e.getMessage());
				continue;
			}
		}while(!check);
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
		throw new IllegalArgumentException("0과 1 중 하나로만 입력해주세요.");
	}
}
