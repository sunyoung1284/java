
public class Test16 {
	public static void main(String[] args) {
	
		int totalScore = 0;
		int totalScore1= 0;
		for (int i =0; i < 101; i++) {
			if (i%2==0) { 
				totalScore= totalScore+i;
			}else {
				totalScore1=totalScore1+i;
			}
		}System.out.println("짝수 총합은  "+totalScore);
		 System.out.println("홀수 총합은  "+totalScore1);
		 
		}
}
