import java.util.Random;
 
public class RunClass {
	public static void main(String[] args) {
		
		Student[] student = new Student[100];
		for (int i = 0; i < student.length; i++) {
			student[i] = new Student();
		}
		Random2 rand = new Random2();
		for (int i = 0; i < student.length; i++) {
			student[i].name = (i + 1) + "번 학생";
			rand.randomStudent(student[i]);
		}
		for (int i = 0; i < student.length; i++) {
			student[i].totalMidScore = student[i].midKorScore + student[i].midEngScore + student[i].midMathScore;
		}for (int i = 0; i < student.length; i++) {
			student[i].totalfinScore = student[i].finKorScore + student[i].finEngScore + student[i].finMathScore;
		}
		
		for (int i = 0; i < student.length; i++) {
			
			if(student[i].totalMidScore<student[i].totalfinScore) {
			System.out.println(student[i].print());
			}}
  
}}
