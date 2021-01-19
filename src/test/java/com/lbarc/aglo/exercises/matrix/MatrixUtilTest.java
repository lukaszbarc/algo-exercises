package com.lbarc.aglo.exercises.matrix;

import java.util.Arrays;

class MatrixUtilTest {

	public static void main(String[] args) {
		int[][] testMatrix = new int[][]{
				{1, 2, 3},
				{4, 5, 6}
		};
		final int[][] transposed = MatrixUtil.transpose(testMatrix);
		for (int[] ints : transposed) {
			System.out.println(Arrays.toString(ints));
		}

	}

}