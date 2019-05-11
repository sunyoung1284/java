package practice5;
//게임을 만들어봥!
//이름 hp 
//상태
//파워
//어택파워
public class Enemy {
	String name;
	int hp =0;
	Enemy(String name,int hp){
		this.name=name;
		this.hp=hp;
	}
	
	public boolean status() {
		if(hp>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getAttackPower() {
		return 10;
	}
	public void beUnderAttack(int attackPower) {
		hp=hp-attackPower;
		System.out.println("enemy가"+attackPower+"의 데미지를 입었습니다.");
		
		
	}
}
