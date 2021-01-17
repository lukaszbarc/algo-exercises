package com.lbarc.aglo.exercises.maximumsubarray.divideandconquer;

import com.lbarc.aglo.exercises.maximumsubarray.MaximumSubarrayProblemResolver;
import java.util.Arrays;
import java.util.StringJoiner;

public class MaximumSubarrayDivideAndConquerProblemResolver implements MaximumSubarrayProblemResolver {

	@Override
	public int[] findMaximumSubarray(int[] array) {
		final int[] maxArrayData = findMaximumSubarray(array, 0, array.length - 1);
		return Arrays.copyOfRange(array, maxArrayData[0], maxArrayData[1] + 1);
	}

	private int[] findMaximumSubarray(int[] array, int low, int high) {
		if (high == low) {
			return new int[]{low, high, array[low]};
		} else {
			int mid = (low + high) / 2;
			int[] leftMax = findMaximumSubarray(array, low, mid);
			int[] rightMax = findMaximumSubarray(array, mid + 1, high);
			int[] crossingMax = maxCrossingSubarray(array, low, mid, high);

			if (leftMax[2] >= rightMax[2] && leftMax[2] >= crossingMax[2]) {
				return leftMax;
			} else if (rightMax[2] >= leftMax[2] && rightMax[2] >= crossingMax[2]) {
				return rightMax;
			} else {
				return crossingMax;
			}
		}
	}

	private int[] maxCrossingSubarray(int[] array, int low, int mid, int high) {
		int leftSum = Integer.MIN_VALUE;
		int maxLeft = mid;
		int sum = 0;
		for (int i = mid; i >= low; i--) {
			sum += array[i];
			if (sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
			}
		}

		int rightSum = Integer.MIN_VALUE;
		int maxRight = mid + 1;
		sum = 0;
		for (int i = mid + 1; i <= high; i++) {
			sum += array[i];
			if (sum > rightSum) {
				rightSum = sum;
				maxRight = i;
			}
		}
		return new int[]{maxLeft, maxRight, leftSum + rightSum};
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", MaximumSubarrayDivideAndConquerProblemResolver.class.getSimpleName() + "[", "]")
				.toString();
	}
}
