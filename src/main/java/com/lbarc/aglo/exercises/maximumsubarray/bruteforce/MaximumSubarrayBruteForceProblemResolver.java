package com.lbarc.aglo.exercises.maximumsubarray.bruteforce;

import com.lbarc.aglo.exercises.maximumsubarray.MaximumSubarrayProblemResolver;
import java.util.Arrays;
import java.util.StringJoiner;

public class MaximumSubarrayBruteForceProblemResolver implements MaximumSubarrayProblemResolver {

	@Override
	public int[] findMaximumSubarray(int[] array) {
		int maximum = Integer.MIN_VALUE;
		int bestLeft = -1;
		int bestRight = -1;
		for (int left = 0; left < array.length; left++) {
			int sum = 0;
			for (int right = left; right < array.length; right++) {
				sum += array[right];
				if (sum > maximum) {
					maximum = sum;
					bestLeft = left;
					bestRight = right;
				}
			}
		}
		return Arrays.copyOfRange(array, bestLeft, bestRight + 1);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", MaximumSubarrayBruteForceProblemResolver.class.getSimpleName() + "[", "]")
				.toString();
	}
}
