import java.util.ArrayList;

public class List {
	public static void main(String[] args) {
		ArrayList<String>list =new ArrayList<String>();
		list.add("AAAA");
		list.add("BBBB");
		list.add("CCCC");
		list.add("DDDD");
		list.set(1, "EEEE");//수정 수정할위치 써서
		System.out.println(list);
		String tmp = list.get(1);
		
		ArrayList<Integer> list1 =new ArrayList<Integer>();//정수 리스트 쓸때는 객체데이터 Integer
		list1.add(0);
		list1.add(1);
		list1.add(3);
		System.out.println(list1);
		
		for(int i=0; i<list1.size(); i++) {//여기서 size는 length와 같은 의미
			System.out.println(list1.get(i));
		}
		//리스트를 순차적으로 접근하는 방법
		//1.get(index)형태로 쓰는 거 (size 이용 하면 for문으로 가능) 
		//2.배열로 바꿔서 사용하는 방법
		//지난시간에 본 것
		//배열로 변경하는 것
		//iterator하는 것
		
	}

}
