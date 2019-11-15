import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class Practice01 {
	public static void main(String[] args) {
		//****************** 진수 변환 ******************//
		
		//x 진수를 10진수로 변환~
		System.out.println(Integer.parseInt("FF",16));
		System.out.println(Integer.parseInt("1100110",2));
		
		
		//10진수 -> 2진수
		System.out.println(Integer.toBinaryString(12345));
		System.out.println(Integer.toString(12345,2));
		
		//10진수 -> 16진수
		System.out.println(Integer.toHexString(255));
		System.out.println(Integer.toString(255,16));
		
		//10진수 -> 8진수
		System.out.println(Integer.toOctalString(5678));
		System.out.println(Integer.toString(5678,8));
		
		
		//****************** 자료 구조 ******************//
		//1.StringBuilder
		//문자열 역순
		StringBuilder builder = new StringBuilder();
		builder.append("abcdefghi");
		
		builder.reverse();
		System.out.println(builder);
		
		//2.Arrays
		//배열 정렬
		int[] array = new int[] {10,20,1,7,1};
		
		Arrays.parallelSort(array);
		
		for(int each : array) {
			System.out.println("배열이지렁" +each + "");
		
		}
		
		//Vector
		// 중복된 자료구조
		List<Integer> list =new Vector<Integer>();
		
		list.add(10);
		list.add(20);
		list.add(1);
		list.add(7);
		list.add(1);
		
		System.out.println(list);
		System.out.println(list.contains(10));//10이 있나 없나~ 있으니까 true
		System.out.println(list.contains(2));
		
		//순차적으로 정렬
		Collections.sort(list);
		System.out.println("이건 오름차순 배열"+list);
		
		//역순으로 정렬
		Comparator<Integer> reverseOrdering = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1; //내림차순 정렬 o1 - o2는 오름차순
			}
		};
		
		Collections.sort(list,reverseOrdering);
		System.out.println("나는 내림차순 정렬l"+list);
		
		//HashSet 과 TreeSet
		
		//중복되지 않고 정렬되지 않은 자료구조
		Set<Integer> set = new HashSet<Integer>();
		
		set.add(10);
		set.add(20);
		set.add(1);
		set.add(7);
		set.add(1);
		
		System.out.println(set); //중복없음 정렬 안되어있음
		
		//중복되지 않고 정렬된 자료구조
		Set<Integer> set2 = new TreeSet<Integer>();
		
		set2.add(10);
		set2.add(20);
		set2.add(1);
		set2.add(7);
		set2.add(1);
		
		System.out.println(set2); //중복없고 오름차순 정렬
		
		//중복되지 않고 역순으로 정렬된 자료구조
		Set<Integer> set3 = new TreeSet<Integer>(reverseOrdering);
		
		set3.add(10);
		set3.add(20);
		set3.add(1);
		set3.add(7);
		set3.add(1);
		
		System.out.println(set3); //중복없고 내림차순 정렬
		
		//PriorityQueue
		//MAX Heap 구조를 유지하기 위한 자료구조
		Queue<Integer> queue = new PriorityQueue<Integer>(10,reverseOrdering); //우선순위가 가장 높은 데이터가 가장 먼저 나온다
		
		queue.add(10);
		queue.add(20);
		queue.add(1);
		queue.add(7);
		queue.add(100);
		
		System.out.println(queue);
		queue.poll(); //가장 먼저 보관한 값 꺼내고 반환
		System.out.println(queue);
		queue.poll();
		System.out.println(queue);
		queue.poll();
		System.out.println(queue);
		queue.poll();
		System.out.println(queue);
		
		//****************** 기하학 ******************//
		//1.선이 교차하는지 확인
		
		//두 선이 교차하는지 여부 확인 : 인스턴스 메소드 사용
		Line2D line1 = new Line2D.Double(0,0,10,10);
		Line2D line2 = new Line2D.Double(9,9,0,0);
		System.out.println(line1.intersectsLine(line2)); 
		
		//두 선이 교차하는지 여부확인 : static 메소드 사용
		System.out.println(Line2D.linesIntersect(0, 0, 0, 10, 9, 99, 0, 0));
		
		//2.사각형 내 겹치는 부분
		
		//두 사각형이 한 사각형 안에 포함되는지 여부와 교차하는지 여부
		Rectangle2D r1 = new Rectangle2D.Double(0,0,20,20);
		Rectangle2D r2 = new Rectangle2D.Double(1,1,5,5);
		
		System.out.println("r1에 r2사각형이 포함되니?"+r1.contains(r2));
		System.out.println("r2에 r1사각형이 포함되니?"+r2.contains(r1));
		System.out.println("r1에 r2사각형이 교차하니?"+r1.intersects(r2));
		System.out.println("r2에 r1사각형이 교차하니?"+r2.intersects(r1));
		
		//두 사각형이 겹치는 부분 구하기
		Rectangle2D dest = new Rectangle2D.Double();
		Rectangle2D.intersect(r1, r2, dest);
		
		System.out.println(dest);
		
		//사각형 내에 점이 존재하는지 여부
		Point2D p1 = new Point2D.Double(2,2);
		Point2D p2 = new Point2D.Double(20,20);
		
		System.out.println("r1안에 p1점이 있니"+r1.contains(p1));
		System.out.println("r1안에 p2점이 있니"+r1.contains(p2)); //겹치는 것은 안되나방
		
		//다각형 내에 겹치는 부분
		//다각형 내에 점이 포함되는지 여부
		int[] xPoints = {10,50,100,150,200,250,300,350};
		int[] yPoints = {10,50,10,50,10,50,10,50};
		GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD,xPoints.length);
		
		polygon.moveTo(xPoints[0], yPoints[0]);
		for(int i =1; i<xPoints.length; i++) {
			polygon.lineTo(xPoints[i], yPoints[i]);
		}
		
		polygon.closePath();
		
		Point2D p3 = new Point2D.Double(20,20);
		Point2D p4 = new Point2D.Double(1,1);
		
		
		System.out.println("다각형안에 p3가 포함되었냐" + polygon.contains(p3));
		System.out.println("다각형안에 p4가 포함되었냐" + polygon.contains(p4));
	}

}
