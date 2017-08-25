package sorting;

import java.util.Arrays;

import utils.ArrayGenerator;
import utils.ArraySwapper;
import utils.TimeUtil;

public class QuickSort {

    public static void main(final String[] args) {

        int[] input = ArrayGenerator.getArray(1000000000);
        TimeUtil.start();
        QuickSort.quickSort(input, 0, input.length - 1);
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
    public static void quickSort(final int[] arr, final int p, final int q) {
        if (p < q) {
            int key = arr[q];
            int i = p - 1;
            for (int j = p; j <= q - 1; j++) {
                if (arr[j] < key) {
                    i = i + 1;
                    ArraySwapper.swap(arr, j, i);
                }
            }
            i = i + 1;
            ArraySwapper.swap(arr, q, i);
            quickSort(arr, p, i - 1);
            quickSort(arr, i + 1, q);
        }
    }
}
