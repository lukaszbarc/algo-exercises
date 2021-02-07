package com.lbarc.aglo.exercises.algoexpert.riversizes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Program {

	public static List<Integer> riverSizes(int[][] matrix) {
		boolean visited[][] = new boolean[matrix.length][matrix[0].length];
		final List<Integer> result = new ArrayList<>();

		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[0].length; column++) {
				if (visited[row][column]) {
					continue;
				}
				if (matrix[row][column] == 1) {
					int len = bfs(row, column, matrix, visited);
					result.add(len);
				}
			}
		}
		return result;
	}

	private static int bfs(int row, int column, int[][] matrix, boolean[][] visited) {
		final Queue<Integer[]> queue = new ArrayDeque<>();
		queue.add(new Integer[]{row, column});

		int len = 0;
		while (!queue.isEmpty()) {
			final Integer[] coords = queue.poll();
			if(visited[coords[0]][coords[1]]) {
				continue;
			}
			visited[coords[0]][coords[1]] = true;

			tryRight(coords, queue, matrix, visited);
			tryLeft(coords, queue, matrix, visited);
			tryUp(coords, queue, matrix, visited);
			tryDown(coords, queue, matrix, visited);
			len++;
		}

		return len;
	}

	private static void tryDown(Integer[] coords, Queue<Integer[]> queue, int[][] matrix, boolean[][] visited) {
		int row = coords[0];
		int column = coords[1];
		if (row + 1 < matrix.length && matrix[row + 1][column] == 1 && !visited[row + 1][column]) {
			queue.add(new Integer[]{row + 1, column});
		}
	}

	private static void tryUp(Integer[] coords, Queue<Integer[]> queue, int[][] matrix, boolean[][] visited) {
		int row = coords[0];
		int column = coords[1];
		if (row - 1 >= 0 && matrix[row - 1][column] == 1 && !visited[row - 1][column]) {
			queue.add(new Integer[]{row - 1, column});
		}
	}

	private static void tryLeft(Integer[] coords, Queue<Integer[]> queue, int[][] matrix, boolean[][] visited) {
		int row = coords[0];
		int column = coords[1];
		if (column - 1 >= 0 && matrix[row][column - 1] == 1 && !visited[row][column - 1]) {
			queue.add(new Integer[]{row, column - 1});
		}
	}

	private static void tryRight(Integer[] coords, Queue<Integer[]> queue, int[][] matrix, boolean[][] visited) {
		int row = coords[0];
		int column = coords[1];
		if (column + 1 < matrix[0].length && matrix[row][column + 1] == 1 && !visited[row][column + 1]) {
			queue.add(new Integer[]{row, column + 1});
		}
	}

	public static void main(String[] args) {
		List<Integer> integers = riverSizes(new int[][]{
				{1, 0, 0, 1, 0},
				{1, 0, 1, 0, 0},
				{0, 0, 1, 0, 1},
				{1, 0, 1, 0, 1},
				{1, 0, 1, 1, 0}
		});
		System.out.println(integers);
	}
}
