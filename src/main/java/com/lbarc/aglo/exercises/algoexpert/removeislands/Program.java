package com.lbarc.aglo.exercises.algoexpert.removeislands;

import java.util.ArrayDeque;
import java.util.Queue;

public class Program {

	public int[][] removeIslands(int[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;

		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if ((row == 0 || row == rows - 1 || column == 0 || column == columns - 1) && matrix[row][column] == 1) {
					bfs(row, column, matrix);
				}
			}
		}

		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (matrix[row][column] > 0) {
					matrix[row][column]--;
				}
			}
		}
		// Write your code here.
		return matrix;
	}

	private void bfs(int row, int column, int[][] matrix) {
		final Queue<Integer[]> q = new ArrayDeque<>();
		q.add(new Integer[]{row, column});

		while (!q.isEmpty()) {
			final Integer[] field = q.poll();
			final Integer r = field[0];
			final Integer c = field[1];
			if (matrix[r][c] == 1) {
				matrix[r][c] = 2;
				tryToAdd(r + 1, c, matrix, q);
				tryToAdd(r - 1, c, matrix, q);
				tryToAdd(r, c + 1, matrix, q);
				tryToAdd(r, c - 1, matrix, q);
			}
		}
	}

	private void tryToAdd(int r, Integer c, int[][] matrix, Queue<Integer[]> q) {
		try {
			if (matrix[r][c] == 1) {
				q.add(new Integer[]{r, c});
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// ignore
		}
	}

	public static void main(String[] args) {
		new Program().removeIslands(new int[][]{
				{1, 0, 0, 0, 0, 0},
				{0, 1, 0, 1, 1, 1},
				{0, 0, 1, 0, 1, 0},
				{1, 1, 0, 0, 1, 0},
				{1, 0, 1, 1, 0, 0},
				{1, 0, 0, 0, 0, 1}
		});
	}

}
