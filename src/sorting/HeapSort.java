package sorting;

public final class HeapSort {
	private static int arraySize;

	private HeapSort() {
	}

	public static void heapSort(final int[] arr) {
		buildMaxHeap(arr);

		for (int i = arraySize - 1; i > 0; i--) {
			swap(arr, 0, i);
			arraySize = arraySize - 1;
			maxHeapify(arr, 0);
		}
	}

	private static void buildMaxHeap(final int[] arr) {
		arraySize = arr.length;
		for (int i = arraySize / 2 - 1; i >= 0; i--) {
			maxHeapify(arr, i);
		}
	}

	private static void maxHeapify(final int[] heapArr, final int index) {
		int left = leftChildIndex(index);
		int right = rightChildIndex(index);
		int largest = index;
		if (left < arraySize && heapArr[left] > heapArr[largest]) {
			largest = left;
		}
		if (right < arraySize && heapArr[right] > heapArr[largest]) {
			largest = right;
		}
		if (index != largest) {
			swap(heapArr, index, largest);
			maxHeapify(heapArr, largest);
		}
	}

	private static int leftChildIndex(final int index) {
		return 2 * index + 1;
	}

	private static int rightChildIndex(final int index) {
		return 2 * index + 2;
	}

	private static void swap(final int[] arr, final int index1, final int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
