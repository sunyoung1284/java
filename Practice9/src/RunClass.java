import java.util.Random;
import java.util.Scanner;

public class RunClass {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("0은 원의넓이, 1은 사각형 넓이");
		int selectmenu = scanner.nextInt();

		Figure figure = null;
		if (selectmenu == 0) {
//			Circle figure= new Circle();
			figure = new Circle();
		} else {
			figure = new Square();
		}

		figure.areaResult();
		figure.result();

	}

}
