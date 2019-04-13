import java.util.Random;


public class Enemy {
	String name = "";
	int hp = 0;
	int enemyProperty = 0;
	int enemyHitRate = 0;
	String[] namearr = {"JS","JW","SC","BK","SY"};
	
	// enemyProperty : fire = 0, water = 1, grass = 2	
	
	Random random = new Random();
	
	Enemy() {
		int a = random.nextInt(5);
		this.name = namearr[a];
		this.hp = random.nextInt(101)+80;
		this.enemyProperty = random.nextInt(2);
		this.enemyHitRate = random.nextInt(21)+10;
		
	}
	// enemy의 체력 확인
	public boolean status() {
		if (hp > 0) {
			return true;
		} return false;

		
	}
	//enemy가 player에게 공격받는 hitRate 계산 (속성값에 따라)
	public void beUnderAttack(int playerProperty, int playerHitRate) {
		Random random = new Random();
		
		// player가 enemy에게 공격을 성공한 경우
		int hitNumber = random.nextInt(4);
		if (hitNumber <= 2) {
			if (playerProperty == 0 && enemyProperty == 1) {
				hp = hp - (playerHitRate-2);
				System.out.println(this.name + "이(가)" + (playerHitRate-2) + "의 피해를 입었습니다.");
			} else if (playerProperty == 0 && enemyProperty == 2) {
				hp = hp - (playerHitRate+5);
				System.out.println(this.name + "이(가)" + (playerHitRate+5) + "의 피해를 입었습니다.");
			} else if (playerProperty == 1 && enemyProperty == 0) {
				hp = hp - (playerHitRate-2);
				System.out.println(this.name + "이(가)" + (playerHitRate-2) + "의 피해를 입었습니다.");
			} else if (playerProperty == 1 && enemyProperty == 2) {
				hp = hp - (playerHitRate+5);
				System.out.println(this.name + "이(가)" + (playerHitRate+5) + "의 피해를 입었습니다.");
			} else if (playerProperty == 2 && enemyProperty == 1) {
				hp = hp - (playerHitRate-2);
				System.out.println(this.name + "이(가)" + (playerHitRate-2) + "의 피해를 입었습니다.");
			} else if (playerProperty == 2 && enemyProperty == 0) {
				hp = hp - (playerHitRate+5);
				System.out.println(this.name + "이(가)" + (playerHitRate+5) + "의 피해를 입었습니다.");
			} else {
				hp = hp - playerHitRate;
				System.out.println(this.name + "이(가)" + playerHitRate + "의 피해를 입었습니다.");
			}
		// enemy가 공격을 회피할 경우	
		} else {
			System.out.println(this.name + "이(가) 공격을 회피했습니다.");
		}
		
	}

}