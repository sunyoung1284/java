import java.util.Scanner;

//구구단 프로그램 작성
//클래스 방식(클래스 작성 후 구성)으로 구현
//사용자가 원하는 단 입력하면 해당 단의 구구단 출력
//(사용자가 입력하는 값은 문자열로 받고 숫자로 변환)
public class Test48  {
	 private int number; //private 외부에서 접근 못하고 내부에서만 쓸때
	public void multiplicationtable() throws Exception {// 오류 메인쪽으로 처리하게(코드가 호출된 곳으로)
		Scanner scanner =new Scanner(System.in);
		System.out.println("단을 입력하세요");
		String inputText=scanner.nextLine();
		try {
			
			this.number = Integer.parseInt(inputText);
		} catch (Exception e) {
			e.printStackTrace();//오류를 출력
		}
		if(this.number==0) {
			throw new Exception("not allow 0");
		}
		this.printResult();
		
	
	
	
		}
	private void printResult() {
		for(int i=1; i<=9; i++) {
			System.out.println(this.number+"*"+i+"="+(this.number*i));
		
	
		
			}
	}
		
	}


