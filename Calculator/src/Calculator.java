import java.util.Scanner;

public class Calculator {
	
	static class Program {
		public static void main(String [] args){
			Calculator cal = new Calculator();
			Scanner sc = new Scanner(System.in);

			String op = cal.selectOperator(sc);
			int num1 = cal.insertNum(sc);
			int num2 = cal.insertNum(sc);
			cal.calculate(op, num1, num2);

			sc.close();
		}
	}

	

	String selectOperator(Scanner sc){
		System.out.println("Insert Operator[+,-,*,/]: ");
		String a = sc.next();
		return a;
	}

	int insertNum(Scanner sc){
		System.out.println("Insert Number: ");
		int a = sc.nextInt();
		return a;
	}

	void calculate(String op, int num1, int num2){
		switch(op){
		case "+":
			System.out.println(num1+num2);
			break;
		case "-":
			System.out.println(num1-num2);
			break;
		case "*":
			System.out.println(num1*num2);
			break;
		case "/":
			System.out.println(num1/num2);
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
		}
	}

}



