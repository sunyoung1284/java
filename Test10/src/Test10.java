import java.util.Random;
import java.util.Scanner;


public class Test10 {
	public static void main(String[] args) {
	int gBB1;
	int gBB2;
	
	Random a = new Random();
	gBB1 = a.nextInt(3);
	
	Scanner scan = new Scanner(System.in);
	System.out.print("������������ �������ּ���.\n ������ 0, ������ 1, ����  2�Դϴ�.");
	gBB2 = scan.nextInt();
	
	System.out.println(gBB1);
	System.out.println(gBB2);
	
	if(gBB1 == gBB2) {
		System.out.println("�����ϴ�.");
	}else if (gBB1 ==0 && gBB2 ==1) {
		System.out.println("����ڰ� �̰���ϴ�.");
	}else if (gBB1 ==0 && gBB2 ==2) {
		System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
	}else if (gBB1 ==1 && gBB2 ==0) {
		System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
	}else if (gBB1 ==1 && gBB2 ==2) {
		System.out.println("����ڰ� �̰���ϴ�.");
	}else if (gBB1 ==2 && gBB2 ==0) {
		System.out.println("����ڰ� �̰���ϴ�.");
	}else if (gBB1 ==2 && gBB2 ==1) {
		System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
	}}}
