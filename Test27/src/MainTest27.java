
public class MainTest27 {
	public static void main(String[] args) {
		Test27 c1=new Test27();
		System.out.println("6의 배수는");
		for (int i=0; i<100; i++) {
			int checkNumber = i +1;
			boolean result = c1.docheck(checkNumber);
			if(result) {
				System.out.print("   "+(checkNumber));
			}
		}
		
	}

}
