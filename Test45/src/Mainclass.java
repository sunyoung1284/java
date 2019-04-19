import java.util.Arrays;
import java.util.Random;
public class Mainclass {
	public static void main(String[] args) {
		Student[] student = new Student[10];
		for (int i = 0; i < student.length; i++) {
			student[i] = new Student();
		}
		Random2 rand = new Random2();
		for (int i = 0; i < student.length; i++) {
			student[i].name = (i + 1) + "번 학생";
			rand.randomStudent(student[i]);
		}
		for (int i = 0; i < student.length; i++) {
			student[i].total = student[i].kor + student[i].eng + student[i].math;
		}
//		for (int i = 0; i < student.length; i++) {
//			for (int j = i; j < student.length; j++) {
//				if (student[i].total < student[j].total) {
//					Student tmp = student[i];
//					student[i] = student[j];
//					student[j] = tmp;
//				}
//			}
//		}
		Arrays.sort(student);
		//student[0].compareTo(student[3]);
		for (int i = 0; i < student.length; i++) {
			System.out.println(student[i].print());
		}
	}
}

