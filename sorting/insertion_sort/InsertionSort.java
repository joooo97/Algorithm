public class InsertionSort {
	
	// 삽입 정렬: 정렬되지 않은 데이터를 순서대로 하나씩 골라 정렬된 부분집합의 적절한 위치에 삽입하여 정렬
	void insertionSort(int[] arr, int n) {
		// 첫 번째 원소는 정렬되어 있다고 가정, 두 번째 원소부터 key로 지정하여 부분집합에 삽입할 위치 찾기
		// 정렬된 부분집합의 원소들(arr[j])과 key를 비교하여 key가 들어갈 위치 판단
		for(int i = 1; i < n; i++) {
			int key = arr[i]; // 정렬된 부분집합에 삽입할 데이터
			int j = i - 1; // key와 비교할 원소(정렬된 부분집합의 원소)의 인덱스

			// key가 정렬된 부분집합의 원소보다 작다면 반복
			while(j >= 0 && arr[j] > key) {
				// key가 비교 원소 arr[j]보다 작다면 key는 비교 원소의 앞쪽에 위치해야 하므로 비교 원소를 한 칸 뒤로 밀기
				arr[j + 1] = arr[j];
				j = j - 1; // 다음 비교 원소 지정
			}
			// key가 비교 원소보다 크거나 같다면 key를 비교 원소의 뒤에 삽입
			arr[j + 1] = key;
		}
	}
}