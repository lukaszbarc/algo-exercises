package com.lbarc.aglo.exercises.algoexpert.searchinsortedmatrix;

public class Program {

	public static int[] searchInSortedMatrix(int[][] matrix, int target) {
		int x = matrix[0].length - 1;
		int y = 0;

		while (x >= 0 && y <= matrix.length) {
			int current = matrix[y][x];
			if (current == target) {
				return new int[]{y, x};
			}
			if (current > target) {
				x--;
			}
			if (current < target) {
				y++;
			}

		}
		return new int[]{-1, -1};
	}

	public static void main(String[] args) {
		System.out.println(searchInSortedMatrix(new int[][]{
				{1, 4, 7, 12, 15, 1000},
				{2, 5, 19, 31, 32, 1001},
				{3, 8, 24, 33, 35, 1002},
				{40, 41, 42, 44, 45, 1003},
				{99, 100, 103, 106, 128, 1004}
		}, 44));
	}
}
