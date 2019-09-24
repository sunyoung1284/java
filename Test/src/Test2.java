import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Test2 {
	public static void main(String[] args) {

		Random random = new Random();
//      int N = random.nextInt(16);
		int N = 4;
		int max = 0;
		int[] input = new int[4];
//		int [] output = new int [max];
		ArrayList output = new ArrayList();
		

		if (N < 0 || N < 17) {
			for (int i = 0; i < N; i++) {
				input[i] = i + 1;
				if (max < input[i]) {
					max = input[i];
				}
//				System.out.println(Arrays.toString(input));
//				System.out.println("최댓값" + max);
				
			}
			for(int j=max; j>0; j--) {
				output.add(j);
				
			}
			System.out.println(Arrays.toString(input));
			System.out.println("최댓값" + max);
			System.out.println(output);
			
		}
	}
}