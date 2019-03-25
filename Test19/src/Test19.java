import java.util.Arrays;

public class Test19 {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5};
		
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
			System.out.print("");
		}
		System.out.println();
		
		int[] arr2 = arr;
		int[]  arr3 = arr2;
		arr3[0]=10;
		
		//for (int i=0; i<arr.length; i++) {
		//System.out.println(arr[i]);
		//System.out.print("");}

		
	      System.out.println(Arrays.toString(arr));
	
	}

}
