import java.util.Scanner;

public class Run35 {
	public static void main(String[] args) {
		Practice35 [] sArray=new Practice35[5];
		for(int i=0; i<sArray.length; i++){
			sArray[i] = new Practice35();
			sArray[i].inputScore();
		
		}
		int middleTotal=0;
		int finalTotal=0;
		for(int i=0; i<sArray.length; i++) {
			middleTotal=middleTotal+sArray[i].middleScore;
			finalTotal=finalTotal+sArray[i].finalScore;
			
		}
		System.out.println("중간고사 총점:"+ middleTotal);
		System.out.println("기말고사 총점:"+ finalTotal);
		
		
		System.out.println("중간고사 평균:"+((double)middleTotal /sArray.length));
		System.out.println("기말고사 평균:"+((double)finalTotal/sArray.length));
		
		
	}

}
