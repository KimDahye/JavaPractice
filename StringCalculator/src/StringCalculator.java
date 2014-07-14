import java.util.Scanner;

public class StringCalculator {

	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		String quit = "";
		
		do{
			String [] values = inputNumbers(sc);
			add(values);		
			quit = ask(sc);	 
			
		}while(!quit.equals("q"));
			
		System.out.println("Bye!");
		sc.close();
		
	}
	
	public static String[] inputNumbers(Scanner sc){
		System.out.println("Input numbers: ");
		return sc.nextLine().split(",|\\\\n");
	}
	
	public static void add(String [] values){
		
		if(values[0].equals("")){
			System.out.println("The sum is 0.");
			return;
		}
		
		int [] numbers = toInt(values); 
		System.out.println("The sum is "+ sum(numbers));
		
	}
	
	public static int [] toInt(String [] values)
	{
		int [] result = new int [values.length];
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
		return sum;
	}
	
	public static String ask(Scanner sc)
	{
		System.out.println("Enter 'q' if you want to quit");
		return sc.nextLine();
	}
	
}
