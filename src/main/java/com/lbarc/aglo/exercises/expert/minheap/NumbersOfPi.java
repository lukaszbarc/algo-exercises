package com.lbarc.aglo.exercises.expert.minheap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumbersOfPi {

	public static int numbersInPi(String pi, String[] numbers) {
		final int result = numbersInPi(pi, new HashSet<>(Arrays.asList(numbers)));
		return result == Integer.MAX_VALUE ? -1 : result;
	}

	private static int numbersInPi(String pi, Set<String> numbersSet) {
		System.out.println("pi: " + pi);
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= pi.length(); i++) {
			final String number = pi.substring(0, i);
			if (numbersSet.contains(number)) {
				if (number.length() == pi.length()) {
					return 0;
				}
				final int sub = numbersInPi(pi.substring(i), numbersSet);
				if (sub != Integer.MAX_VALUE) {
					min = Math.min(min, 1 + sub);
				}
			}
		}
		return min;
	}

	public static void main(String[] args) {
		System.out.println(numbersInPi("3141592653589793238462643383279", new String[]{
				"141592653589793238462643383279",
				"314159265358979323846",
				"327",
				"26433",
				"8",
				"3279",
				"9",
				"314159265",
				"35897932384626433832",
				"79",
				"3"
		}));
	}
}
