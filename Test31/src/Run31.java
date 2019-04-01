import java.util.Scanner;

public class Run31 {
	public static void main(String[] args) {
	//	Test31 s1=new Test31();
	//	s1.name="홍길동";
	//	s1.KorScore=100;
	//	s1.engScore=30;
	//	s1.mathScore=20;
	//	s1.memo="매사에 진취적임";
		
		Test31[] sArray= new Test31[10];
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<sArray.length;i++) {
			sArray[i]=new Test31();
			System.out.println(""+(i+1)+"번째 학생 데이터 입력");
			System.out.println("이름:");
			sArray[i].name =scan. nextLine();
			System.out.println("국어점수:");        //"100" -> 100
			String korString=scan.nextLine();
			sArray[i].korScore=Integer.parseInt(korString);
			System.out.println("영어점수:");
			String engString =scan. nextLine();
			sArray[i].engScore=Integer.parseInt(engString);
			System.out.println("수학점수:");
			String mathString =scan. nextLine();
			sArray[i].mathScore=Integer.parseInt(mathString);
			scan.nextLine();
			
		}
		
	}

}
