package com.lbarc.aglo.exercises.expert.minheap;

public class Levenshtein {

	public static int levenshteinDistance(String str1, String str2) {
		int xSize = str1.length() + 1;
		int ySize = str2.length() + 1;
		int matrix[][] = new int[ySize][xSize];
		for (int i = 0; i < xSize; i++) {
			matrix[0][i] = i;
		}
		for (int i = 0; i < ySize; i++) {
			matrix[i][0] = i;
		}

		for (int y = 1; y < ySize; y++) {
			for (int x = 1; x < xSize; x++) {
				if (str1.charAt(x - 1) == str2.charAt(y - 1)) {
					matrix[y][x] = matrix[y - 1][x - 1];
				} else {
					matrix[y][x] = Math.min(matrix[y - 1][x - 1], Math.min(matrix[y][x - 1], matrix[y - 1][x])) + 1;
				}
			}
		}

		return matrix[ySize - 1][xSize - 1];
	}

	public static void main(String[] args) {
		int result = levenshteinDistance("saturday", "sunday");

		System.out.println(result);
	}
}
