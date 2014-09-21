package minesweeper;

class Cell {
	enum Type { 
		ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), MINE(9), WALL(10);
		public final int id;
		
		private Type(int id){
			this.id = id;
		}
		
		private int getId(){
			return id;
		}
	}
	
	enum Status { 
		UNCHECKED, FLAGED, CLICKED 
	}
	
	private final Type type;
	private Status status;
	
	Cell(Type type){
		this.type = type;
		this.status = Status.UNCHECKED;
	}
	
	Cell(int type){
		this.type = Type.values()[type];
		this.status = Status.UNCHECKED;
	}
	
	void setStatus(Status status){
		this.status = status;
	}
	
	public String toString(){
		if(status == Status.UNCHECKED){
			return "[?]"; 
		}
		else if(status == Status.FLAGED){
			return "[\u2691]"; 
		}
		//CLICKED 일 때
		if(type == Type.MINE){
			return "[\u25CF]"; 
		}
		else if(type == Type.ZERO){
			return "[ ]";
		}
		return "["+String.valueOf(type.getId())+"]";
	}
	
	boolean isSameTypeWith(Type type){
		if(this.type == type){
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (status != other.status)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
