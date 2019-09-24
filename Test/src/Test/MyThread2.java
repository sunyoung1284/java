package Test;
import java.util.Arrays;
import java.util.Random;

public class MyThread2  implements Runnable{
	static public int max = 0;
	
	@Override

	public void run() {
		Random random = new Random();
		int N = 4;
//		int N = random.nextInt(16);
		
		int[] input = new int[4];
		if (N < 0 || N < 17) {
			for (int i = 0; i < N; i++) {
				input[i] = i + 1;
				if (max < input[i]) {
					final int max = input[i];			
				}	
			}
			System.out.println(Arrays.toString(input));
			System.out.println("최댓값" + max);


}

}}
