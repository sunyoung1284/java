//4. 짱구, 철수, 유리는 369 게임을 하고 있다. 369 게임 규칙에 맞춰서 결과를 출력하시오.
//
//(제약 사항)
//
//1) 1부터 50까지 짱구, 철수, 유리가 돌아가면서 숫자를 출력하세요. 게임에서 틀리는 사람은 없다고 가정합니다. 즉 모든 사람은 50까지 정답만 말합니다(출력합니다).
//
//2) 369 게임은 숫자에 3,6,9가 들어간 경우 숫자 대신 '짝'이라는 박수소리를 출력하세요. (ex. 13인 경우 13을 출력하는 대신 '짝'을 출력. 33인 경우 '짝짝'을 출력)
public class ThreeSixNine {
	public static void main(String[] args) {
		String number;
		for(int i=1; i<=50; i++) {
			number=i+"";
//			int a=number.length();
			if(number.charAt(0)=='3'||number.charAt(0)=='6'||number.charAt(0)=='9') {
				System.out.println("짝");
		
				continue;
			}
		
			else {
				System.out.println(i);
			}
			}

}}

//for(int j=0; j<=number.length(); j++) {
//if(number.charAt(j)=='3'||number.charAt(j)=='6'||number.charAt(j)=='9') {
//	System.out.println("짝");
//	continue;
//	}
//
//}
//System.out.println(i);
//
