package com.lbarc.aglo.exercises.expert.minheap;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RansomNote {

	// Complete the checkMagazine function below.
	static void checkMagazine(String[] magazine, String[] note) {
		final Map<String, Long> words = Arrays.stream(magazine)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		for (String s : note) {
			Long aLong = words.get(s);
			if (aLong == null || aLong == 0) {
				System.out.println("No");
				return;
			}
			words.replace(s, aLong - 1);
		}
		System.out.println("Yes");
	}

}
