import java.util.Random;

public class Test9 {
	public static void main(String[] args) {
	//가위=0 바위=1 보=2
		Random a =new Random();
		int randomA = a.nextInt(3);
		System.out.println("랜덤 숫자 :" + randomA);
		if (randomA==0) {
			System.out.println("가위");}
		if (randomA==1) {
				System.out.println("바위")
		;}if (randomA==2)
			System.out.println("보");
		
}

}
