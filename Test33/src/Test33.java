import java.util.Scanner;

//5명의 데이터 이름 (국어,영어,수학) 총점 평균 구하고, 전체 데이터를 출력
public class Test33 {
	String name;
	int korScore;
	int engScore;
	int mathScore;
	
	public void inputScore() {
		Scanner scan = new Scanner(System.in);
		System.out.println("이름:");
		this.name=scan.nextLine();
		
		System.out.println("국어점수:");
		String tmp =scan.nextLine();
		this.korScore=Integer.parseInt(tmp);
		
		System.out.println("영어점수:");
		tmp =scan.nextLine();
		this.engScore=Integer.parseInt(tmp);
		
		System.out.println("수학점수:");
		tmp =scan.nextLine();
		this.mathScore=Integer.parseInt(tmp);
		
		
	}
	
	
		
	}
	

