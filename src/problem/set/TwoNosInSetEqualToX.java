package problem.set;

import searching.BinarySearch;
import sorting.MergeSort;

public class TwoNosInSetEqualToX {

	public static void main(String[] args) {
        int[] input = { 9, 8, 6, 99, 100, 7, 3, 1, 4, 2, 5, 55, 44, 33, -5, -50, -1, -99 };
        int[] output = TwoNosInSetEqualToX.findIndexes(input, 8);
        System.out.println("values are :"+ input[output[0]] + "and" + input[output[1]]);
	}
	
	public static int[] findIndexes(int[] arr, int value) {
		int[] indexes = new int[2];
		
		MergeSort.mSort(arr, 0, arr.length-1);
		for(int i =0; i<= arr.length-2; i++) {
			int valToBeSearched = value-arr[i];
			int j = BinarySearch.binarySearch(arr, i+1, arr.length-1, valToBeSearched);
			if(j > 0) {
				 indexes[0] = i;
				 indexes[1] = j;
				 return indexes;
			}
		}		
		return indexes;		
	}
}
