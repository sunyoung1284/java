//확장클래스
//상속 extends 1.기능 추가(확장),2.부모클래스 이름으로 변수지정 3.메서드 강제를 위해
public class Test2 extends Test38 {
	public void printResult() {
		super.printResult();//부모클래스꺼 실행해 super는 부모 클래스 접근 할때
		System.out.println("더하기 결과:" + (this.number1+this.number2));
		System.out.println("빼기 결과:" + (this.number1-this.number2));
		System.out.println("곱하기 결과:" + (this.number1*this.number2));
		System.out.println("나누기 결과:" + (this.number1/this.number2));
	}
	public void newMethod() {
		
	}
}
