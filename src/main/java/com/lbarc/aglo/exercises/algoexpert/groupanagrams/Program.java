package com.lbarc.aglo.exercises.algoexpert.groupanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

	public static List<List<String>> groupAnagrams(List<String> words) {
		final Map<String, List<String>> anagrams = new HashMap<>();

		for (String word : words) {
			char[] arr = word.toCharArray();
			Arrays.sort(arr);
			final String key = String.valueOf(arr);
			anagrams.computeIfAbsent(key, (a) -> new ArrayList<>());
			anagrams.get(key).add(word);
		}
		return new ArrayList<>(anagrams.values());
	}

}
