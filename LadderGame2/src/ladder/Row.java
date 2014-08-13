package ladder;

public class Row {
	int people[];
	
	public Row(NaturalNumber numOfPeople) {
		people = new int[numOfPeople.getNumber()];
	}
	
	public void DrawLine(NaturalNumber position) {
		if (position.getIndex() >= people.length - 1) {
			throw new IllegalArgumentException("error @DrawLine: 선을 그릴 수 있는 사다리의 범위를 초과하였습니다.");
		}
		
		if (people[position.getIndex()] == -1 || people[position.getIndex() + 1] == 1) {
			throw new IllegalArgumentException("error @DrawLine: 이미 라인이 그려진 곳이라 또 그을 수 없습니다.");
		}
		
		people[position.getIndex()] = 1;
		people[position.getIndex() + 1] = -1;
	}

	public NaturalNumber Move(NaturalNumber position){
		if(position.getIndex() > people.length - 1){
			throw new IllegalArgumentException("error @Move: position 범위를 초과하였니다.");
		}
		
		if(people[position.getIndex()] == 1){
			return new NaturalNumber(position.getNumber() + 1);
		}
		if(people[position.getIndex()] == -1){
			return new NaturalNumber(position.getNumber() - 1);
		}
		return new NaturalNumber(position.getNumber());
	}
	
	public void Print(){
		for(int i = 0; i<people.length; i++){
			if(people[i] == 1){
				System.out.print(" |-");
				continue;
			}
			if(people[i] == -1){
				System.out.print("-| ");
				continue;
			}
			System.out.print(" | ");	
		}
	}
	
	public int GetLength(){
		return people.length;
	}
}
