import java.util.Scanner;

public class Test37 {
	public static void main(String[] args) {
		Player[] player = new Player[5];
		player[0] = new Player("폴리텍", 10);
		player[1] = new Player("폴리텍", 10);
		player[2] = new Player("폴리텍", 10);
		player[3] = new Player("폴리텍", 11);
		player[4] = new Player("폴리텍", 21);
		Enemy[] enemy = new Enemy[5];
		enemy[0] = new Enemy("자바", 100);
		enemy[1] = new Enemy("자동차", 10);
		enemy[2] = new Enemy("나비", 90);
		enemy[3] = new Enemy("잠자리", 120);
		enemy[4] = new Enemy("참새", 200);

		Scanner scanner = new Scanner(System.in);
		System.out.println("턴 진행은 엔터를 입력하세요.");
		for (int i = 0; i < 20; i++) {
			scanner.nextLine();

			for (int j = 0; j < enemy.length; j++) {
				if (enemy[j].status()) {
					int attackPower = player[0].getAttackPower();
					enemy[j].beUnderAttak(attackPower);
				}
			}
			for (int j = 0; j < player.length; j++) {
				if (player[j].status()) {
					int attackPower = enemy[0].getAttackPower();
					player[j].beUnderAttak(attackPower);
				}
			}
		}
		
		int enemyCount = 0;
		for (int j = 0; j < enemy.length; j++) {
			if (enemy[j].status()) {
				enemyCount++;
			}
		}
		int playerCount = 0;
		for (int j = 0; j < player.length; j++) {
			if (player[j].status()) {
				playerCount++;
			}
		}
		if (enemyCount > playerCount) {
			System.out.println("적이 이겼습니다.");
		} else if (enemyCount < playerCount) {
			System.out.println("플레이어가 이겼습니다.");
		} else {
			System.out.println("비겼습니다.");
		}
	}
}