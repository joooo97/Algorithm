public class BubbleSort {

	// 버블 정렬: 인접한 두개의 원소를 비교하여 자리를 교환하는 방식을 반복하여 정렬하는 방법
	void bubbleSort(int[] arr, int n) {
		// 마지막에 남은 첫 번째 원소는 정렬하지 않아도 되므로 n-1번의 과정 반복
		for(int i = 0; i < n-1; i++) {
			// j와 j+1 위치의 값을 비교 후 교환
			for(int j = 0; j < n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

}