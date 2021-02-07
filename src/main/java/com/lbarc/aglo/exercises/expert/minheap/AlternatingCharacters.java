package com.lbarc.aglo.exercises.expert.minheap;

public class AlternatingCharacters {

	// Complete the alternatingCharacters function below.
	static int alternatingCharacters(String s) {
		if (s.length() == 0) {
			return 0;
		}
		char[] chars = s.toCharArray();
		char currentChar = chars[0];
		int deletions = 0;
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] != currentChar) {
				currentChar = chars[i];
			} else {
				deletions++;
			}
		}
		return deletions;
	}
}
