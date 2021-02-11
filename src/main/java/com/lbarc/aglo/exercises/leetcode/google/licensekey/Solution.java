package com.lbarc.aglo.exercises.leetcode.google.licensekey;

public class Solution {

	public String licenseKeyFormatting(String s, int k) {
		if (k == 0) {
			return "";
		}
		char[] chars = s.toCharArray();
		int characterCount = 0;
		for (char aChar : chars) {
			if (aChar == '-') {
				continue;
			}
			characterCount++;
		}

		if (characterCount == 0) {
			return "";
		}

		int groups = characterCount / k;
		int firstGroup = characterCount % k;

		int separators = groups - 1;
		if (firstGroup > 0) {
			separators++;
		}

		int length = (groups * k) + firstGroup + separators;
		char[] result = new char[length];
		int resultIdx = 0;
		boolean isFirstGroup = firstGroup > 0;
		int currentGroupLen = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '-') {
				continue;
			}
			result[resultIdx++] = chars[i];
			currentGroupLen++;
			if (isFirstGroup && resultIdx < length && currentGroupLen == firstGroup) {
				result[resultIdx++] = '-';
				isFirstGroup = false;
				currentGroupLen = 0;
			}
			if (currentGroupLen != 0 && resultIdx < length && currentGroupLen % k == 0) {
				result[resultIdx++] = '-';
			}
		}

		return String.valueOf(result).toUpperCase();
	}

	public static void main(String[] args) {
		new Solution().licenseKeyFormatting("5F3Z-2e-9-w", 4);
	}
}
