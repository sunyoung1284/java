import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Three {
	public static void main(String[] args) {
		
	
	
		String test="33336666900";
		Matcher match =Pattern.compile("(3|6|9)").matcher(test);
		int matchCount=0;
		for(int i=0; i<9999999; i++) {
			if(match.find()) {
				System.out.println(match.group());
				matchCount++;
			}else {
				break;
			}
		}
		System.out.println("총 매치 개수"+matchCount);
	
		

}}
