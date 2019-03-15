import java.util.Random;

public class Test7 {
	public static void main(String[] args) {
	Random r = new Random();
	int randomValue = r.nextInt(100);
	System.out.println("랜덤 숫자 :" + randomValue);
	//System.out.print("랜덤숫자 : ");
	//System.out.print(randomValue);
	//System.out.println();
	System.out.println("나머지 :" + randomValue%2);
	
	if(randomValue%2 ==1) {
		System.out.println("홀수 입니다.");
		}else {
			System.out.println("짝수 입니다.");
		}

}

}
