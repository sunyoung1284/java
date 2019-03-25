import java.util.Scanner;

public class Test25 {
	public void doCheck(){
		Scanner scanner =new Scanner(System.in);
		System.out.println ("검사할 숫자를 입력해주세요");
		int inputNumber=scanner.nextInt();
		if(inputNumber<1) {
			System.out.println("양수만 입력해 주세요.");
			return;
		}
		
		
		boolean isPrimeNumber = true;
		for (int i= 2; i < inputNumber/2; i++) {
			if (inputNumber % i==0) {
				isPrimeNumber = false;
				break;
				
			}
		}
		if (isPrimeNumber) {
			System.out.println("소수입니다");
		}else {
			System.out.println("소수가 아닙니다");
		}
		
	}

}
