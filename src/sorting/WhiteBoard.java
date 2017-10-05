package sorting;

public class WhiteBoard {

	public static void main(final String[] args) {

		int[] input = new int[] { 1, 2, -2, -1 };

		System.out.println(WhiteBoard.strStr("mississippi", "issip"));

	}

	private static int strStr(String haystack, String needle) {
		if (haystack == needle || haystack.isEmpty() || needle.isEmpty()) {
			return (haystack.isEmpty() && needle.isEmpty()) ? 0 : haystack.isEmpty() ? -1 : 0;
		}
		int needlePointer = 0;
		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(needlePointer)) {
				needlePointer++;
			} else {
				needlePointer = 0;
			}
			if (needlePointer == needle.length()) {
				return i - needle.length() + 1;
			}
		}
		return -1;
	}
}
