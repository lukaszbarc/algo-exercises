package com.lbarc.aglo.exercises.algoexpert.largestrange;

import java.util.HashSet;
import java.util.Set;

public class Program {

	static class Range {

		int start;

		int end;

		public Range(int start, int end) {
			this.start = start;
			this.end = end;
		}

		boolean isWithin(int number) {
			return number >= start && number <= end;
		}

		int size() {
			return end - start + 1;
		}
	}

	public static int[] largestRange(int[] array) {
		final Set<Integer> uniqueNumbers = new HashSet<>();
		for (int i : array) {
			uniqueNumbers.add(i);
		}

		Range result = new Range(array[0], array[0]);
		for (int number : array) {
			if (result.isWithin(number)) {
				continue;
			}
			int start = number;
			int end = number;
			while (uniqueNumbers.contains(start - 1)) {
				start--;
			}
			while (uniqueNumbers.contains(end + 1)) {
				end++;
			}
			Range current = new Range(start, end);
			if (current.size() > result.size()) {
				result = current;
			}
		}
		return new int[]{result.start, result.end};
	}

	public static void main(String[] args) {
		largestRange(new int[]{1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6});
	}

}
