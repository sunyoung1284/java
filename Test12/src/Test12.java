import java.util.Scanner;

public class Test12 {
	public static void main(String[] args) {
		int a;
		int b;
		int c;
		
		Scanner score = new Scanner(System.in);
		
		System.out.println("국어 점수를 입력해주세요(총3명)");
		System.out.print("홓길동의 국어점수:");
		a=score.nextInt();
		System.out.print("임꺽정의 국어점수:");
		b=score.nextInt();
		System.out.print("윤봉길의 국어점수:");
		c=score.nextInt();
		
		System.out.println("입력 받은 점수 홍길동"+ a + "점 " +"임꺽정"+ b +"점"+"윤봉길"+ c +"점");
		
		a = score.nextInt();
		b = score.nextInt();
		c = score.nextInt();
		
		if (a>b && a>c && b> c) {
			System.out.println("1등 : 홍길동 ("+ a + "점)");
				
					
			
		}else if(a>b && a>c && b<c) {
			
		}else if(b>a && b>c && a>c) {
			
		}else if(b>a && b>c && a<c) {
			
		}else if(c>a && c>2 && a>b) {
			
		}else if(c>a && c>b && a<b) {
			
		}
}
	
}

	   