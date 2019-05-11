import java.io.IOException;

public class RunClass {
	public static void main(String[] args)  {
		Test48 m =new Test48();
		try {
			m.multiplicationtable();
		} catch (IOException e) { 
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("default");
		}
		
	
		java.io.File file=new java.io.File("c:\\file.txt");
		try {//throw로 넘기지 말고 try catch 쓰렴
			file.getCanonicalFile();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
