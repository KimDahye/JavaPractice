public class Node {
	private int row;
	private int col;

	public Node(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public int getRow(){
		return row;
	}
	
	public int getCol()
	{
		return col;
	}
	
	public boolean equals(Node node){
		if(node.getRow() == row && node.getCol() == col){
			return true;
		}
		return false;
	}
}
