package com.lbarc.aglo.exercises.maximumsubarray.kadanes;

import com.lbarc.aglo.exercises.maximumsubarray.MaximumSubarrayProblemResolver;
import java.util.Arrays;
import java.util.StringJoiner;

public class MaximumSubarrayKadanesProblemResolver implements MaximumSubarrayProblemResolver {

	@Override
	public int[] findMaximumSubarray(int[] array) {
		int maxSumLeft = 0;
		int maxSumRight = 0;
		int maxSumValue = 0;
		int left = 0;
		int currentSumValue = 0;
		for (int i = 0; i < array.length; i++) {
			currentSumValue += array[i];
			if (currentSumValue < 0) {
				currentSumValue = 0;
				left = i + 1;
			}
			if (currentSumValue > maxSumValue) {
				maxSumValue = currentSumValue;
				maxSumLeft = left;
				maxSumRight = i;
			}
		}
		return Arrays.copyOfRange(array, maxSumLeft, maxSumRight + 1);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", MaximumSubarrayKadanesProblemResolver.class.getSimpleName() + "[", "]")
				.toString();
	}
}
