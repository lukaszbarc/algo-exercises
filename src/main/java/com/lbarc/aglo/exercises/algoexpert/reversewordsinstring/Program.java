package com.lbarc.aglo.exercises.algoexpert.reversewordsinstring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {

	public String reverseWordsInString(String string) {
		List<String> words = new ArrayList<>();

		int start = 0;
		char[] chars = string.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				words.add(string.substring(start, i));
				start = i;
			} else if (chars[start] == ' ') {
				words.add(" ");
				start = i;
			}
		}

		words.add(string.substring(start));
		Collections.reverse(words);

		return String.join("", words);
	}

	public static void main(String[] args) {
		System.out.println("'" + new Program().reverseWordsInString("AlgoExpert     is the best!") + "'");
	}

}
