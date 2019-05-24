import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PrintResult {
	
	public void printResult(Map map) {
        Iterator it = sortByValue(map).iterator();//정렬돼서 들어감
        
        for (int i = 0; i < 30; i++) {				//��� ���
			System.out.println(); //
		}       
        System.out.println("Game Result");
        
        for (int i = 0; i < 3; i++) {
        	String temp = (String) it.next();
			System.out.println((i+1) + "�� : " + temp); //등수
		}
	}

	
	public static List sortByValue(Map map) {
        List<String> list = new ArrayList();
        list.addAll(map.keySet());       
        Collections.sort(list,new Comparator() {            
            public int compare(Object o1,Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);                
                return ((Comparable) v2).compareTo(v1);
            }            
        });
        return list;
    }
}


