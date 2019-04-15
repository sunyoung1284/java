import java.util.Random;
import java.util.Scanner;
public class Test45  {
	String name;
	int korScore;
	int engScore;
	int mathScore;
	int total;
	
	public String toSting() {
		return this.name + "총점:"+ this.total+
	}
	
	public void inputScore() {
		Scanner scan = new Scanner(System.in);
		Random random =new Random();
		System.out.println("이름:");
		this.name=scan.nextLine();
		System.out.println("국어점수:");
		this.korScore=random.nextInt(100);
		System.out.println(korScore);
		System.out.println("영어점수:");
		this.engScore=random.nextInt(100);
		System.out.println(engScore);
		System.out.println("수학점수:");
		this.mathScore=random.nextInt(100);
		System.out.println(mathScore);
		
		
	}

}
