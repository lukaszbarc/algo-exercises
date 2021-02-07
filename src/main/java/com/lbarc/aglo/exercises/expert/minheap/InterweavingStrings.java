package com.lbarc.aglo.exercises.expert.minheap;

public class InterweavingStrings {

	public static boolean interweavingStrings(String one, String two, String three) {
		if (one.length() + two.length() != three.length()) {
			return false;
		}
		return interweavingStrings(one, 0, two, 0, three, 0);

	}

	private static boolean interweavingStrings(String one, int first, String two, int second, String three, int third) {
		boolean result = false;
		if (third == three.length()) {
			return true;
		}
		final Character oneChar = first < one.length() ? one.charAt(first) : null;
		final Character twoChar = second < two.length() ? two.charAt(second) : null;
		final Character threeChar = three.charAt(third);
		if (oneChar != twoChar) {
			if (oneChar == threeChar) {
				third++;
				first++;
			} else if (twoChar == threeChar) {
				third++;
				second++;
			} else {
				return false;
			}
			result |= interweavingStrings(one, first, two, second, three, third);
		}
		if (oneChar == twoChar) {
			result |= interweavingStrings(one, first + 1, two, second, three, third + 1);
			result |= interweavingStrings(one, first, two, second + 1, three, third + 1);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(interweavingStrings("algoexperta", "your-dream-jobb", "your-algodream-expertjobcd"));
	}
}
