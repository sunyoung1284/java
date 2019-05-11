import java.util.Random;
import java.util.Scanner;

//나랑 컴퓨터랑 주사위 대결
public class Practice4 {
	public static void main(String[] args) {
		int user;
		int computer;
		Scanner scanner=new Scanner(System.in);
		
		for(int i=0; i<3; i++) {
			System.out.println("화면에 주사위를 굴릴까요?(종료하려면 q입력");
			String breakpoint=scanner.nextLine();
			if(breakpoint.equalsIgnoreCase("q")) {
				break;
			}
		
		
		
		System.out.println("주사위 값을 입력하세요");
		user=scanner.nextInt();
		System.out.println(user);
		Random random =new Random();
		System.out.println("컴퓨터 주사위 값");
		computer=random.nextInt(6)+1;
		System.out.println(computer);
		
		if(user==computer) {
			System.out.println("draw");
		}else if(user>computer) {
			System.out.println("win");
		}else {
			System.out.println("lose");
		}
		
		
		
		
		
		
		
	}

}}
