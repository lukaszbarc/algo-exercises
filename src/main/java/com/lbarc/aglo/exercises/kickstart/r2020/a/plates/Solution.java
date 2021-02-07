package com.lbarc.aglo.exercises.kickstart.r2020.a.plates;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

//		solve(new int[][]{
//				{80, 80},
//				{15, 50},
//				{20, 10}
//
//		}, 2);

		try (final Scanner input = new Scanner(new BufferedReader(new InputStreamReader((System.in))))) {
			final int testCasesCount = input.nextInt();
			for (int testCase = 0; testCase < testCasesCount; testCase++) {
				int stacksCount = input.nextInt();
				int stackSize = input.nextInt();
				int platesToTake = input.nextInt();

				int[][] stacks = new int[stacksCount][stackSize];
				for (int i = 0; i < stacksCount; i++) {
					for (int j = 0; j < stackSize; j++) {
						stacks[i][j] = input.nextInt();
					}
				}
				final int result = solve(stacks, platesToTake);
				System.out.printf("Case #%d: %d%n", testCase + 1, result);
			}
		}
	}

	public static int solve(int[][] plateStacks, int platesToTake) {
		if (platesToTake == 0) {
			return 0;
		}
		final int platesInStack = plateStacks[0].length;
		final int[][] stacksScore = new int[plateStacks.length][platesToTake + 1];

		for (int stack = 0; stack < plateStacks.length; stack++) {
			for (int plate = 1; plate <= platesToTake; plate++) {
				if (plate == 1) {
					stacksScore[stack][plate] = plateStacks[stack][plate - 1];
				} else if (plate > platesInStack) {
					stacksScore[stack][plate] = stacksScore[stack][platesInStack];
				} else {
					stacksScore[stack][plate] = stacksScore[stack][plate - 1] + plateStacks[stack][plate - 1];
				}
			}
		}

		final int[][] dp = new int[plateStacks.length][platesToTake + 1];

		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = stacksScore[0][i];
		}

		for (int row = 1; row < dp.length; row++) {
			for (int column = 0; column <= platesToTake; column++) {
				dp[row][column] = Math.max(stacksScore[row][column], dp[row - 1][column]);
				for (int i = 0; i < column; i++) {
					int prev = dp[row - 1][i];
					int curr = stacksScore[row][column - i];
					dp[row][column] = Math.max(dp[row][column], prev + curr);
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}
}
