package com.lbarc.aglo.exercises.matrix;

public class MatrixUtil {

	public static int[][] transpose(int[][] input) {
		if (input.length == 0) {
			return new int[][]{};
		}
		int[][] result = new int[input[0].length][input.length];
		for (int row = 0; row < input.length; row++) {
			for (int column = 0; column < input[0].length; column++) {
				result[column][row] = input[row][column];
			}
		}
		return result;
	}

}
