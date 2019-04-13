import java.util.Scanner;

public class Runclass {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1.원 넓이 구하기,2.사각형 넓이 구하기");
		int selectMenu =scanner.nextInt();
		
		Figure figure=null; //Figure figure =new Figure();를 사용할수 없음 자식 클래스를 불러와야하기 때문
		if(selectMenu==1) {	
			figure = new Childclass();
		}else if (selectMenu==2) {
			figure = new Square();
		}
		
		figure.inputValue();
		figure.printResult();
	}
}
