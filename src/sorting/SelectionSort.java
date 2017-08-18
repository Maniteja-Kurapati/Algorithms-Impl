package sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(final String[] args) {

        int[] input = { 9, 8, 6, 99, 100, 7, 3, 1, 4, 2, 5, 55, 44, 33, -5, -50, -1, -99 };
        int[] output = SelectionSort.perform(input);
        System.out.println(Arrays.toString(output));

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
