import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Run32 {
	public static void main(String[] args) {
		Test32 post= new Test32();
		post.insertpost();
	
		System.out.println(""+post.title+","+post.description + "," + post.createDate);

		



	}

}
