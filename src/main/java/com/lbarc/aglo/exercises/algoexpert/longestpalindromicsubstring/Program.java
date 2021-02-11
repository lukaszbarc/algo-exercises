package com.lbarc.aglo.exercises.algoexpert.longestpalindromicsubstring;

public class Program {

	public static String longestPalindromicSubstring(String str) {
		char[] chars = str.toCharArray();
		int left = 0;
		int right = 0;
		int maxLen = 1;
		for (int i = 0; i < chars.length - 1; i++) {
			int currentLeft = i;
			int currentRight = i;
			while (currentLeft > 0 && currentRight < chars.length - 1 && chars[currentLeft - 1] == chars[currentRight + 1]) {
				currentLeft--;
				currentRight++;
				if (currentRight - currentLeft > maxLen) {
					maxLen = currentRight - currentLeft;
					left = currentLeft;
					right = currentRight;
				}
			}
			currentLeft = i;
			currentRight = i + 1;
			while (currentLeft > 0 && currentRight < chars.length - 1 && chars[currentLeft - 1] == chars[currentRight + 1]) {
				currentLeft--;
				currentRight++;
				if (currentRight - currentLeft > maxLen) {
					maxLen = currentRight - currentLeft;
					left = currentLeft;
					right = currentRight;
				}
			}
		}
		return str.substring(left, right + 1);
	}

	public static void main(String[] args) {
		System.out.println(longestPalindromicSubstring("z234a5abbba54a32z"));
	}
}
