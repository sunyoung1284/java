import java.util.Random;

public class Test11 {
	public static void main(String[] args) {
		Random a = new Random();
		int r1 = a.nextInt(6)+1;
		
		if (r1 == 1) {
			System.out.println("港港");
			
		}else if (r1 == 2) {
			System.out.println("具克");
		}else if (r1 == 3) {
			System.out.println(3);
		}else if (r1 == 4) {
			System.out.println(4);
		}else if (r1 == 5) {
			System.out.println(5);
		}else if (r1 == 6) {
			System.out.println(6);
		}
	     switch (r1) {
	     case 1 :
	    	 System.out.println("港港");
	    	 break;
	     case 2 :
	    	 System.out.println("具克");
	    	 break;
	     case 3 :
	    	 System.out.println("3");
	    	 break;
	     case 4 :
	    	 System.out.println("4");
	    	 break;
	     case 5 :
	    	 System.out.println("5");
	    	 break;
	     default:
	    	 System.out.println("6"); 	 
	     }
}

}
