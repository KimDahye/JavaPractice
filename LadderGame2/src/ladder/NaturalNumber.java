package ladder;

public class NaturalNumber {
	int number;
	
	public NaturalNumber(){
		this.number = 1;
	}
	
	public NaturalNumber(int number) {
		if(number < 1){
			throw new IllegalArgumentException("자연수는 1 이상이어야 합니다.");
		}
		this.number = number;
	}
	
	public int getNumber(){
		return number;
	}
	
	public int getIndex(){
		return number-1;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof NaturalNumber){
			return this.number == ((NaturalNumber)obj).number;
		}
		return false;
	}
}
