import java.util.Random;

//성적 데이터 10명 생성 (랜덤하게 중간,기말 점수)
//기말고사 점수 향상된 사람 출력.
//1.Map 사용
//2.지난 시간에 만든 코드 재활용
public class Student {
	String name;
	int midTotalScore;
	int finTotalScore;

	Student(String name){
		this.name=name;
		Random random=new Random();
		this.midTotalScore=random.nextInt(1001);
		this.finTotalScore=random.nextInt(1001);
	}
	@Override
	public String toString() {
		return this.name+"(중간:"+this.midTotalScore+",기말:"+this.finTotalScore+")";
	}
	

}
