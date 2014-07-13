import java.util.Scanner;

public class StringCalculator {

	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		String quit = "";
		
		do{
			String [] numbers = inputNumbers(sc);
			addNumbers(numbers);		
			quit = ask(sc);	 
			
		}while(!quit.equals("q"));
			
		System.out.println("Bye!");
		sc.close();
		
	}
	
	public static String[] inputNumbers(Scanner sc){
		System.out.println("Input numbers: ");
		return sc.nextLine().split(",|\\\\n");
	}
	
	public static void addNumbers(String [] numbers){
		int sum = 0;
		
		if(numbers[0].equals("")){
			System.out.println("The sum is "+sum);
			return;
		}
		
		for(int i = 0; i < numbers.length; i++){
			sum = sum + Integer.parseInt(numbers[i]);
		}
		System.out.println("The sum is "+sum);
		
	}
	
	public static String ask(Scanner sc)
	{
		System.out.println("Enter 'q' if you want to quit");
		return sc.nextLine();
	}
	
}
