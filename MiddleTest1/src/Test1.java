//1~1000까지 5의 배수의 합
public class Test1 {
	public static void main(String[] args) {
		int sum=0;
		for (int i=0; i<=1000; i++) {
			if(i%5==0) {
				sum+=i;
			}
		}
		System.out.println(sum);
	}

}
