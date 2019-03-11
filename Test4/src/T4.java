import java.util.Scanner;

public class T4 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("첫번째 숫자를 입력해주세요");
		int number2 = s.nextInt();
		System.out.println("두번째 숫자를 입력해주세요");
		int number3 = s.nextInt();
		int sumNumber=number2+number3;
		System.out.printf("%d와 %d의 합은 %d입니다.", number2, number3, sumNumber);
		
	
}

}
