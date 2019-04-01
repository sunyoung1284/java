import java.util.Scanner;

public class Test35 {
	String name;
	int middleScore;
	int finalScore;
	
	Test35(){
		
	}
	Test35(String name){
		this.name=name;
	}
	public void inputScore() {
		Scanner scanner= new Scanner(System.in);
		
		String tmp;
		System.out.println(name+"점수입력");
		System.out.println("중간고사 점수:");
		tmp =scanner.nextLine();
		this.middleScore=Integer.parseInt(tmp);
		
		System.out.println("기말고사 점수:");
		tmp =scanner.nextLine();
		this.finalScore=Integer.parseInt(tmp);
		
	}
	
	@Override
	public String toString() {
		return this.name + "(중간고사"+this.middleScore+ ",기말고사"+this.finalScore+")";
	}
	
	

}
