import java.util.Random;

public class Test9 {
	public static void main(String[] args) {
	//����=0 ����=1 ��=2
		Random a =new Random();
		int randomA = a.nextInt(3);
		System.out.println("���� ���� :" + randomA);
		if (randomA==0) {
			System.out.println("����");}
		if (randomA==1) {
				System.out.println("����")
		;}if (randomA==2)
			System.out.println("��");
		
}

}
