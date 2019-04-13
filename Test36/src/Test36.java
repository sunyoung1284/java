import java.util.Scanner;

public class Test36 {
	public static void main(String[] args) {
		Player player = new Player();
		Enemy[] enemy = new Enemy[5];
		// create enemies
		for (int i = 0; i < enemy.length; i++) {
			enemy[i] = new Enemy();
		}

		// turn 진행
		Scanner scanner = new Scanner(System.in);

		// 플레이어 스탯 설정
		System.out.print("플레이어의 이름을 입력하세요 : ");
		player.name = scanner.nextLine();
		System.out.print("속성을 선택하세요");
		System.out.print("1. 불  2. 물  3. 풀   :"); // 불 > 물 > 풀 > 불
		int playerProp = scanner.nextInt();
		scanner.nextLine();

		switch (playerProp) {
		case 1:
			player.playerProperty = 0;
			break;
		case 2:
			player.playerProperty = 1;
			break;
		case 3:
			player.playerProperty = 2;
			break;
		default:
			System.out.println("1,2,3 내에서 선택해주세요"); // 다른값을 넣지 못했을때, 반복설정할것
		}

		for (int i = 0; i < 10000; i++) {
			System.out.println("게임을 시작합니다. 턴 진행은 엔터를 입력하세요.");
			scanner.nextLine();

			// 플레이어가 적을 선택한다.
			int enemySelect = 0;
			System.out.println("공격할 적을 선택하세요 : ");
			for (int m = 0; m < enemy.length; m++) {
				// 적의 상태가 살아있는 상태인 적만 메뉴를 생성
				if (enemy[m].status())
					System.out.printf("%d. %s \n", m + 1, enemy[m].name);
			}
			enemySelect = scanner.nextInt();
			scanner.nextLine();

			// 선택한 적에 따라서 공격을 한다. dp값을 던져주는데 속성에 따라 던져준다. 반복설정할것
			switch (enemySelect) {
			case 1:
				enemy[0].beUnderAttack(player.playerProperty, player.playerHitRate);
				break;
			case 2:
				enemy[1].beUnderAttack(player.playerProperty, player.playerHitRate);
				break;
			case 3:
				enemy[2].beUnderAttack(player.playerProperty, player.playerHitRate);
				break;
			case 4:
				enemy[3].beUnderAttack(player.playerProperty, player.playerHitRate);
				break;
			case 5:
				enemy[4].beUnderAttack(player.playerProperty, player.playerHitRate);
				break;
			default:
				System.out.println("1-5안에서만 선택해주세요!!!");
			}

		}

		// 끝날때를 결정한다.
		boolean nonDefeat = false;
		for (int j = 0; j < enemy.length; j++) {
			if (enemy[j].status()) {
				nonDefeat = true;
			}
		}
		//종료(승리조건) 체크
		if (!nonDefeat) {
			System.out.println("적이 전멸했습니다.플레이어 승");
		}
		
		//살아있는 적의 수만큼만 공격을 받게 설정
		for (int l = 0; l < enemy.length; l++) {
			if (enemy[l].status()) {
				player.beUnderAttack(enemy[l].enemyProperty, enemy[l].enemyHitRate);
				//플레이어 스테이터스 확인 후 종료 결정
				if (player.status()) {
				} 
				else {
					System.out.println("당신은 졌습니다.");
					break;
				}
				
			}
			else {
				continue;
			}
		}

	}
}
