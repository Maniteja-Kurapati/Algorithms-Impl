package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WhiteBoard {

	public static void main(final String[] args) {

		int[] input = new int[] { 1, 2, -2, -1 };

		System.out.println(WhiteBoard.threeSum(input));

	}

	private static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> pairs = new ArrayList<List<Integer>>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])) {
					if (-(nums[i] + nums[j]) >= nums[j]) {
						int indexOfRequired = Arrays.binarySearch(nums, j + 1, nums.length, -(nums[i] + nums[j]));
						if (indexOfRequired >= 0) {
							pairs.add(Arrays.asList(new Integer[] { nums[i], nums[j], nums[indexOfRequired] }));
						}
					}
				}

			}
		}

		return pairs;
	}
}
