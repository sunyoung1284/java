import java.util.Scanner;

public class Test21 {
	public static void main(String[] args) {
		String a="hello";
		String b="hello";
		Scanner scan = new Scanner(System.in);
		String c = scan.nextLine();
		
		System.out.println(a==b);
		System.out.println(a.equals(b));
		
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
	}

}

