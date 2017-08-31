package sorting;

import java.util.Arrays;

import utils.ArrayGenerator;
import utils.TimeUtil;
import data.structures.LinkedList;

public class Tester {

    public static void main(final String[] args) {

        Tester.linkedListTest();
        // Tester.heapSortTest();
    }

    private static void linkedListTest() {
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        for (int i = 0; i <= 9; i++) {
            numbers.add(i);
        }
        numbers.printList();
        numbers.delete(5);
        numbers.printList();
        System.out.println(numbers.indexOf(6));
    }

    private static void heapSortTest() {
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
