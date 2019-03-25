import java.util.Scanner;

//1~100까지 숫자 중에서 소수 출력하기
public class Test26 {
	public void doCheck(int inputNumber){
		if (inputNumber <1) {
			System.out.println("양수를 입력하세요.");
			return;
		}
		
		boolean isPrimeNumber=true;
		for(int i=2; i<inputNumber/2; i++){
			if(inputNumber % i==0) {
				isPrimeNumber = false;
			break;
				}}
			if (isPrimeNumber) {
				System.out.println("" + inputNumber + "는 소수입니다.");
}
			}
			
	
			
}
