import java.util.Scanner;

public class Square extends Figure {
	String name= "사각형의 넓이는";
	int horizontal =0;
	int vertical;
	double area=0;
	public void areaResult() {
		Scanner scanner =new Scanner(System.in);
		System.out.println("가로 길이를 입력하세용");
		this.horizontal=scanner.nextInt();
		System.out.println("세로 길이를 입력하세용");
		this.vertical=scanner.nextInt();
		}
	public void result() {
		super.result();
		this.area=this.horizontal*this.vertical;
		System.out.println(name+area+"입니다.");
		
	}

}
