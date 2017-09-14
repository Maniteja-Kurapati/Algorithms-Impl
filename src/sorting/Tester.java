package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import data.structures.LinkedList;
import utils.ArrayGenerator;
import utils.TimeUtil;

public class Tester {

	public static void main(final String[] args) {

		// Tester.linkedListTest();
		// Tester.heapSortTest();
		// int[] input = new int[] { 3, 2, 4 };
		// System.out.println(Arrays.toString(input));
		// Tester.twoSum(input, 6);

		Tester.lengthOfLongestSubstring("abcabcbb");

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

	private static int[] twoSum(final int[] nums, final int target) {
		int[] indexes = new int[2];
		int index1;
		int index2;
		int copynums[] = Arrays.copyOf(nums, nums.length);
		Arrays.sort(copynums);
		for (int i = 0; i < copynums.length - 1; i++) {
			index1 = i;
			int index = Arrays.binarySearch(copynums, i + 1, copynums.length, target - copynums[index1]);
			if (index > 0) {
				index2 = index;
				indexes[0] = -1;
				indexes[1] = -1;
				for (int j = 0; (j < nums.length && (indexes[0] < 0 || indexes[1] < 0)); j++) {
					if (nums[j] == copynums[index1] || nums[j] == copynums[index2]) {
						if (indexes[0] < 0) {
							indexes[0] = j;
						} else {
							indexes[1] = j;
						}
					}
				}
				System.out.println(Arrays.toString(indexes));
				return indexes;
			}
		}
		System.out.println(Arrays.toString(indexes));
		return indexes;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		int num1 = 0;
		int num2 = 0;
		ListNode ansHead = null;
		ListNode curAns = null;
		ListNode list1 = l1;
		ListNode list2 = l2;

		while (list1 != null || list2 != null) {
			if (list1 != null) {
				num1 = list1.val;
				list1 = list1.next;
			} else {
				num1 = 0;
			}
			if (list2 != null) {
				num2 = list2.val;
				list2 = list2.next;
			} else {
				num2 = 0;
			}
			if (ansHead == null) {
				int sum = num1 + num2 + carry;
				if (sum >= 10) {
					carry = 1;
					ansHead = new ListNode(sum % 10);
				} else {
					carry = 0;
					ansHead = new ListNode(sum);
				}
				curAns = ansHead;
			} else {
				int sum = num1 + num2 + carry;
				if (sum >= 10) {
					carry = 1;
					curAns.next = new ListNode(sum % 10);
				} else {
					carry = 0;
					curAns.next = new ListNode(sum);
				}
				curAns = curAns.next;
			}
		}

		if (carry != 0) {
			curAns.next = new ListNode(carry);
		}

		return ansHead;
	}

	private static int lengthOfLongestSubstring(String s) {
		char[] originalCharArr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ "
				.toCharArray();

		String[] originalArr = new String[originalCharArr.length];
		for (int k = 0; k < originalCharArr.length; k++) {
			originalArr[k] = String.valueOf(originalCharArr[k]);
		}

		String[] chrArray = Arrays.copyOf(originalArr, originalArr.length);

		Map<String, Integer> map = new HashMap<>();
		for (int j = 0; j < chrArray.length; j++) {
			map.put(chrArray[j], j);
		}

		int longestlength = 0;
		int length = 0;

		for (int i = 0; i < s.length(); i++) {

			if (chrArray[map.get(String.valueOf(s.charAt(i)))] != "alfnd") {
				length = length + 1;
				chrArray[map.get(String.valueOf(s.charAt(i)))] = "alfnd";
			} else {
				if (length > longestlength) {
					longestlength = length;
				}
				length = 1;
				for (int m = i - 1; s.charAt(m) != s.charAt(i); m--) {
					length = length + 1;
				}
				if (s.charAt(i) == s.charAt(i - 1)) {
					length = 1;
					chrArray = Arrays.copyOf(originalArr, originalArr.length);
					chrArray[map.get(String.valueOf(s.charAt(i)))] = "alfnd";
				}
			}

		}

		if (length > longestlength) {
			longestlength = length;
		}

		return longestlength;
	}
}
