import java.util.Scanner;

public class Test30 {
	public double weight;
	public double height;
	
	public void process() {
		this.physicalInfor();
		this.kaufIndex();
	}
	public void physicalInfor() {
		Scanner scanner =new Scanner(System.in);
		System.out.println ("체중 입력(단뒤kg):");
		this.weight =scanner.nextDouble();
		System.out.println ("신장 입력(단뒤cm):");
		this.height=scanner.nextInt();
		
	}public double kauf =0;
	public void kaufIndex() {
		double kauf=(double)this.weight/((this.height*this.height)/10000);
		//System.out.println("계산결과:"+ kauf);
		if (kauf>=30) {
			System.out.println ("비만");	
		}else if(kauf>=24) {
			System.out.println ("과체중");
		}else if(kauf>=20) {
			System.out.println ("정상");
		}else if(kauf<15) {
			System.out.println ("저체중");
		}else if(kauf>=13) {
			System.out.println ("여윔");
		}else if(kauf>=10) {
			System.out.println ("영양실조증");
		}else {	
			System.out.println ("이하는 소모증");
			}
	}

}
