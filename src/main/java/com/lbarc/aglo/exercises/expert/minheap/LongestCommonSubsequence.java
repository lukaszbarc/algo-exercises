package com.lbarc.aglo.exercises.expert.minheap;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		longestCommonSubsequence("zxvvyzw", "xkykzpw");
	}

	/**
	 * - |  s  |  t  |  r  |  2  |
	 * --------------------------
	 * s |
	 * --------------------------
	 * t |
	 * --------------------------
	 * r |
	 * --------------------------
	 * 1 |
	 * --------------------------
	 */
	public static List<Character> longestCommonSubsequence(String str1, String str2) {
		List<Character>[][] table = new List[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i <= str1.length(); i++) {
			table[i][0] = Collections.emptyList();
		}

		for (int i = 0; i <= str2.length(); i++) {
			table[0][i] = Collections.emptyList();
		}

		for (int y = 1; y <= str1.length(); y++) {
			for (int x = 1; x <= str2.length(); x++) {
				table[y][x] = new LinkedList<>();
				if (str1.charAt(y-1) == str2.charAt(x-1)) {
					table[y][x].addAll(table[y - 1][x - 1]);
					table[y][x].add(str1.charAt(y-1));
				} else {
					boolean topIsLonger = table[y - 1][x].size() > table[y][x - 1].size();
					table[y][x].addAll(topIsLonger ? table[y - 1][x] : table[y][x - 1]);
				}
			}
		}
		// Write your code here.
		return table[str1.length()][str2.length()];
	}
}
