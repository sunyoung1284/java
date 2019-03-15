import java.util.Random;
import java.util.Scanner;


public class Test10 {
	public static void main(String[] args) {
	int gBB1;
	int gBB2;
	
	Random a = new Random();
	gBB1 = a.nextInt(3);
	
	Scanner scan = new Scanner(System.in);
	System.out.print("가위바위보를 입혁해주세요.\n 가위는 0, 바위는 1, 보는  2입니다.");
	gBB2 = scan.nextInt();
	
	System.out.println(gBB1);
	System.out.println(gBB2);
	
	if(gBB1 == gBB2) {
		System.out.println("비겼습니다.");
	}else if (gBB1 ==0 && gBB2 ==1) {
		System.out.println("사용자가 이겼습니다.");
	}else if (gBB1 ==0 && gBB2 ==2) {
		System.out.println("컴퓨터가 이겼습니다.");
	}else if (gBB1 ==1 && gBB2 ==0) {
		System.out.println("컴퓨터가 이겼습니다.");
	}else if (gBB1 ==1 && gBB2 ==2) {
		System.out.println("사용자가 이겼습니다.");
	}else if (gBB1 ==2 && gBB2 ==0) {
		System.out.println("사용자가 이겼습니다.");
	}else if (gBB1 ==2 && gBB2 ==1) {
		System.out.println("컴퓨터가 이겼습니다.");
	}}}
