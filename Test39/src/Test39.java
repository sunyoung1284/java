import java.util.Scanner;

public class Test39 {

	int number1;
	int number2;

	public void inputNumber() {
		Scanner scanner = new Scanner(System.in);
		String tmp;
		System.out.println("첫번째 숫자를 입력하세요");
		tmp = scanner.nextLine();
		try {// 오류 잡을려고 씀
			this.number1 = Integer.parseInt(tmp);

		} catch (Exception e) {
			// TODO: handle exception
			this.number1 = 0; // default값 (위에서 에러가 나면 이거 실행)
		}
		System.out.println("두번째 숫자를 입력하세요");
		tmp = scanner.nextLine();
		try {
			this.number2 = Integer.parseInt(tmp);

		} catch (Exception e) {
			// TODO: handle exception
			this.number2 = 0;
		}

	}

	public void division() {
		double divisionResult = 0;
		divisionResult = (double) this.number1 / this.number2;

		divisionResult = (double) Math.round(divisionResult * 100) / 100;

		System.out.println("" + this.number1 + " 나누기 " + this.number2 + " = " + divisionResult + " 입니다");

	}

}
