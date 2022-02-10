public class QuickSort {
	
	// 퀵 정렬: 피벗(기준값)을 기준으로 피벗보다 작은 값들은 왼쪽 부분집합으로, 큰 값들은 오른쪽으로 부분집합으로 분할해가며 정렬하는 방식
	public static void quickSort(int[] arr, int start, int end) {
		// 부분집합의 크기가 1이하이면 퀵 정렬 수행 x
		if(start < end) {
			// 피벗을 기준으로 두 부분집합으로 분할
			// - 왼쪽 부분집합: 피벗보다 작은 값들, 오른쪽 부분집합: 피벗보다 큰 값들
			int pivot = partition(arr, start, end); // 분할된 두 집합의 기준점(피벗)의 위치 반환

			// 순환호출을 이용하여 피벗을 제외한 두 부분집합에 대해 퀵 정렬 수행
			quickSort(arr, start, pivot - 1); // 왼쪽 부분집합 퀵 정렬
			quickSort(arr, pivot + 1, end); // 오른쪽 부분집합 퀵 정렬
		}
	}

	// 피벗을 기준으로 두 부분집합으로 분할한 뒤 피벗의 위치 반환
	public static int partition(int[] arr, int start, int end) {
		int pivot = start; // 피벗의 위치를 첫 번째 원소의 위치로 지정
		int left = start + 1; // 피벗을 제외한 가장 왼쪽의 지점을 left로 지정
		int right = end; // 피벗을 제외한 가장 오른쪽의 지점을 right로 지정
		
		// left와 right가 교차될 때까지 반복
		while(left <= right) {			
			// 왼쪽에서부터 피벗보다 큰 데이터를 찾을 때까지 반복
			while(left <= end && arr[left] <= arr[pivot]) left++;
			// 오른쪽에서부터 피벗보다 작은 데이터를 찾을 때까지 반복
			while(right >= start+1 && arr[right] >= arr[pivot]) right--;

			// left와 right가 교차되지 않았다면 left의 데이터와 right의 데이터를 교환하고,
			// 교차되었다면 현재 둘 중 더 작은 값인 right의 데이터와 피벗을 교환
			if(left < right) swap(arr, left, right);
			else swap(arr, right, pivot);
		}
		
		// 이동된 피벗의 위치인 right를 반환
		return right;
	}
		
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = {3, 5, 1, 2, 0, 8, 6};

		quickSort(arr, 0, arr.length-1);

		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
}