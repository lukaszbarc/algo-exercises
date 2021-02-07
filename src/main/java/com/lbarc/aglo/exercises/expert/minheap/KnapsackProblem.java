package com.lbarc.aglo.exercises.expert.minheap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapsackProblem {

	public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
		final int[][] matrix = new int[items.length + 1][capacity + 1];

		for (int y = 1; y < matrix.length; y++) {
			for (int cap = 0; cap < matrix[0].length; cap++) {
				int item[] = items[y - 1];
				int value = item[0];
				int weight = item[1];

				if (weight > cap) {
					matrix[y][cap] = matrix[y - 1][cap];
				} else {
					matrix[y][cap] = Math.max(matrix[y - 1][cap - weight] + value, matrix[y - 1][cap]);
				}
			}
		}

		final int[] results = findMaxValue(matrix);
		final int maxValue = results[0];
		final int maxValueColumn = results[1];
		final int maxValueRow = results[2];

		int remainingValue = maxValue;
		int remainingCapacity = maxValueColumn;
		int currentRow = maxValueRow;
		int currentColumn = maxValueColumn;

		final List<Integer> finalItems = new ArrayList<>();
		while (remainingValue > 0) {
			finalItems.add(currentRow - 1);
			currentColumn -= items[currentRow - 1][1];
			int valueWithoutCurrent = matrix[currentRow][currentColumn];
			while (currentRow > 0 && matrix[currentRow - 1][currentColumn] == valueWithoutCurrent) {
				remainingValue = valueWithoutCurrent;
				currentRow--;
			}
		}

		final List<Integer> totalValue = Arrays.asList(maxValue);
		final List<List<Integer>> result = new ArrayList<>();
		result.add(totalValue);
		result.add(finalItems);
		return result;
	}

	private static int[] findMaxValue(int[][] matrix) {
		int max = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] > max) {
					max = matrix[i][j];
					y = i;
					x = j;
				}
			}
		}
		return new int[]{max, x, y};
	}

	public static void main(String[] args) {
		//		knapsackProblem(new int[][]
		//						{
		//								{465, 100},
		//								{400, 85},
		//								{255, 55},
		//								{350, 45},
		//								{650, 130},
		//								{1000, 190},
		//								{455, 100},
		//								{100, 25},
		//								{1200, 190},
		//								{320, 65},
		//								{750, 100},
		//								{50, 45},
		//								{550, 65},
		//								{100, 50},
		//								{600, 70},
		//								{240, 40}
		//						}
		//
		//				, 200);
		knapsackProblem(new int[][]{
						{1, 2},
						{4, 3},
						{5, 6},
						{8, 7}},
				13);

	}
}
