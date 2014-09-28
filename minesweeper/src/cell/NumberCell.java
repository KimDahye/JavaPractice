package cell;

public class NumberCell extends Cell{
	final private int number; 
	public NumberCell(int number){
		this.number = number;
		this.status = Status.UNCHECKED;
	}
	
	public String toString() {
		if(status != Status.CLICKED){
			return toStringWhenNonClicked(); 
		}
		if(number == 0){
			return "[ ]";
		}
		return "[" + number + "]";
	}
	
	public boolean isZero(){
		if(this.number == 0){
			return true;
		}
		return false;
	}
}
