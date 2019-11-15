
public class BinaryIndexTree {

	/// 정의

	void initialize(int N, int[] bit) {
		int size = 2 * N - 1;
		for (int i = 1; i <= size; i++) {
			bit[i] = 0;
		}
	}

	public void debug(int N, int[] bit) {
		for (int i = 1; i <= N; i++) {
			System.out.println("디버그 " + bit[i]);
		}

		System.out.println("\n");
	}

	// 데이터 갱신
	// bITree.update(i, data[i],N,bit);
	public void update(int index, int value, int N, int[] bit) {
		while (index <= N) {
			bit[index] = bit[index] + value;
			index = index + (index & (-index));
		}
	}

	// "C a x" a번째 숫자를 x로 바꿔라
	public void newUpdate(int a, int[] data, int MAX_TREE_SIZE, int[] bit, int x) {
		int origin = bit[a];
		int difference = x - data[a];
		System.out.println("원래와의 차이값" + difference);

		if (origin < x) {
			while (a <= MAX_TREE_SIZE) {
				bit[a] = bit[a] + difference;
				a = a + (a & (-a));
			}
		} else if (origin > x) {
			while (a <= MAX_TREE_SIZE) {
				bit[a] = bit[a] - difference;
				a = a + (a & (-a));
			}
		} else {
			while (a <= MAX_TREE_SIZE) {
				bit[a] = bit[a];
				a = a + (a & (-a));
			}
		}
	}

	// 데이터 1~N까지 구간 합
	public int sum(int index, int[] bit) {
		int sum = 0;

		while (index > 0) {
			sum = sum + bit[index];
			index = index - (index & (-index));
		}
		return sum;
	}

	// 데이터 startIndex~finishIndex까지 구간 합
	public int sum2(int startIndex, int finishIndex, int[] bit) {
		int sum = 0;
		int minus = 0;
		startIndex = startIndex - 1;
		while (finishIndex > 0) {
			sum = sum + bit[finishIndex];
			finishIndex = finishIndex - (finishIndex & (-finishIndex));
		}
		while (startIndex > 0) {
			minus = minus + bit[startIndex];
			startIndex = startIndex - (startIndex & (-startIndex));
			System.out.println("2까지" + minus);
		}
		return sum - minus;
	}

	public static void main(String[] args) {
		int MAX_TREE_SIZE = 100000;
		int INFINITE = 9999999;
		int data[] = { 0, 2, 4, 1, 7, 3, 6, 2, 5, };
		int N = 8;
		int[] bit = new int[MAX_TREE_SIZE];

		BinaryIndexTree bITree = new BinaryIndexTree();
		bITree.initialize(N, bit);

		for (int i = 1; i <= N; i++) {
			bITree.update(i, data[i], N, bit);
		}

		bITree.debug(N, bit);

		System.out.println("1~6까지 더한값은?:" + bITree.sum(6, bit));
		;
		System.out.println("4~6까지 더한값은?:" + bITree.sum2(4, 6, bit));
		bITree.newUpdate(2, data, MAX_TREE_SIZE, bit, 9);// C 2 9
		bITree.debug(N, bit);
	}

}
