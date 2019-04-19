import java.util.Scanner;

//5명의 데이터 이름 (국어,영어,수학) 총점 평균 구하고, 전체 데이터를 출력
public class Practice3 {
	
	int korScore=0;
	int engScore=0;
	int mathScore=0;
	
	public void inputScore() {
		Scanner scanner =new Scanner(System.in);
		System.out.println("국어 점수를 입력하세요");
		korScore=scanner.nextInt();
		System.out.println("영어 점수를 입력하세요");
		engScore=scanner.nextInt();
		System.out.println("수학 점수를 입력하세요");
		mathScore=scanner.nextInt();
		System.out.println("국어점수:"+korScore+"영어점수:"+engScore+"수학점수"+mathScore);
		
		
		
	}

}
