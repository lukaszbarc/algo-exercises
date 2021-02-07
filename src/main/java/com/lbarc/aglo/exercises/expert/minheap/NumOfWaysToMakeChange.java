package com.lbarc.aglo.exercises.expert.minheap;

import java.util.Arrays;
import java.util.Collections;

public class NumOfWaysToMakeChange {

	public static int numberOfWaysToMakeChange(int n, int[] denoms) {
		if (n == 0) {
			return 1;
		}
		int nn[] = new int[n+1];
		nn[0] = 1;

		Arrays.sort(denoms);
		for (int denom : denoms) {
			for (int i = denom; i < n+1; i++) {
				if (i >= denom) {
					nn[i] += nn[i - denom];
				}
			}
		}
		return nn[n - 1];
	}

	public static void main(String[] args) {
		numberOfWaysToMakeChange(5, new int[]{1, 5, 10, 25});
	}
}
