public class SelectionSort {
	
	// 선택 정렬: 정렬되지 않은 데이터 중 가장 작은 값을 선택하여 맨 앞 값과 교환
	void selectionSort(int[] arr, int n) {
		// 정렬되지 않은 부분배열의 경계를 하나씩 이동
		// 마지막으로 남은 원소는 정렬을 진행하지 않아도 되므로 n - 1번의 과정 수행
		for(int i = 0; i < n - 1; i++) {
			// 정렬되지 않은 배열(i ~ n-1번째 요소들)에서 최소 요소 찾기
			int min_idx = i; // 우선 정렬되지 않은 부분의 첫 번째 원소를 최소값으로 지정
			// 정렬되지 않은 부분의 첫 번째 원소(i) 다음의 원소(i+1)부터 현재 최소값과 비교 
			for(int j = i + 1; j < n; j++) {
				if(arr[min_idx] > arr[j]) min_idx = j;
			}
			// 정렬되지 않은 부분의 맨 앞 원소(arr[i])와 최소 원소를 교환
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}
}