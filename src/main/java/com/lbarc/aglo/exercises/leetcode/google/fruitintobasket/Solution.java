package com.lbarc.aglo.exercises.leetcode.google.fruitintobasket;

public class Solution {

	public int totalFruit(int[] tree) {
		int a = tree[0];
		int b = tree[0];

		int length = 0;
		int bIndex = 0;
		int max = 0;
		for (int i = 0; i < tree.length; i++) {
			if (a == tree[i] || b == tree[i]) {
				length++;
			} else if (a == b) {
				b = tree[i];
				length++;
				bIndex = i;
			} else {
				a = b;
				i = bIndex;
				length = 1;
			}
			max = Math.max(length, max);

		}
		return max;
	}

	public static void main(String[] args) {
		new Solution().totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4});
	}

}
