package com.lbarc.aglo.exercises.expert.minheap;

public class Hourglasses {

	private static int[][] pattern = new int[][]{
			{1, 1, 1},
			{0, 1, 0},
			{1, 1, 1}
	};

	static int hourglassSum(int[][] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				max = Math.max(max, calculatePattern(arr, i, j));
			}
		}
		return max;
	}

	private static int calculatePattern(int[][] arr, int rowShift, int columnShift) {
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (pattern[i][j] == 1) {
					sum += arr[i + rowShift][j + columnShift];
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(
				hourglassSum(new int[][]{
						{1, 1, 1, 0, 0, 0},
						{0, 1, 0, 0, 0, 0},
						{1, 1, 1, 0, 0, 0},
						{0, 0, 2, 4, 4, 0},
						{0, 0, 0, 2, 0, 0},
						{0, 0, 1, 2, 4, 0}
				}));
	}
}

