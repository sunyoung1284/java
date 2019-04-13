import java.util.Scanner;

public class Square extends Figure {
	double width=0;
	double height=0;
	
	@Override //추상화 메소드는 무조건 상속받는애한테 기능 구현
	public void inputValue() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("폭을 입력하세요");
		this.width=scanner.nextDouble();
		System.out.println("길이를 입력하세요");
		this.height=scanner.nextDouble();
	}
	
	public void printResult() {
		super.printResult();
		System.out.println("사각형의 넓이는:"+ (this.width*this.height));
	}

}
