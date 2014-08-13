package ladder;
import java.util.Random;

public class FiniteNumber extends NaturalNumber {
	public FiniteNumber(int number, NaturalNumber limit){
		if(number > limit.getNumber()){
			throw new IllegalArgumentException("limit 범위를 초과합니다.");		
		}
		super.number = number;
	}
	
	public FiniteNumber(NaturalNumber limit){
		Random random = new Random();
		super.number = random.nextInt(limit.getNumber()) + 1;
	}
}
