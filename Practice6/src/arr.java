import java.util.Arrays;
import java.util.Scanner;

public class arr {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int [][]arr = new int [4][4];
		for(int i=0; i<arr.length; i++) {
		
			for(int j=0; j<arr.length; j++) {
				System.out.println("숫자를 입력하세요");
				if(i<3&&j<3) {
					arr[i][j]=scanner.nextInt();
				}else if(i==3) {
					for(int k=0; k<3; k++) {
						arr[3][j]+=arr[k][j];
					}
				}else if(j==3) {
					for(int k=0; k<3; k++) {
						arr[i][3]+=arr[i][k];
						
					}
					
				}
		}}
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				System.out.print(arr[i][j] + "\t");
//			}
//			System.out.println();
//		}
//		
		for(int i=0; i<arr.length; i++) {
		System.out.println(Arrays.toString(arr[i])); // 3*3배열로 보이게
		}
		System.out.println(Arrays.deepToString(arr));//걍 배열 출력 이중배열이라 deepTostring
		}}
