package com.lbarc.aglo.exercises.maximumsubarray.bruteforce;

import com.lbarc.aglo.exercises.maximumsubarray.MaximumSubarrayProblemResolver;
import com.lbarc.aglo.exercises.maximumsubarray.divideandconquer.MaximumSubarrayDivideAndConquerProblemResolver;
import com.lbarc.aglo.exercises.maximumsubarray.kadanes.MaximumSubarrayKadanesProblemResolver;
import java.util.Random;

class MaximumSubarrayBruteForceProblemResolverTest {

	private static Random RANDOM = new Random();

	private static MaximumSubarrayTestCase[] TEST_CASES = new MaximumSubarrayTestCase[]{
			new MaximumSubarrayTestCase(new int[]{-11, 22, 33, -90, 56}, new int[]{56}),
			new MaximumSubarrayTestCase(new int[]{-11, 22, 33, -90}, new int[]{22, 33}),
			new MaximumSubarrayTestCase(new int[]{11, 12, 13, 14, -90, 20, 20}, new int[]{11, 12, 13, 14}),
			new MaximumSubarrayTestCase(new int[]{11, 12, 13, -150, 150, 14, -90, 20, 20}, new int[]{150, 14}),
	};

	private static final MaximumSubarrayProblemResolver[] RESOLVERS = new MaximumSubarrayProblemResolver[]{
			new MaximumSubarrayKadanesProblemResolver(),
			new MaximumSubarrayDivideAndConquerProblemResolver(),
			new MaximumSubarrayBruteForceProblemResolver()
	};

	/**
	 * Remember to run with -ea flag to enable assertions
	 */
	public static void main(String[] args) {
		// Validate against predefined test cases
		for (MaximumSubarrayTestCase testCase : TEST_CASES) {
			System.out.println("=============================");
			System.out.println("TestCase: " + testCase);
			for (MaximumSubarrayProblemResolver resolver : RESOLVERS) {
				final long start = System.nanoTime();
				for (int i = 0; i < 50_000; i++) {
					resolver.findMaximumSubarray(testCase.getTestData());
				}
				final int[] maximumSubarray = resolver.findMaximumSubarray(testCase.getTestData());
				System.out.printf("Resolver: %s, problem solved in %dns.%n", resolver, (System.nanoTime() - start) / 50_001);
				testCase.validate(maximumSubarray);
			}
		}

		// Validate each other against random test case
		System.out.println("=============================");
		System.out.println("Random TestCase");
		final MaximumSubarrayTestCase randomTestCase = generateRandomTestCase(250_000);
		for (MaximumSubarrayProblemResolver resolver : RESOLVERS) {
			final long start = System.currentTimeMillis();
			final int[] maximumSubarray = resolver.findMaximumSubarray(randomTestCase.getTestData());
			System.out.printf("Resolver: %s, problem solved in %dms.%n", resolver, (System.currentTimeMillis() - start));
			randomTestCase.validate(maximumSubarray);
		}

	}

	private static MaximumSubarrayTestCase generateRandomTestCase(int dataSetSize) {
		final int[] testData = new int[dataSetSize];
		for (int i = 0; i < dataSetSize; i++) {
			testData[i] = RANDOM.nextInt(dataSetSize * 10) - (dataSetSize * 5);
		}
		// lets use fastest one to generate solution
		final int[] expectedResult = new MaximumSubarrayKadanesProblemResolver().findMaximumSubarray(testData);
		return new MaximumSubarrayTestCase(testData, expectedResult);
	}

}