import java.util.Scanner;

public class StringCalculator {

	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		String quit = "";
		do
		{
			System.out.println("Input text: ");
			String nums = sc.nextLine();
			
			String [] numbers = nums.split(",|\\\\n");
			int sum = 0;
			for(int i = 0; i < numbers.length; i++)
			{
				if(numbers[i].equals(""))
				{
					break;
				}
				
				sum = sum + Integer.parseInt(numbers[i]);
			}
			
			System.out.println("The sum is "+sum);
			
			System.out.println("Enter 'q' if you want to quit");
			quit = sc.nextLine(); 
			
		}while(!quit.equals("q"));
		sc.close();
		
		
	}
	
}
