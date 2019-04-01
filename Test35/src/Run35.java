
public class Run35 {
	public static void main(String[] args) {
		Test35 [] sArray= new Test35[5];
		for(int i=0; i<sArray.length;i++) {
			sArray[i]=new Test35((i+1)+"번 학생");
			sArray[i].inputScore();
	}
	
		
		for(int i =0; i<sArray.length; i++) {
			System.out.println(sArray[i]);
			
		
		}		
}}
