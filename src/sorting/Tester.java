package sorting;

import utils.ArrayGenerator;

public class Tester {

    public static void main(final String[] args) {
        // int[] input = { 9, 8, 6, 99, 100, 7, 3, 1, 4, 2, 5, 55, 44, 33, -5, -50, -1, -99 };
        int[] input = ArrayGenerator.getArray(100000000);
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(input);
        // System.out.println(Arrays.toString(input));
        System.out.println("Completed");
    }
}
