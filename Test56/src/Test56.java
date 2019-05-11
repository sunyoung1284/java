import java.util.HashSet;

public class Test56 {
	public static void main(String[] args) {
		
	
	HashSet<String>set =new HashSet<String>();
	
	set.add("A");
	set.add("B");
	set.add("C");
	set.add("D");
	set.add("E");
	set.add(new String("A"));
	System.out.println(set);
	

}}
