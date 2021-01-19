package com.lbarc.aglo.exercises.crackingcodeinterview.arraysandstrings;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 *
 * Questions to ask:
 * 		- character set size
 * 		- is it allowed to use different data structure
 */
public class IsUnique {


	static boolean hasOnlyUniqueChars(String str) {
		if (str.length() > 65_536) {
			return false;
		}
		boolean[] charset = new boolean[65_536];
		for (char c : str.toCharArray()) {
			if (charset[c]) {
				return false;
			}
			charset[c] = true;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(hasOnlyUniqueChars("abcd efrtyui"));
		System.out.println(hasOnlyUniqueChars("abcde frtyuii"));
	}
}
