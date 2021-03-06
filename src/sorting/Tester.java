package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
		System.out.println(Tester.longestPalindrome("zyxabacdffdcabapqr"));

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

		ListNode(final int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(final ListNode l1, final ListNode l2) {
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

	// private static int lengthOfLongestSubstring(final String s) {
	// char[] originalCharArr =
	// "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~
	// "
	// .toCharArray();
	//
	// String[] originalArr = new String[originalCharArr.length];
	// for (int k = 0; k < originalCharArr.length; k++) {
	// originalArr[k] = String.valueOf(originalCharArr[k]);
	// }
	//
	// String[] chrArray = Arrays.copyOf(originalArr, originalArr.length);
	//
	// Map<String, Integer> map = new HashMap<String, Integer>();
	// for (int j = 0; j < chrArray.length; j++) {
	// map.put(chrArray[j], j);
	// }
	//
	// int longestlength = 0;
	// int length = 0;
	//
	// for (int i = 0; i < s.length(); i++) {
	//
	// if (chrArray[map.get(String.valueOf(s.charAt(i)))] != "alfnd") {
	// length = length + 1;
	// chrArray[map.get(String.valueOf(s.charAt(i)))] = "alfnd";
	// } else {
	// if (length > longestlength) {
	// longestlength = length;
	// }
	// length = 1;
	// for (int m = i - 1; s.charAt(m) != s.charAt(i); m--) {
	// length = length + 1;
	// }
	// if (s.charAt(i) == s.charAt(i - 1)) {
	// length = 1;
	// chrArray = Arrays.copyOf(originalArr, originalArr.length);
	// chrArray[map.get(String.valueOf(s.charAt(i)))] = "alfnd";
	// }
	// }
	//
	// }
	//
	// if (length > longestlength) {
	// longestlength = length;
	// }
	//
	// return longestlength;
	// }

	private static int lengthOfLongestSubstring(final String s) {
		int longest = 0;
		int n = s.length();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int i = 0;
		int j = i;

		while (i < n && j < n) {
			if (map.containsKey(s.charAt(j))) {
				i = map.get(s.charAt(j)) + 1;
				j = i;
				map.clear();
			} else {
				map.put(s.charAt(j), j);
				longest = Math.max(map.size(), longest);
				j++;
			}
		}
		return longest;
	}

	// public int reverse(final int x) {
	// int largestPossible = 2 ^ 31;
	// String largest = String.valueOf(largestPossible);
	// String strX = String.valueOf(x);
	// if (strX.charAt(strX.length() - 1) == largest.charAt(0)) {
	// return 0;
	// }
	// char[] ans = new char[strX.length()];
	// int i = 0;
	// for (int j = strX.length() - 1; j >= 0; j--) {
	// ans[i] = strX.charAt(j);
	// i++;
	// }
	// return Integer.valueOf(ans.toString());
	//
	// }

	private static int reverse(int x) {
		int reverse = 0;
		int result = 0;
		while (x != 0) {
			result = reverse * 10 + x % 10;
			if ((reverse - (x % 10)) / 10 != reverse) {
				return 0;
			}
			reverse = result;
			x = x / 10;
		}

		return reverse;
	}

	public int singleNumber(final int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.remove(nums[i]);
			} else {
				map.put(nums[i], nums[i]);
			}
		}
		return map.values().iterator().next();
	}

	private static String longestPalindrome(final String s) {
		int longest = 0;
		int longestLeft = 0;
		int longestRight = 0;

		for (int center = 1, right = center + 1, left = center - 1; center < s.length() - 1; center++, right = center
				+ 1, left = center - 1) {
			while (left >= 0 && right < s.length() && s.charAt(right) == s.charAt(left)) {
				right++;
				left--;
			}
			int currentPalLength = (--right) - (++left) + 1;
			if (currentPalLength > longest) {
				longest = currentPalLength;
				longestLeft = left;
				longestRight = right;
			}
		}

		double center = 0.5;
		int right = (int) (center + 0.5);
		int left = (int) (center - 0.5);

		for (; center < s.length() - 0.5; center++, right = (int) (center + 0.5), left = (int) (center - 0.5)) {
			while (left >= 0 && right < s.length() && s.charAt(right) == s.charAt(left)) {
				right++;
				left--;
			}
			int currentPalLength = (--right) - (++left) + 1;
			if (currentPalLength > longest) {
				longest = currentPalLength;
				longestLeft = left;
				longestRight = right;
			}
		}

		return s.substring(longestLeft, longestRight + 1);
	}

	public boolean isPalindrome(int x) {
		int reverse = 0;
		int original = x;
		while (x != 0) {
			reverse = reverse * 10 + (x % 10);
			x = x / 10;
		}
		if (reverse == original) {
			return true;
		}
		return false;
	}

	private static int maxAreaWithoutSlant(final int[] height) {
		int maxArea = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < height.length; i++) {
			if (map.containsKey(height[i])) {
				maxArea = Math.max(maxArea, height[i] * (i - map.get(height[i])));
			} else {
				map.put(height[i], i);
			}
		}
		return maxArea;
	}

	private static String longestCommonPrefix(final String[] strs) {
		if (strs.length <= 0) {
			return "";
		}

		int charPosition = 0;
		while (true) {
			for (int i = 1; i < strs.length; i++) {
				if (charPosition >= strs[i].length() || charPosition >= strs[i - 1].length()) {
					return strs[0].substring(0, charPosition);
				}
				if (strs[i].charAt(charPosition) != strs[i - 1].charAt(charPosition)) {
					return strs[0].substring(0, charPosition);
				}
			}
			charPosition++;
		}

	}

	// private static List<String> letterCombinations(final String digits) {
	// String mappings[] =
	// new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
	// "wxyz" };
	// LinkedList<String> queue = new LinkedList<String>();
	// if (digits.length() < 1) {
	// return (List<String>) queue;
	// }
	// queue.add("");
	// LinkedList<String> temp = new LinkedList<String>();
	//
	// for (int i = 0; i < digits.length(); i++) {
	// while (!queue.isEmpty()) {
	// temp.add(queue.poll());
	// }
	// while (!temp.isEmpty()) {
	// String str = temp.poll();
	// for (Character c : mappings[Character.getNumericValue(digits.charAt(i))]
	// .toCharArray()) {
	// queue.add(str + c);
	// }
	// }
	// }
	// return queue;
	//
	// }

	public ListNode removeNthFromEnd(ListNode head, final int n) {
		ArrayList<ListNode> nodes = new ArrayList<ListNode>();
		ListNode current = head;
		while (current != null) {
			nodes.add(current);
			current = current.next;
		}
		int nodeToBeRemoved = nodes.size() - n;
		if (nodeToBeRemoved - 1 < 0) {
			head = head.next;
		}
		nodes.get(nodeToBeRemoved - 1).next = nodes.get(nodeToBeRemoved).next;
		return head;
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

	public ListNode swapPairs(final ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode current = dummy;

		while (current.next != null && current.next.next != null) {
			ListNode second = current.next.next;
			ListNode temp = current.next.next.next;
			current.next.next.next = current.next;
			current.next.next = temp;
			current.next = second;
			current = current.next.next;
		}

		return dummy.next;

	}

	public static int divide(int dividend, int divisor) {
		int remainder = 0;
		int posDivisor = divisor < 0 ? -divisor : divisor;
		int posDividend = dividend < 0 ? -dividend : dividend;
		int sum = posDivisor;
		while (sum <= posDividend) {
			sum = sum + posDivisor;
			remainder++;
		}

		return divisor < 0 || dividend < 0 ? divisor < 0 && dividend < 0 ? remainder : -remainder : remainder;
	}

	private static int threeSumClosest(final int[] nums, final int target) {

		Arrays.sort(nums);
		int distance = (int) Double.POSITIVE_INFINITY;
		int sum = 0;

		for (int i = 0; i < nums.length - 2; i++) {
			for (int left = i + 1, right = nums.length - 1; left < right;) {
				int curSum = nums[i] + nums[left] + nums[right];
				if (curSum > target) {
					right--;
				} else if (curSum < target) {
					left++;
				} else {
					return curSum;
				}
				int curDis = target - (curSum);
				if (curDis < 0) {
					if (-curDis < distance) {
						distance = -curDis;
						sum = curSum;
					}
				} else {
					if (curDis < distance) {
						distance = curDis;
						sum = curSum;
					}
				}

			}
		}
		return sum;
	}

	private static int removeDuplicates(int[] nums) {
		int pointer = 0;
		int length = nums.length > 0 ? 1 : 0;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[pointer + 1] = nums[i];
				pointer++;
				length++;
			}
		}
		return length;
	}
}
