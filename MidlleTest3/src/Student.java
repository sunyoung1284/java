import java.util.Random;

//3. 총 100명의 성적 데이터를 생성한 후 성적이 올라간 학생들을 출력하시오.
//
//(제약 사항)
//
//1) student 클래스의 객체 데이터를 생성하고 랜덤한 값을 생성해서 성적 데이터를 입력
//
//2) 성적 데이터는 중간고사 성적 (국어, 영어, 수학), 기말고사 성적
//(국어, 영어, 수학) 을 입력. 즉 3과목의 성적 데이터를 중간고사와 기말고사로 구분해서 입력함.

public class Student {
	String name;
	int midKorScore;
	int midEngScore;
	int midMathScore;
	int totalMidScore;
	int finKorScore;
	int finEngScore; 
	int finMathScore; 
	int totalfinScore;
	
	
	public String print() {
		return this.name+"의 중간고사 점수" +"(국어 " + this.midKorScore + ", 영어 " + this.midEngScore + ", 수학 " + this.midMathScore + ")"+"기말고사 점수"+"(국어 " + this.finKorScore + ", 영어 " + this.finEngScore + ", 수학 " + this.finMathScore + ")"+"중간고사의 총점:"+this.totalMidScore+"기말고사의 총점:"+this.totalfinScore; 
	

}}
