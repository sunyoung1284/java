import java.util.Arrays;

public class Permutation {
	public static void main(String[] args) {

		Permutation permutation = new Permutation();

		int[] arr = new int[] { 1, 2, 3 };
		int[] permArr = new int[3];
		boolean[] visited = new boolean[3];
		for (int i = 0; i < 3; i++) {
			visited[i] = false;
		}
		generatePermutations(arr, 3, permArr, -1, visited);

	}

	public static void generatePermutations(int[] arr, int size, int[] permArr, int level, boolean[] visited) {
		if (level >= size - 1) {
			System.out.println(Arrays.toString(permArr));
			return;
		}

		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				permArr[++level] = arr[i];
				System.out.print("level:" + level);
				System.out.println(" i: " + i);
				visited[i] = true;
				generatePermutations(arr, size, permArr, level, visited);
				visited[i] = false;
				level--;
			}
		}
	}

}
