import java.util.Scanner;


public class Test38 {
	int number1=0;
	int number2=0;
	public void inputNumbers() {
		System.out.println("두개의 숫자를 입력해주세요.");
		System.out.println("첫번째 숫자 입력");
		Scanner scanner =new Scanner(System.in);
		this.number1= scanner.nextInt();
		
		System.out.println("두번째 숫자 입력");
		this.number2= scanner.nextInt();
		
	}
	public void printResult() {
		System.out.println("입력된 숫자는"+this.number1+","+this.number2+"입니다.");
		
	}

}
