import java.util.ArrayList;

public class RunClass {
	public static void main(String[] args) {
		String[] names= {"철수","영희","짱구","유리","길동","꺽정","둘리","뽀로로","보고","유신"};
		ArrayList<Student> student =new ArrayList<Student>();
		
		for (int i = 0; i < names.length; i++) {
			student.add(new Student(names[i]));	
		}
		Student [] arr=new Student[student.size()];//student.size()=10
		student.toArray(arr);
		System.out.println(arr[0]);
		
	}

}
