package minesweeper;

public class Point {
	private final int x;
	private final int y;
	
	public Point(int x, int y){
		if(x < 0){
			throw new IllegalArgumentException("x값이 유용한 범위가 아닙니다.");
		}
		if(y < 0){
			throw new IllegalArgumentException("y값이 유용한 범위가 아닙니다.");
		}
		
		this.x  = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void isValid(int width, int height){
		if(x < 1){
			throw new IllegalArgumentException("x값은 1 이상이어야 합니다.");
		}
		if(y < 1){
			throw new IllegalArgumentException("y값은 1 이상이어야 합니다.");
		}
		if(x > width){
			throw new IllegalArgumentException(String.format("x값이 가로 최대 범위를 초과하였습니다. 가로 최대범위는 %d", width));
		}
		if(y > height){
			throw new IllegalArgumentException(String.format("y값이 세로 최대 범위를 초과하였습니다. 세로 최대범위는 %d", height));
		}
	}
	
	public void isValidContainingWall(int width, int height){
		if(x > width+1){
			throw new IllegalArgumentException();
		}
		if(y > height+1){
			throw new IllegalArgumentException();
		}
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
