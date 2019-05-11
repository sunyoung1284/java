import java.util.Scanner;

//문자로받고 숫자로 전환
//트라이 캐치
//나누기 하고 소숫점 올림해서 정수로 리턴해봐
public class division {
	int number1=0;
	int number2=0;
	
	public void inputNumber() {
		Scanner scanner=new Scanner(System.in);
		String tmp;
		System.out.println("숫자 입력해");
		tmp=scanner.nextLine();
		try {
			this.number1=Integer.parseInt(tmp);
		} catch (Exception e) {
			this.number1=0;
		}
		
		System.out.println("숫자 또 입력해");
		tmp=scanner.nextLine();
		try {
			this.number2=Integer.parseInt(tmp);
		} catch (Exception e) {
			this.number2=0;
			// TODO: handle exception
		}
		
		
		System.out.println("첫번째 숫자는"+this.number1+"두번째 숫자는 "+this.number2);
		
	}
	public void division() {
		double divisionResult =((double)number1/number2);
		 divisionResult =(double)Math.round(divisionResult*100)/100;//Math.round는 실수의 소수점 첫번째 자리를 반올림하여 정수로 리턴
		System.out.println("나누기 결과는:"+divisionResult);
	}
	

}
