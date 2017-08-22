package utils;

import java.util.Random;

public class ArrayGenerator {

	public static int[] getArray(int size) {
		int[] array = new int[size];
		Random generator = new Random();
		for (int i = 0; i < size; i++) {
			array[i] = generator.nextInt();
		}
		return array;
	}
}
