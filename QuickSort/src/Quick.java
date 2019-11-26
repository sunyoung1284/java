//1. 전체원소 가운데 하나의 원소를 중심(Pivot)으로 2개의 부분 집합으로 분할 한다.
//2. 기준값(Pivot) 보다 작은 원소는 왼쪽 부분집합으로, 기준값(Pivot) 보다 큰 원소들은 오른쪽 부분 집합으로 정렬한다.
//3. 분할된 부분집합의 크기가 0이나 1이 될 때 까지 순환 호출을 이용하여 다시 분할 한다.

public class Quick {
	public static int partition(int arr[], int left, int right) {
	
		int pivot = arr[(left + right) / 2]; 
	
		while (left < right) {
			while ((arr[left] < pivot) && (left < right))
				left++;
			while ((arr[right] > pivot) && (left < right))
				right--;
	
			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
	
		return left;
	}
	
	public static void quickSort(int arr[], int left, int right) {
	
		if (left < right) {
			int pivotNewIndex = partition(arr, left, right);
	
			quickSort(arr, left, pivotNewIndex - 1);
			quickSort(arr, pivotNewIndex + 1, right);
		}
	
	}
	
	public static void main(String[] args) {
		int[] arrs = { 69, 10, 30, 2, 16, 8, 31, 22 };
		quickSort(arrs, 0, arrs.length - 1);
		System.out.println("결과");

		for (int i : arrs) {
			System.out.print(i + " ");
		}
	}

}


