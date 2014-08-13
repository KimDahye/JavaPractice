package ladder;

public class Ladder {
	Row ladder[];
	
	public Ladder(NaturalNumber height, NaturalNumber numOfPeople) {
		ladder = new Row [height.getNumber()];
		for(int i=0; i<height.getNumber(); i++){
			ladder[i] = new Row(numOfPeople);
		}
	}
	
	public void DrawLine(NaturalNumber height, NaturalNumber personPosition){
		if(height.getNumber() > ladder.length){
			throw new IllegalArgumentException(String.format("사다리 높이는 %d입니다. 이 이하로 입력해야 합니다.", ladder.length));
		}
		int numOfPeople = ladder[0].GetLength();
		if(personPosition.getNumber() > numOfPeople - 1){
			throw new IllegalArgumentException(String.format("사람수는 %d 까지 입력할 수 있습니다.", numOfPeople - 1));
		}
		
		ladder[height.getIndex()].DrawLine(personPosition);
	}
	
	public int Run(NaturalNumber position) {
		int numOfPeople = ladder[0].GetLength();
		if(position.getNumber() > numOfPeople){
			throw new IllegalArgumentException(String.format("사람수는 %d명입니다.", numOfPeople));
		}
		
		NaturalNumber result = ladder[0].Move(position);
		for(int i = 1; i < ladder.length; i++){
			result = ladder[i].Move(result);
		}
		return result.getNumber();
	}
	
	public void Print(){
		for(int i = 0; i<ladder.length; i++){
			ladder[i].Print();
			System.out.println();
		}
	}
}
