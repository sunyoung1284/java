import java.util.Random;
import java.util.Scanner;

public class Player {

	String name = "";
	int hp = 0;
	int playerProperty = 0;
	int playerHitRate = 0;
	
// playerProperty : fire = 0, water = 1, grass = 2	
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	
	Player() {
	// hp는 150으로 고정, 이름&속성은 input값, 공격력은 10~20사이  랜덤값
		this.hp = 150;
		this.playerHitRate = random.nextInt(21)+10;
	}
	// player 남은 체력 확인
	public boolean status() {
		if (hp > 0) {
			return true;
		}
		return false;
	
	}
	// player가 enemy로 부터 공격받는 hitRate 계산 (속성값에 따라)
	public void beUnderAttack(int enemyProperty, int enemyHitRate) {
		Random random = new Random();
		// player가 enemy에게 공격을 성공한 경우 
		int hitNumber = random.nextInt(10);
		if (hitNumber <= 3) {
			if (playerProperty == 0 && enemyProperty == 1) {
				hp = hp - (enemyHitRate+5);
				System.out.println(this.name + "이(가)" + (enemyHitRate+5) + "의 피해를 입었습니다.");
			} else if (playerProperty == 0 && enemyProperty == 2) {
				hp = hp - (enemyHitRate-2);
				System.out.println(this.name + "이(가)" + (enemyHitRate-2) + "의 피해를 입었습니다.");
			}else if (playerProperty == 1 && enemyProperty == 0) {
				hp = hp - (enemyHitRate+5);
				System.out.println(this.name + "이(가)" + (enemyHitRate+5) + "의 피해를 입었습니다.");
			} else if (playerProperty == 1 && enemyProperty == 2) {
				hp = hp - (enemyHitRate-2);
				System.out.println(this.name + "이(가)" + (enemyHitRate-2) + "의 피해를 입었습니다.");
			} else if (playerProperty == 2 && enemyProperty == 1) {
				hp = hp - (enemyHitRate+5);
				System.out.println(this.name + "이(가)" + (enemyHitRate+5) + "의 피해를 입었습니다.");
			} else if (playerProperty == 2 && enemyProperty == 0) {
				hp = hp - (enemyHitRate-2);
				System.out.println(this.name + "이(가)" + (enemyHitRate-2) + "의 피해를 입었습니다.");
			} else {
				hp = hp - enemyHitRate;
				System.out.println(this.name + "이(가)" + enemyHitRate + "의 피해를 입었습니다.");
			}
		// enemy가 공격을 회피할 경우	
		} else {
		System.out.println(this.name + "이(가) 공격을 회피했습니다.");
	}
	}
}
