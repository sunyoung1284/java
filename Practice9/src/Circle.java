import java.util.Scanner;

public class Circle extends Figure {
	String name= "원의 넓이는";
	int radius =0;
	double pi=3.14;
	double area=0;
	public void areaResult() {
		Scanner scanner =new Scanner(System.in);
		System.out.println("반지름을 입력하세욤");
		this.radius=scanner.nextInt();
		}
	public void result() {
		super.result();
		this.area=(double)this.radius*this.pi;
		System.out.println(name+area+"입니다.");
		
	}
	
	

}
