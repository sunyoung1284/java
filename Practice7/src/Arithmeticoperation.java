import java.util.Scanner;

//두개의 숫자를 입력받아 두개의 숫자를 입력 받는 프린트문을 만들공
//더하기 사칙연산 해보거랑
public class Arithmeticoperation {
	Scanner scanner =new Scanner(System.in);
	int number1=0;
	int number2=0;
	public void inputnumber() {
		System.out.println("첫번째 숫자를 입력하세요");
		this.number1=scanner.nextInt();
		System.out.println("두번째 숫자를 입력하세요");
		this.number2=scanner.nextInt();
		
		
	}
	public void printResult() {
		System.out.println("입력한 숫자는"+number1+","+number2+"입니다.");
	}

}
