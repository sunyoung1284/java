import java.util.Random;
import java.util.Scanner;

public class Test18 {
	public static void main(String[] args) {



	int user;
	int computer;
	Scanner s = new Scanner(System.in);
	Random r = new Random();
	
	for(int i =0; i<3; i++) {
		System.out.println("화면에 주사위를 굴릴까요?(종료하려면 q입력");
		 String inputString = s.nextLine();
		 if(inputString.equalsIgnoreCase("q")) {
	     System.out.println("게임종료");
	     break;
		 }
		 
	String enter1 = s.nextLine();
	user = r.nextInt(6)+1;
	System.out.println(user);
	String enter2 = s.nextLine();
	computer =r.nextInt(6)+1;
	System.out.println(computer);
	if (user==computer) {
		System.out.println("Draw");
		}else if (user > computer) {
			System.out.println("You Win!");
		}else if(user< computer) {
			System.out.println("You Lose!");
		}}}}