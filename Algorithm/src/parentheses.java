import java.util.Arrays;

public class parentheses {

	public void findMate(int num, String[] parentheses) {
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int result = 0;
		// ( 와 )의 갯수가 다르면 처음부터 return 0
		for (int i = 0; i < parentheses.length; i++) {
			if (parentheses[i] == "(") {
				count1++;
			}
			if (parentheses[i] == ")") {
				count2++;
			}
		}
		if (count1 != count2) {
			System.out.println("짝이없다");

		} else {

			//
			if (parentheses[num] == "(") {
				if (parentheses[num + 1] == ")") {
					System.out.println("짝은" + (num + 1));

				}
				for (int i = 0; i < parentheses.length; i++) {
					if (parentheses[i] == "(" && parentheses[i + 1] == ")") {
						parentheses[i] = i + 1 + "";
						parentheses[i + 1] = i + "";
					}
				}
				System.out.println(Arrays.toString(parentheses));


//					for (int j = 0; j<parentheses.length; j++) {
//						if (parentheses[i] == "(" && parentheses[i+j] == ")") {
//							
//							parentheses[i] = i+j+"";
//							parentheses[i+j] = i + "";
//							break;
//						}
//					}
//				result = Integer.parseInt(parentheses[num]);
//				System.out.println("결과는" + result);

			}

		}
	}

}
