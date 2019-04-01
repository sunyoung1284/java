import java.util.Scanner;

public class Run33 {
	public static void main(String[] args) {
		Test33 [] sArray= new Test33[5];
		for(int i=0; i<sArray.length;i++) {
			sArray[i]=new Test33();
			sArray[i].inputScore();
		
		}
		int korTotal=0;
		int engTotal=0;
		int mathTotal=0;
		
		for(int i =0; i<sArray.length; i++) {
			korTotal =korTotal+sArray[i].korScore;
			engTotal =korTotal+sArray[i].engScore;
			mathTotal =korTotal+sArray[i].mathScore;
			
		}
		System.out.println("국어 총점은:"+ korTotal);
		System.out.println("영어 총점은:"+ engTotal);
		System.out.println("수학 총점은:"+ mathTotal);
		
		System.out.println("국어 평균은:"+ ( (double)korTotal/sArray.length));
		System.out.println("영어 평균은:"+ ( (double)engTotal/sArray.length));
		System.out.println("수학 평균은:"+ ( (double)mathTotal/sArray.length));
		

		
		
	}

}
