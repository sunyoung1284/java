import java.util.Random;

public class Student {

	String name;
	int middleScore;
	int finalScore;
	int scoreGap;

	Student(String name,int maxScore) {
		this.name = name;
		Random rand = new Random();

		this.middleScore = rand.nextInt(maxScore+1);
		this.finalScore = rand.nextInt(maxScore+1);
		this.scoreGap=this.finalScore-this.middleScore;

	}
	
	
	
	public String toString() {
		return this.name + "(중간: " + this.middleScore + ", 기말: " + this.finalScore + ")";
		
		
		
	}

}
