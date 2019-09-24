package Test;

import static Test.MyThread2.max;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreadTest2 {
	public static void main(String[] args) {
//		MyThread2 start = new MyThread2();
//		start.run();
		Runnable r = new MyThread2();
		Thread t = new Thread(r);
		t.start();
		System.out.println("max  "+max);
		ArrayList output = new ArrayList();
		for (int j = max; j > 0; j--) {
			output.add(j);
			
		}
		System.out.println(output);

	}
}
