package com.lbarc.aglo.exercises.algoexpert.squareofzeros;

import java.util.List;

public class Program {

	public static boolean squareOfZeroes(List<List<Integer>> matrix) {

		for (int y = 0; y < matrix.size(); y++) {
			for (int x = 0; x < matrix.size(); x++) {
				if (matrix.get(y).get(x) == 1) {
					continue;
				}
				int nextY = y + 1;
				int nextX = x + 1;
				while (withinRange(nextX, nextY, matrix)) {
					if (checkIfSquareOfZeros(x, y, nextX, nextY, matrix)) {
						return true;
					}
					nextX++;
					nextY++;
				}
			}
		}
		return false;
	}

	private static boolean checkIfSquareOfZeros(int x, int y, int nextX, int nextY, List<List<Integer>> matrix) {
		int currX = x;
		int currY = y;
		while (currX < nextX) {
			if (matrix.get(currY).get(currX) == 1) {
				return false;
			}
			currX++;
		}
		while (currY < nextY) {
			if (matrix.get(currY).get(currX) == 1) {
				return false;
			}
			currY++;
		}
		while (currX > x) {
			if (matrix.get(currY).get(currX) == 1) {
				return false;
			}
			currX--;
		}
		while (currY > y) {
			if (matrix.get(currY).get(currX) == 1) {
				return false;
			}
			currY--;
		}
		return true;
	}

	private static boolean withinRange(int x, int y, List<List<Integer>> matrix) {
		return x < matrix.size() && y < matrix.size();
	}

}
