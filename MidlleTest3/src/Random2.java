import java.util.Random;
public class Random2 extends Random {
	public void randomStudent(Student target) {  
		target.midKorScore = this.nextInt(101);
		target.midEngScore = this.nextInt(101);
		target.midMathScore =  this.nextInt(101);
		target.finKorScore = this.nextInt(101);
		target.finEngScore = this.nextInt(101);
		target.finMathScore =  this.nextInt(101);
		
	}
}


