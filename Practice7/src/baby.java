
public class baby extends Arithmeticoperation{
	public void printResult() {
		super.printResult();//부모클래스꺼 실행해 super는 부모 클래스 접근 할때
		System.out.println("더하기 결과:" + (this.number1+this.number2));
		System.out.println("빼기 결과:" + (this.number1-this.number2));
		System.out.println("곱하기 결과:" + (double)(this.number1*this.number2));
		System.out.println("나누기 결과:" + ((double)this.number1/this.number2));//캐스팅을 바로 옆에 해주쟈!
	
	
	}
	}


