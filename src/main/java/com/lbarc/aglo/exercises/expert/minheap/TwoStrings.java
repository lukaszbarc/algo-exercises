package com.lbarc.aglo.exercises.expert.minheap;

import java.util.HashSet;
import java.util.Set;

public class TwoStrings {

	static String twoStrings(String s1, String s2) {
		Set<Character> s1Chars = new HashSet<>();
		Set<Character> s2Chars = new HashSet<>();
		for (char c : s1.toCharArray()) {
			s1Chars.add(c);
		}
		for (char c : s2.toCharArray()) {
			s2Chars.add(c);
		}
		s1Chars.retainAll(s2Chars);
		return s1Chars.isEmpty() ? "NO" : "YES";
	}

}
