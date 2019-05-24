import java.util.Random;

public class HorseStatus extends Horses implements HorseSetting{

	Random random = new Random();
	
	@Override
	public int setSpd() {
		// TODO Auto-generated method stub
		this.horseSpd = random.nextInt(3);
		return this.horseSpd;
	}

	@Override
	public int moveDistance() {
		// TODO Auto-generated method stub
		this.horseCurDistance = this.horseCurDistance + this.horseSpd;
		return this.horseCurDistance;
	}
	
	public int moving() {
		this.horseSpd = setSpd();
		this.horseCurDistance = moveDistance();
		for (int i = 0; i < this.horseSpd; i++) {
			this.winningTurn++; 							// for문을 돌때마다 winningTurn변수를 증가시켜서 최종적으로 등수를 가리는 용도로 사용
			if(this.totalMoved>=this.maxDistance) {
				break;										// 최종적으로 움직인 거리가 트랙의 길이와 같거나 커지면 더이상 for문을 통과하지않고 탈출하여 moveMotion이 정지한것처럼 보임
			}
			this.moveMotion = this.moveMotion + ".";		// 위의 if문의 조건에 만족되지않으면 moveMotion을 증가시켜 계속적으로 움직이는 듯한 효과
			this.totalMoved++;								// 최종움직인 거리를 지속적으로 갱신하여 트랙의 길이(maxDistance)와 비교할수있도록 증가시킴, 아래는 같으므로 주석 생략
		}
		return horseCurDistance;
	}
	
}
