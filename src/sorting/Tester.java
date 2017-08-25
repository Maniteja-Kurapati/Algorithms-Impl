package sorting;

import java.util.Arrays;

import utils.ArrayGenerator;
import utils.TimeUtil;

public class Tester {

    public static void main(final String[] args) {
        int[] input = ArrayGenerator.getArray(1000000000);
        TimeUtil.start();
        HeapSort.heapSort(input);
        TimeUtil.stop();
        System.out.println(TimeUtil.elaspedTime());
        if (input.length < 1000) {
            System.out.println(Arrays.toString(input));
        }
        System.out.println("Completed");
    }
}
