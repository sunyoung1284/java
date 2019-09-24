import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;

public class Solution {
	static int N;
	static int AnswerN;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/sample_input.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);

		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			/*
			 * 각 테스트 케이스를 표준 입력에서 읽어옵니다.
			 */

			N = sc.nextInt();

			char[] E = sc.nextLine().toCharArray();

			// ///////////////////////////////////////////////////////////////////////////////////////////
			/*
			 * 이 부분에 여러분의 알고리즘 구현이 들어갑니다. 여러분의 정답은 AnswerN에 저장되는 것을 가정하였습니다.
			 */
			// ///////////////////////////////////////////////////////////////////////////////////////////

			/*
			 * my code
			 */
			System.out.println("E len ="+E.length);
			Stack<String> s = new Stack<String>();
			int size = Integer.MAX_VALUE;
			
			try {
				for (int i = 1; i < E.length; i++) {
					if (E[i] == '(') {
						if (i == N)
							size = s.size();

						s.push(String.valueOf(E[i]));

					} else {
						s.pop();

						if (s.size() == size) {
							AnswerN = i;
							size = Integer.MAX_VALUE;
						}

					}
				}
				
			} catch (EmptyStackException e) {
				AnswerN = 0;
				
			} finally {
				if (s.size() > 0)
					AnswerN = 0;
				
			}

			// int[] C = new int[E.length];
			//
			// for (int i = 1; i < E.length; ++i) {
			// if (E[i] == '(') {
			// C[i] = C[i - 1] - 1;
			// }
			// if (E[i] == ')') {
			// C[i] = C[i - 1] + 1;
			// }
			// }
			//
			// for (int k = N + 1; k < E.length; ++k) {
			// if (C[k] == C[N] + 1) {
			// AnswerN = k;
			// break;
			// }
			// }
			//
			// if (C[N] > 0) {
			// AnswerN = 0;
			// }

			// 표준출력(화면)으로 답안을 출력합니다.
			System.out.println("#" + test_case + " " + AnswerN);
		}
	}

}
