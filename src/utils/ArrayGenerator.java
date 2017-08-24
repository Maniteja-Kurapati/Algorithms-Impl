package utils;

import java.util.Random;

public class ArrayGenerator {

    public static int[] getArray(final int size) {
        int[] array = new int[size];
        Random generator = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = generator.nextInt();
        }
        return array;
    }

    public static int[] getArray(final int size, final int seed) {
        int[] array = new int[size];
        Random generator = new Random(seed);
        for (int i = 0; i < size; i++) {
            array[i] = generator.nextInt();
        }
        return array;
    }
}
