import java.util.Random;

public class Random2 extends Random {
	
	public int[] nextInt2(int range) {
		int[]arr=new int[10]; 
		for(int i=0; i<arr.length; i++) {
			  arr[i] =super.nextInt(range);
		}
			return arr;
		}
		
		
	}


