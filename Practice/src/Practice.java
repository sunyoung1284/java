import java.util.Scanner;

//사용자의 체중, 신장을 입력받아 카우프 지수를 구하시오.
//조건1. 사용자의 데이터를 입력받는 메소드와, 카우프 지수를 구하는 메소드를 사용할 것
public class Practice {
	double height=0;
	double weight=0;
	double kaup=0;
	public void inputvalue() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("키를 입력하세요");
		height= scanner.nextInt();
		System.out.println("몸무게를 입력하세요");
		weight= scanner.nextInt();
		System.out.println(height);
		System.out.println(weight);
		
		
		
		
	}
	public void kaupResult() {
		
		this.kaup=(double)this.weight/((this.height*this.height)/10000);
		System.out.println(kaup);
		if(kaup>=30) {
			System.out.println("비만");
		}else if(kaup>24 && kaup<=29) {
			System.out.println("과체중");
		}else if(kaup>20 && kaup<=24) {
			System.out.println("정상");
		}else if(kaup>15 && kaup<=20) {
			System.out.println("저체중");
		}else if(kaup>13 && kaup<=15) {
			System.out.println("여윔");
		}else if(kaup>10 && kaup<=13) {
			System.out.println("영양실조증");
		}else {
			System.out.println("이하는 소모증");
		}
			
		
		
		
	}

}
