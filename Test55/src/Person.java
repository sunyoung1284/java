//삼육구삼육구!!삼육구!삼육구!!!
//조별로 369게임 완성
//-
//조별로 경마게임 작성
//시작점과 끝점 ,한번에 달리는 거리 변화주기,결승통과 어떤말이 몇등인지
public class Person {
	String name;
	Person[] players;
	int position=0;
	int startNumber=0;
	int endNumber=0;
	int sayNumber=0;
	
	Person(String name){
		this.name=name;
	}
	public void readyGame(Person[] players,int position,int startNumber, int endNumber) {
		this.players = players;
		this.position = position;
		this.startNumber= startNumber;
		this.endNumber =endNumber;
		
	}
	public void sayNumber() {
		int prevPosition=this.position-1;
		if(prevPosition<0) {
			prevPosition=this.players.length-1;
		}
		if(this.sayNumber==-1) {//너가 시작하는 사람이야.
			this.sayNumber=this.startNumber;
		}else {
			this.sayNumber=this.players[prevPosition].sayNumber+1;
		}
//		this.sayNumber=this.players[(this.position+(this.players.length-1))%this.players.length].sayNumber+1;
		
		
		String stringSayNumber = Integer.toString(sayNumber);
		int count = 0;
		String clap = "짝";
		for (int i = 0; i < stringSayNumber.length(); i++) {
			char[] tempArr = String.valueOf(sayNumber).toCharArray();
			if(tempArr[i] == '3' || tempArr[i] == '6' || tempArr[i] == '9') {
				count++;
			}
		}
		if(count == 0) {
			System.out.println(this.name + " say " + this.sayNumber);
		}
		else if(count==1) {
			clap = clap;
			System.out.println(this.name + " say " + clap);
		}else {
			clap = clap + clap;
			System.out.println(this.name + " say " + clap);
		}

		int nextPosition = (this.position + 1) % this.players.length;
		if(this.sayNumber < this.endNumber) {
			this.players[nextPosition].sayNumber();
		}
		
	}
	public void gameStart() {
		this.sayNumber=-1;//시작자 구분 지어 주기
		this.sayNumber();
		
	}

}
