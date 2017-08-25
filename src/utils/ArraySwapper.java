package utils;

public class ArraySwapper {

    private ArraySwapper() {}

    public static void swap(final int[] arr, final int index1, final int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
