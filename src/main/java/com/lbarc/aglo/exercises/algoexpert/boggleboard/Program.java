package com.lbarc.aglo.exercises.algoexpert.boggleboard;

import java.util.ArrayList;
import java.util.List;

public class Program {

	public static List<String> boggleBoard(char[][] board, String[] words) {
		final List<String> result = new ArrayList<>();
		for (String word : words) {
			if (isAchievable(board, word)) {
				result.add(word);
			}
		}
		return result;
	}

	private static boolean isAchievable(char[][] board, String word) {
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[0].length; column++) {
				boolean[][] used = new boolean[board.length][board[0].length];
				if (isAchievableFrom(word, board, row, column, used)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isAchievableFrom(String word, char[][] board, int row, int column, boolean[][] used) {
		if (!safeArrCheck(board, row, column, word.charAt(0)) || used[row][column]) {
			return false;
		}
		if (word.length() == 1) {
			return true;
		}
		used[row][column] = true;
		String remaining = word.substring(1);
		boolean result = (
				isAchievableFrom(remaining, board, row, column + 1, used)
						|| isAchievableFrom(remaining, board, row, column - 1, used)
						|| isAchievableFrom(remaining, board, row + 1, column, used)
						|| isAchievableFrom(remaining, board, row - 1, column, used)
						|| isAchievableFrom(remaining, board, row + 1, column + 1, used)
						|| isAchievableFrom(remaining, board, row + 1, column - 1, used)
						|| isAchievableFrom(remaining, board, row - 1, column - 1, used)
						|| isAchievableFrom(remaining, board, row - 1, column + 1, used)

		);
		used[row][column] = false;
		return result;
	}

	private static boolean safeArrCheck(char[][] board, int row, int column, char c) {
		try {
			return board[row][column] == c;
		} catch (ArrayIndexOutOfBoundsException exception) {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(boggleBoard(new char[][]{
				{'t', 'h', 'i', 's', 'i', 's', 'a'},
				{'s', 'i', 'm', 'p', 'l', 'e', 'x'},
				{'b', 'x', 'x', 'x', 'x', 'e', 'b'},
				{'x', 'o', 'g', 'g', 'l', 'x', 'o'},
				{'x', 'x', 'x', 'D', 'T', 'r', 'a'},
				{'R', 'E', 'P', 'E', 'A', 'd', 'x'},
				{'x', 'x', 'x', 'x', 'x', 'x', 'x'},
				{'N', 'O', 'T', 'R', 'E', '-', 'P'},
				{'x', 'x', 'D', 'E', 'T', 'A', 'E'}

		}, new String[]{
				"this",
				"is",
				"not",
				"a",
				"simple",
				"boggle",
				"board",
				"test",
				"REPEATED",
				"NOTRE-PEATED"
		}));
	}
}
