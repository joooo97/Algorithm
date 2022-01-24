public class MergeSort {

	// mergeSort()
	// - 배열을 이등분하여 두 개의 부분집합으로 분할
	// - 두 부분집합에 대해 각각 mergeSort()를 호출하여 정렬
	// - merge()를 호출하여 정렬된 두 배열을 병합
	void mergeSort(int[] arr, int left, int right) {
		int mid; // 배열을 절반으로 분할할 중간지점
		
		if(left < right) { // 더 나눌 수 있다면 (원소가 2개 이상이라면)
			mid = (left + right) / 2; // 중간지점 계산
			
			// 분할된 두 부분집합을 각각 정렬
			// mergeSort()는 배열을 더 이상 둘로 분할할 수 없을 때까지 재귀적으로 호출됨 
			mergeSort(arr, left, mid); // 전반부 데이터(left ~ mid) 정렬
			mergeSort(arr, mid+1, right); // 후반부 데이터(mid+1 ~ right) 정렬
			
			// 정렬된 두 배열을 병합
			merge(arr, left, mid, right);
		}
	}

	// merge()
	// 정렬된 두 배열을 하나로 병합하는 메서드
	// - 첫 번째 배열: arr[left ... mid]
	// - 두 번째 배열: arr[mid+1 ... right]
	void merge(int arr[], int left, int mid, int right) {
		// 배열의 시작 인덱스 변수 정의
		int i = left; // 첫 번째 배열의 시작 인덱스
		int j = mid + 1; // 두 번째 배열의 시작 인덱스
		int k = left; // 병합 후 배열의 시작 인덱스
		
		// 병합을 위한 추가 배열 생성 (arr와 크기가 같은 추가 배열)
		int[] sortedArr = new int[arr.length];
		
		// 두 배열의 데이터 arr[i]와 arr[j]를 비교하여 sortedArr에 저장
		// - 한 배열이라도 데이터가 존재하지 않을 때까지 반복 (두 배열 모두 데이터가 한 개 이상 존재하는 동안 반복) 
		while(i <= mid && j <= right) {
			// 더 작은 데이터를 추가 배열에 저장 후 각 인덱스 증가시킴
			if(arr[i] <= arr[j]) sortedArr[k++] = arr[i++];
			else sortedArr[k++] = arr[j++];
		}
		
		// 한 배열이라도 데이터가 존재하지 않는 경우, 남아 있는 데이터를 순서대로 sortedArr에 저장
		while(i <= mid) { // 첫 번째 배열에 데이터가 남아 있는 경우
			sortedArr[k++] = arr[i++]; // 데이터 옮기기
		}
		
		while(j <= right) { // 두 번째 배열에 데이터가 남아 있는 경우
			sortedArr[k++] = arr[j++]; // 데이터 옮기기
		}
		
		// 병합된 데이터들을 원래 배열로 옮기기
		for(int t = left; t <= right; t++) {
			arr[t] = sortedArr[t];
		}
	}
}