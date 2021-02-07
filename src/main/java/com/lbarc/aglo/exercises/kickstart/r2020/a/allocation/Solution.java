package com.lbarc.aglo.exercises.kickstart.r2020.a.allocation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try (final Scanner input = new Scanner(new BufferedReader(new InputStreamReader((System.in))))) {
			final int testCasesCount = input.nextInt();
			for (int testCase = 0; testCase < testCasesCount; testCase++) {
				int housesCount = input.nextInt();
				int budget = input.nextInt();
				int[] housePrices = new int[housesCount];
				for (int i = 0; i < housesCount; i++) {
					housePrices[i] = input.nextInt();
				}
				final int result = solve(housePrices, budget);
				System.out.printf("Case #%d: %d%n", testCase + 1, result);
			}
		}
	}

	private static int solve(int[] housePrices, int budget) {
		Arrays.sort(housePrices);
		int result = 0;
		for (int i = 0; i < housePrices.length; i++) {
			budget -= housePrices[i];
			if (budget >= 0) {
				result++;
			} else {
				break;
			}
		}
		return result;
	}
}
