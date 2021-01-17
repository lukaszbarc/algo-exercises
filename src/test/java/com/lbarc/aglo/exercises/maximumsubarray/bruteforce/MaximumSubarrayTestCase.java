package com.lbarc.aglo.exercises.maximumsubarray.bruteforce;

import java.util.Arrays;
import java.util.StringJoiner;

class MaximumSubarrayTestCase {

	private final int[] testData;

	private final int[] expectedAnswer;

	public MaximumSubarrayTestCase(int[] testData, int[] expectedAnswer) {
		this.testData = testData;
		this.expectedAnswer = expectedAnswer;
	}

	public int[] getTestData() {
		return testData;
	}

	public void validate(int[] result) {
		try {
			assert result.length == expectedAnswer.length;
			for (int i = 0; i < result.length; i++) {
				assert result[i] == expectedAnswer[i];
			}
			System.out.println("OK");
		} catch (AssertionError assertionError) {
			System.out.println("Expected: " + Arrays.toString(expectedAnswer));
			System.out.println("Actual: " + Arrays.toString(result));
		}
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", MaximumSubarrayTestCase.class.getSimpleName() + "[", "]")
				.add("testData=" + Arrays.toString(testData))
				.add("expectedAnswer=" + Arrays.toString(expectedAnswer))
				.toString();
	}
}
