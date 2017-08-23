package searching;

import sorting.MergeSort;

public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		int[] input = { 9, 8, 6, 99, 100, 7, 3, 1, 4, 2, 5, 55, 44, 33, -5, -50, -1, -99 };
		MergeSort.mSort(input, 0, input.length - 1);
		int output = BinarySearch.binarySearch(input, 0, input.length - 1, -5);
		System.out.println(output);
	}
  
	/**
	 * Search Procedure.
	 */
	public static int binarySearch(final int[] arr, int p, int q, int value) {

		if (p <= q) {
			int middle = (int) Math.floor((p + q) / 2);
			if (arr[middle] == value) {
				return middle;
			} else if (arr[middle] < value) {
				return binarySearch(arr, middle + 1, q, value);
			} else {
				return binarySearch(arr, p, middle - 1, value);
			}
		} else {
			return -1;
		}
	}
}
