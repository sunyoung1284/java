
public class Student implements Comparable<Student> {
	String name;
	int kor;
	int eng;
	int math;
	int total;

	public String print() {
		return this.name + " 총점 : " + this.total + "(국어 " + this.kor + ", 영어 " + this.eng + ", 수학 " + this.math + ")";
	}
	@Override
	public String toString() {
		String tmp = String.format("%03d", this.total);
		return tmp;
	}
	@Override
	public int compareTo(Student o) {
		if (this.total < o.total) {
			return -1;
		} else if (this.total > o.total) {
			return 1;
		}
		return 0;
	}
	
}
