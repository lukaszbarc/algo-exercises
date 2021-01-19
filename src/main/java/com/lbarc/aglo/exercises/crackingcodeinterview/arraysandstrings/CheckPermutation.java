package com.lbarc.aglo.exercises.crackingcodeinterview.arraysandstrings;

import java.util.Arrays;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class CheckPermutation {

	static boolean isPermutation(String s1, String s2) {
		final String sorted1 = sort(s1);
		final String sorted2 = sort(s2);
		return sorted1.equals(sorted2);
	}

	private static String sort(String s) {
		final char[] array = s.toCharArray();
		Arrays.sort(array);
		return String.copyValueOf(array);
	}

	public static void main(String[] args) {
		System.out.println(isPermutation("abcde", "cedba"));
		System.out.println(isPermutation("abc", "abd"));

	}

}
