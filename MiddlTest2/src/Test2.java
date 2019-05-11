import java.util.Scanner;
//2. 사용자로 부터 숫자를 하나 입력 받고 입력 받은 숫자까지의 합과 곱을 구하시오.
//
//(ex. 사용자로 부터 입력 받은 숫자 : 5, 결과 값 : 1~5까지 합 출력, 1~5까지 곱 출력 (5!))
//
//(제약 사항)
//
//1) 클래스 - 메서드 (객체 지향 프로그래밍) 방식으로 작성하세요.
//
//2) 사용자로부터 입력 받은 숫자는 문자열로 입력을 받은 후 숫자로 변환하세요.

public class Test2 {
	Scanner scanner = new Scanner(System.in);
	int number1;
	int sum = 0;
	int multiply = 1;

	public void inputNumber() {
		System.out.println("숫자를 입력하세요");
		String tmp = scanner.nextLine();
		this.number1 = Integer.parseInt(tmp);
		System.out.println("입력하신 숫자는 :" + this.number1);

	}

	public void printResult() {
		for (int i = 1; i <= this.number1; i++) {
			sum += i;
			multiply = multiply * i;

		}
		System.out.println("합:" + sum);
		System.out.println("곱:" + multiply);

	}

}
