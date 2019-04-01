import java.util.Scanner;

//5명 이름 중간고사 기말고사  총점 평균
public class Practice35 {
	String name;
	int middleScore;
	int finalScore;
	
	public void inputScore() {
		Scanner scanner=new Scanner (System.in);
		System.out.println("이름:");
		this.name=scanner.nextLine();
		
		System.out.println("중간고사 점수:");
		String tmp;
		tmp= scanner.nextLine();
		this.middleScore=Integer.parseInt(tmp);
		
		
		System.out.println("기말고사 점수:");
		tmp=scanner.nextLine();
		this.finalScore=Integer.parseInt(tmp);
	}
	

}
