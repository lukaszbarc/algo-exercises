package com.lbarc.aglo.exercises.leetcode.google.containerwithmostwater;

public class Solution {

	public int maxArea(int[] height) {
		int idxL = 0;
		int idxR = height.length - 1;
		int max = (idxR - idxL) * Math.min(height[idxL], height[idxR]);
		while (idxL < idxR) {
			if (height[idxL] > height[idxR]) {
				idxR--;
			} else {
				idxL++;
			}
			max = Math.max(max, (idxR - idxL) * Math.min(height[idxL], height[idxR]));
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().maxArea(new int[]{1,2,1}));
	}
}
