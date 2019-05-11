import java.util.HashMap;
import java.util.Map;

public class RunClass {
	public static void main(String[] args) {
	
		String[] names= {"철수","영희","짱구","유리","길동","꺽정","둘리","뽀로로","보고","유신"};
		HashMap<String, Student>map =new HashMap<String, Student>();
		for (int i=0; i<names.length; i++) {
			map.put(names[i], new Student(names[i]));
		}
		for(Map.Entry<String, Student> item:map.entrySet()) {//하나씩 접근해서  item에 들어옴. foreach문 하나씩 찝어서
			Student one =item.getValue();
			if(one.midTotalScore < one.finTotalScore) {
				System.out.println(one);
			}
			
		}
		

		
		
		
		
}}
