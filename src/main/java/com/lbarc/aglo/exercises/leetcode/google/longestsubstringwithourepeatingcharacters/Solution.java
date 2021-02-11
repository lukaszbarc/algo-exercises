package com.lbarc.aglo.exercises.leetcode.google.longestsubstringwithourepeatingcharacters;

import java.util.Arrays;

public class Solution {

	public int lengthOfLongestSubstring(String s) {
		int[] charIdx = new int[65535];
		Arrays.fill(charIdx, -1);

		char[] chars = s.toCharArray();

		int start = 0;
		int max = 0;
		for (int i = 0; i < chars.length; i++) {
			if (charIdx[chars[i]] == -1 || charIdx[chars[i]] < start) {
				charIdx[chars[i]] = i;
				max = Math.max(i - start + 1, max);
			} else {
				max = Math.max(i - start, max);
				start = charIdx[chars[i]] + 1;
				charIdx[chars[i]] = i;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		new Solution().lengthOfLongestSubstring("tmmzuxt");
	}

}
