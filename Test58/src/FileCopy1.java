import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy1 {
	public static void main(String[] args) {
		//읽어들일 수 있는 스트림과 출력 가능 한 스트림 준비
		InputStream in =null;
		OutputStream out =null;
		
		
		try {
			in=new FileInputStream("C:\\Users\\SMART-14\\Desktop\\임선영\\image.jpg");
			out=new FileOutputStream("C:\\Users\\SMART-14\\Desktop\\임선영\\copy.jpg");
			while(true) {
				int data= in.read();
				if(data==-1) {
					break;
				}
				out.write(data);
			}//end while
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(in != null) {
				try {in.close();}catch(Exception e) {}
			}
			if(out !=null) {
				try { out.close();}catch(Exception e) {}
			}
		}//end finally
	}//end main

}
