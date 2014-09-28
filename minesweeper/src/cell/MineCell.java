package cell;

public class MineCell extends Cell{
	public MineCell(){
		this.status = Status.UNCHECKED;
	}

	@Override
	public String toString() {
		if(status != Status.CLICKED){
			return toStringWhenNonClicked(); 
		}
		return "[\u25CF]"; 
	}
}
