
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Algorithm {
	static int N;
	static int N2;
	static int AnswerN;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/sample.txt"));

		Scanner sc = new Scanner(System.in);

		int T; // 4
		T = sc.nextInt();
		System.out.println("t" + T);

		for (int test_case = 1; test_case <= T; test_case++) {
			String index = "";
			/*
			 * 각 테스트 케이스를 표준 입력에서 읽어옵니다.
			 */

			N = sc.nextInt();
			sc.nextLine();
			System.out.println("N:" + N);

			String num = sc.nextLine();
			System.out.println("Num" + num);

			String[] number;
			number = num.split(" ");
			String num2 = sc.nextLine();
			String[] number2;
			number2 = num2.split(" ");

		
			
			Arrays.sort(number);
			Arrays.sort(number2);
			

//			List<String> list = new ArrayList<String>();
//			Collections.addAll(list, number);	
//		
			
			if (Arrays.equals(number,number2)) {
				AnswerN = 1;
			} else {
				AnswerN = 0;
			}

//			for (int i = 0; i < N; i++) {
//				if (number[i] == number2[i]) {
//					index = number2[i];
//					System.out.println("인덱스" + index);
//					list.remove(index);			
//				}
//			}
//
//			if (number.length == number2.length) {
//				if (list.size() == 0) {
//					System.out.println("true");
//				} else {
//					System.out.println("false");
//
//				}
//
//			} else {
//				System.out.println("false");
//			}
			System.out.println("#" + test_case + " " + AnswerN);
		}
	}

}
