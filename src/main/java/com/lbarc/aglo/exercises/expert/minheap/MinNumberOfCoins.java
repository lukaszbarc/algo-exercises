package com.lbarc.aglo.exercises.expert.minheap;

import java.util.Arrays;

public class MinNumberOfCoins {

	public static int minNumberOfCoinsForChange(int n, int[] denoms) {
		int nn[] = new int[n + 1];
		Arrays.fill(nn, Integer.MAX_VALUE);
		nn[0] = 0;

		for (int denom : denoms) {
			for (int i = denom; i < nn.length; i++) {
				if (nn[i - denom] == Integer.MAX_VALUE) {
					nn[i] = Math.min(nn[i], nn[i - denom]);
				} else {
					nn[i] = Math.min(nn[i], nn[i - denom] + 1);
				}
			}
		}
		return nn[n];
	}

	public static void main(String[] args) {

		System.out.println(minNumberOfCoinsForChange(10, new int[]{1, 3, 4}));

	}

}
