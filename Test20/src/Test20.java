import java.util.Arrays;
import java.util.Scanner;

public class Test20 {
public static void main(String[] args) {
	Scanner scanner= new Scanner(System.in);
	int[] korScore= new int[10];

	for(int i=0; i<korScore.length; i++) {
		System.out.println("국어점수:");
	    korScore[i]=scanner.nextInt();
	   }
	   System.out.println(Arrays.toString(korScore));
	   
       int total=0;
       double avr=0;
       
       for (int i =0; i < korScore.length; i++) {
    	   total = total+korScore[i];
    	   
       }
	avr =(double) total/korScore.length;
	System.out.println("총점은 : "+ total);
	System.out.println("평균은 : "+ avr );
}
}
