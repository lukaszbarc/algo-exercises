package com.lbarc.aglo.exercises.expert.minheap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SumIncreasing {

	public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
		int sums[] = new int[array.length];
		int indexes[] = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			sums[i] = array[i];
			indexes[i] = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (array[j] < array[i]) {
					if (sums[j] + array[i] > sums[i]) {
						sums[i] = sums[j] + array[i];
						indexes[i] = j;
					}
				}
			}
		}

		int highestValue = 0;
		int highestValueIdx = 0;
		for (int i = 0; i < sums.length; i++) {
			if (sums[i] > highestValue) {
				highestValue = sums[i];
				highestValueIdx = i;
			}
		}

		final List<Integer> r2 = new ArrayList<>();
		int idx = highestValueIdx;
		r2.add(array[idx]);
		while (true) {
			idx = indexes[idx];
			if (idx >= 0) {
				r2.add(array[idx]);
			}
			if (idx == 0) {
				break;
			}
		}

		Collections.sort(r2);

		final List<List<Integer>> result = new ArrayList<>();
		final List<Integer> r1 = new ArrayList<>();
		r1.add(highestValue);
		result.add(r1);
		result.add(r2);
		return result;
	}

	public static void main(String[] args) {
		maxSumIncreasingSubsequence(new int[]{10, 70, 20, 30, 50, 11, 30});
	}
}
