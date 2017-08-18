/**
 *
 */
package sorting;

import java.util.Arrays;

/**
 * @author ManiTeja (MK051340)
 * 
 */
public class InsertionSort {

    /**
     * @param args
     */
    public static void main(final String[] args) {

        int[] input = { 9, 8, 6, 99, 100, 7, 3, 1, 4, 2, 5, 55, 44, 33, -5, -50, -1, -99 };
        int[] output = InsertionSort.perform(input);
        System.out.println(Arrays.toString(output));

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
