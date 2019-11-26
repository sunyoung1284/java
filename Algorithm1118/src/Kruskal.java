import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Kruskal {
    static int V, E;
    static ArrayList<Edge> mst;            
    static int[] arr ;                    
    static PriorityQueue<Edge> pq;        

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();            
        E = sc.nextInt();            

        mst = new ArrayList<>();
        arr = new int[V+1];
        pq = new PriorityQueue<>();
        
        
        // 초기화
        for (int i = 0; i <= V; i++) {//disjoint init
            arr[i]=i;              
        }
        
        // 간선
        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int value = sc.nextInt();

            pq.add(new Edge(v1, v2, value));
        }

        while(mst.size() < (V-1)) {                
            Edge edge = pq.poll();  //우선 순위가 높은거(기본으로 오름차순 정렬)
            if(find(edge.start)!=find(edge.end)) {
                mst.add(edge);
                union(edge.start,edge.end);
            } 
        }

        System.out.println("야호"+mst);
    }
    static int find(int n) {
    	//루트 노드는 부모 노드 번호로 자기 자신을 가진다.
        if (n == arr[n]) { 
            return n;
        } else {
        	//각 노드의 부모 노드를 찾아 올라간다.
            int p = find(arr[n]);
            arr[n]=p;                    
            return p;
        }
    }
    
    //union
    static void union(int n1, int n2) { // n1�� ���� ���հ� n2�� ���� ������ �����ϴ� �Լ�(�ڿ����� ��ǥ�� �ȴ�)
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 != p2) {
            arr[p1]= p2;
        }
    }
    static class Edge implements Comparable<Edge>{
        int start, end, value;

        Edge(int s, int e, int v) {
            this.start = s;
            this.end = e;
            this.value = v;
        }
        @Override
        public int compareTo(Edge o) { //정렬
            // TODO Auto-generated method stub
            return this.value - o.value;
        }
        @Override
        public String toString() {
            return "Edge [start=" + start + ", end=" + end + ", value=" + value + "]\n";
        }
    }
}

/*
6
9
1 2 5
1 3 4
2 3 2
2 4 7
3 4 6
4 6 8
3 5 11
4 5 3
5 6 8
*/
// source : https://velog.io/@dudrkdl777/Graph-�ּҽ���Ʈ��-MSTKruskal�˰���