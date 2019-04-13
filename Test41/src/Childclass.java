import java.util.Scanner; //ctrl+Shift +f는 정렬

public class Childclass extends Figure {
	Childclass(){
		this.name="원의 넓이 구하기";
	}
	
	double side1 = 0;
	double pi = 3.14;
	double area = 0;

	public void inputValue() {
		System.out.println("반지름을 입력하세요");
		Scanner scanner = new Scanner(System.in);
		this.side1 = scanner.nextDouble();
		this.pi = 3.14;

		area = (double) pi * (this.side1 * this.side1);

	}

	public void printResult() {
		super.printResult();
		System.out.println("원의넓이는:" +"반지름"+ area);
	}

}
