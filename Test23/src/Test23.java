
public class Test23 {
	public static void makeSum(int startValue, int endValue) {
		int start =startValue;
		int end=endValue;
		int sum =0;
		
		for(int i = start; i <= end+1 ; i++) {
			sum =sum +i;
		}//end for
		
		System.out.println("시작값:" + start);
		System.out.println("종료값:" + end);
		System.out.println("총합:" + sum);
	}		
	
	public static void main(String[] args) {
		Test23 m =new Test23();
		m.makeSum(1,100);
		m.makeSum(20,200);
		m.makeSum(30,300);
	}

}
