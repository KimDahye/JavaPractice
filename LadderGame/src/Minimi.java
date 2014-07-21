import java.util.ArrayList;

public class Minimi {
	ArrayList<Node> path;
	int startingPos;
	Node presentPos;

	public Minimi(int startingPos) {
		this.startingPos = 2 * startingPos - 1;
		presentPos = new Node(0, this.startingPos);
		path.add(presentPos);
		
	}

	public void run(Ladder ladder) {
		while(!ladder.isEnd(presentPos)){
			if(ladder.isCrossable(presentPos) && !isPassed())
			{
				cross();
				continue;
				  
			}
			
			moveForward();
		}
	}
	
	private void cross(){
		//미니미 현재 포지션 왼쪽으로 두칸, 혹은 오른쪽으로 두칸 바꿔줌
		//path에 경로 더하기
	}
	
	private void moveForward(){
		presentPos = new Node(presentPos.getRow() + 1, presentPos.getCol());
		path.add(presentPos);
	}
	
	private boolean isPassed(){
		//isCrossable(presentPos)가 true임을 가정하고 시작. (&& 연산자의 성질 이용)
		
		for(int i = 0; i<path.size(); i++){
			if(path.get(i).equals(left()) || path.get(i).equals(right())){
				return true;
			}
		}
		return false;
	}
	
	private Node left(){
		return new Node(presentPos.getRow(), presentPos.getCol()-1);
	}
	
	private Node right(){
		return new Node(presentPos.getRow(), presentPos.getCol()+1);
	}
	

}
