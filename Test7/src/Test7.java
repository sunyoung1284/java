import java.util.Random;

public class Test7 {
	public static void main(String[] args) {
	Random r = new Random();
	int randomValue = r.nextInt(100);
	System.out.println("���� ���� :" + randomValue);
	//System.out.print("�������� : ");
	//System.out.print(randomValue);
	//System.out.println();
	System.out.println("������ :" + randomValue%2);
	
	if(randomValue%2 ==1) {
		System.out.println("Ȧ�� �Դϴ�.");
		}else {
			System.out.println("¦�� �Դϴ�.");
		}

}

}
