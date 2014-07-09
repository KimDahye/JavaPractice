public class StringCalculator {

	public static void main(String [] as){
		//String nums = "3,4\n5";
		String nums = "";
		
		String [] numbers = nums.split("[,\\n]");
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
	}
	
}
