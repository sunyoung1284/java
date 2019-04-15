
public class Test42 {
	public static void main(String[] args) {
		Object a =new O2();
		Object b =new O2();
		
		System.out.println(".equals결과:"+ a.equals(b));
		System.out.println("a.toString결과:"+ a.toString());
		System.out.println("a결과:"+ a);//toString 생략된 거랑 동일
		System.out.println("b.toString결과:"+ b.toString());
		System.out.println("b결과:"+ b);
		
	}

}
