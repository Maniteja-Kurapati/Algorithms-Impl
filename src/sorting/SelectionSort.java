package sorting;

import java.util.Arrays;

import utils.ArrayGenerator;
import utils.TimeUtil;

public class SelectionSort {

	public static void main(final String[] args) {

		int[] input = ArrayGenerator.getArray(10000000);
		TimeUtil.start();
		SelectionSort.perform(input);
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
	public static int[] perform(final int[] inputArr) {
		int arrLength = inputArr.length;
		for (int i = 0; i <= arrLength - 2; i++) {
			int smallest = i;
			for (int j = i + 1; j <= arrLength - 1; j++) {
				if (inputArr[j] < inputArr[smallest]) {
					smallest = j;
				}
			}
			int temp = inputArr[i];
			inputArr[i] = inputArr[smallest];
			inputArr[smallest] = temp;
		}
		return inputArr;
	}
}
