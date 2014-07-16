import java.util.Scanner;

public class StringCalculator {

	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		String quit = "";
		
		do{
			String value = inputString(sc);
			String [ ] values = split(value);
			int [] nums = toInt(values);
			sum(nums);		
			quit = ask(sc);	 
			
		}while(!quit.equals("q"));
			
		System.out.println("Bye!");
		sc.close();
	}
	
	public static String inputString(Scanner sc){
		System.out.println("Input numbers with delimiter , and \n: ");
		return sc.nextLine();
	}
	
	public static String [] split(String value)
	{
		return value.split(",|\\\\n");
	}
	
	public static int [] toInt(String [ ] values)
	{
		int [ ] result = new int [values.length];
		
		if(values[0].equals("")){
			result[0] = 0;
			return result; 
		}
		
		for(int i = 0; i < values.length; i++){
			result [i] = Integer.parseInt(values[i]);
		}
		
		return result;
	}
	
	public static int sum(int [] numbers){
		int sum = 0;
		for(int i = 0; i < numbers.length; i++){
			sum = sum+ numbers [i]; 
		}
		System.out.println("The sum is "+ sum);
		return sum;
	}
	
	public static String ask(Scanner sc)
	{
		System.out.println("Enter 'q' if you want to quit");
		return sc.nextLine();
	}
	
}
