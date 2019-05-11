import java.util.Random;

//학생 중간고사성적총점 기말고사 성적 총점
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
