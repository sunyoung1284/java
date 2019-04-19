import java.util.Random;

public class Random2 extends Random {
	public void randomStudent(Student target) { //콜바이 벨류(값, int double boolean)콜바이 레퍼런스(주소,객체), 이 경우엔 콜바이 레퍼런스(주소를 보내는 것) 
		target.kor = this.nextInt(101);
		target.eng = this.nextInt(101);
		target.math =  this.nextInt(101);
		target.total = target.kor + target.eng + target.math;
	}
}
