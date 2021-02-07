package com.lbarc.aglo.exercises.expert.minheap;

import java.util.Arrays;

public class WaterArea {

	public static int waterArea(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}
		int[] maxLeftBound = new int[heights.length];
		maxLeftBound[0] = heights[0];

		for (int i = 1; i < heights.length; i++) {
			maxLeftBound[i] = Math.max(maxLeftBound[i - 1], heights[i]);
		}
		System.out.println(Arrays.toString(maxLeftBound));
		int sum = 0;
		int currentRightBound = 0;
		for (int i = heights.length - 1; i >= 0; i--) {
			if (heights[i] > currentRightBound) {
				currentRightBound = heights[i];
			} else {
				sum += Math.min(currentRightBound, maxLeftBound[i]) - heights[i];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		waterArea(new int[]{0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3});
	}

}
