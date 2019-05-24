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
			this.winningTurn++; 							// for���� �������� winningTurn������ �������Ѽ� ���������� ����� ������ �뵵�� ���
			if(this.totalMoved>=this.maxDistance) {
				break;										// ���������� ������ �Ÿ��� Ʈ���� ���̿� ���ų� Ŀ���� ���̻� for���� ��������ʰ� Ż���Ͽ� moveMotion�� �����Ѱ�ó�� ����
			}
			this.moveMotion = this.moveMotion + ".";		// ���� if���� ���ǿ� �������������� moveMotion�� �������� ��������� �����̴� ���� ȿ��
			this.totalMoved++;								// ���������� �Ÿ��� ���������� �����Ͽ� Ʈ���� ����(maxDistance)�� ���Ҽ��ֵ��� ������Ŵ, �Ʒ��� �����Ƿ� �ּ� ����
		}
		return horseCurDistance;
	}
	
}
