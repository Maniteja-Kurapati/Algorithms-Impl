package sorting;

import java.util.Arrays;

import utils.ArrayGenerator;
import utils.TimeUtil;

public class MergeSort {
	public static void main(final String[] args) {

		int[] input = ArrayGenerator.getArray(1000000);
		TimeUtil.start();
		MergeSort.mSort(input, 0, input.length - 1);
		TimeUtil.stop();
		System.out.println(TimeUtil.elaspedTime());
		if (input.length < 1000) {
			System.out.println(Arrays.toString(input));
		}
		System.out.println("Completed");
	}

	/**
	 * Sorting Procedure.
	 */
	public static int[] mSort(final int[] inputArr, final int p, final int r) {
		if (p < r) {
			int q = (int) Math.floor((p + r) / 2);
			mSort(inputArr, p, q);
			mSort(inputArr, q + 1, r);
			merge(inputArr, p, q, r);
		}
		return inputArr;
	}

	private static void merge(final int[] arr, final int p, final int q, final int r) {
		int[] arr1 = new int[(q - p) + 2];
		int[] arr2 = new int[(r - q) + 1];
		for (int i = 0; i <= arr1.length - 2; i++) {
			arr1[i] = arr[p + i];
		}
		for (int i = 0; i <= arr2.length - 2; i++) {
			arr2[i] = arr[q + 1 + i];
		}
		arr1[arr1.length - 1] = (int) Double.POSITIVE_INFINITY;
		arr2[arr2.length - 1] = (int) Double.POSITIVE_INFINITY;
		int x = 0;
		int y = 0;
		for (int j = p; j <= r; j++) {
			if (arr1[x] < arr2[y]) {
				arr[j] = arr1[x];
				x++;
			} else {
				arr[j] = arr2[y];
				y++;
			}
		}
	}
}
