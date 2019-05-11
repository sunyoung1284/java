import java.util.HashMap;
import java.util.Map;

public class Test51 {
	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("name", "hello");
		map.put("name","aaaa");
		map.put("score", "100");//키 형태여서 순서가 없음.
		System.out.println(map);
		
		for(Map.Entry<String,String> item : map.entrySet()) {
			System.out.println(item.getKey());
			System.out.println(item.getValue());
			
		}
	}

}
