package cell;

abstract public class Cell {
	public enum Status { 
		UNCHECKED, FLAGED, CLICKED 
	}
	
	Status status;
	
	public void flaged(){
		this.status = Status.FLAGED;
	}
	
	public void clicked(){
		this.status = Status.CLICKED;
	}
	
	public boolean isSameStatusWith(Status status){
		if(this.status == status){
			return true;
		}
		return false;
	}
	
	abstract public String toString();
	
	String toStringWhenNonClicked(){
		if(status == Status.UNCHECKED){
			return "[?]"; 
		}
		if(status == Status.FLAGED){
			return "[\u2691]"; 
		}
		return null;
	}
}
