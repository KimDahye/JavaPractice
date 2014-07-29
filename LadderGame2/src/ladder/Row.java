package ladder;

public class Row {
	int people[];

	public Row(int numOfPeople) {
		people = new int[numOfPeople];
	}

	public void DrawLine(int position) {
		if (position >= people.length - 1) {
			System.out.println("사다리의 범위를 초과하였습니다.");
			return;
		}
		
		if (people[position] == -1 || people[position+1] ==1) {
			System.out.println("이미 라인이 그려진 곳이라 또 그을 수 없습니다.");
			return;
		}
		
		people[position] = 1;
		people[position+1] = -1;
	}
	
	public int Move(int position){
		if(position<0 || position >= people.length){
			System.out.println("Error: @class-Row method-Move");
			return -1; // throw로?
		}
		
		if(people[position] == 1){
			return position + 1;
		}
		if(people[position] == -1){
			return position - 1;
		}
		return position;
	}
}
