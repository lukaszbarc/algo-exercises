package com.lbarc.aglo.exercises.algoexpert.maxprofitwithktransactions;

public class Program {

	public static int maxProfitWithKTransactions(int[] prices, int k) {
		if (prices.length == 0 || k == 0) {
			return 0;
		}
		int[][] dd = new int[k + 1][prices.length];

		for (int i = 1; i <= k; i++) {
			for (int j = 1; j < prices.length; j++) {
				int current = dd[i][j - 1];

				int max = Integer.MIN_VALUE;
				for (int x = j; x >= 0; x--) {
					max = Math.max(max, (prices[j] + (-1 * prices[x]) + dd[i - 1][x]));
				}
				dd[i][j] = Math.max(max, current);
			}
		}

		return dd[k][prices.length - 1];
	}

	public static void main(String[] args) {
		Program.maxProfitWithKTransactions(new int[]{5, 11, 3, 50, 60, 90}, 2);
	}
}
