package practice5;

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Player[]player=new Player[3];
		player[0]=new Player("선영",100);
		player[1]=new Player("새별",100);
		player[2]=new Player("은솔",100);
		Enemy[] enemy =new Enemy[3];
		enemy[0]=new Enemy("혜은",50);
		enemy[1]=new Enemy("고운",50);
		enemy[2]=new Enemy("똥꼬",50);
		
		for(int i=0; i<5; i++) {
			System.out.println("턴 진행은 엔터쳐");
			Scanner scanner =new Scanner(System.in);
			scanner.nextLine();
			for(int j=0; j<enemy.length; j++) {
				if(enemy[j].status()) {
					int attackPower=player[0].getAttackPower();
					enemy[j].beUnderAttack(attackPower);
					
					
				}
			}
			for(int j=0; j<player.length; j++) {
				if(player[j].status()) {
					int attackPower=enemy[0].getAttackPower();
					player[j].beUnderAttack(attackPower);	
		}
			}}
		int enemyCount=0;
		for(int i=0; i<enemy.length; i++) {
			if(enemy[i].status()) {
				enemyCount++;
			}
		}
		int playerCount=0;
		for(int i=0; i<player.length; i++) {
			if(player[i].status()) {
				playerCount++;
			}
		}
		if(enemyCount==playerCount) {
			System.out.println("너네 비겼음");
		}else if(enemyCount<playerCount) {
			System.out.println("ㅇㅇ 선영 새별 은솔 이겼엉!!"
					+ "");
		}else {
			System.out.println(";;혜은 고운 똥꼬 같은 것들이 이김");
		}
		
	}

}
