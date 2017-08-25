/**
 *
 */
package sorting;

import java.util.Arrays;

import utils.ArrayGenerator;
import utils.TimeUtil;

/**
 * @author ManiTeja (MK051340)
 * 
 */
public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		int[] input = ArrayGenerator.getArray(1000000);
		TimeUtil.start();
		InsertionSort.perform(input);
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
	public static int[] perform(final int[] A) {

		for (int i = 0; i < A.length; i++) {
			int key = A[i];
			int j = i - 1;
			while (j >= 0 && A[j] > key) {
				A[j + 1] = A[j];
				j--;
			}
			A[j + 1] = key;
		}
		return A;
	}
}
