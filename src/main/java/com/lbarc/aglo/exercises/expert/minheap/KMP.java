package com.lbarc.aglo.exercises.expert.minheap;

import java.util.Arrays;

public class KMP {

	public static boolean knuthMorrisPrattAlgorithm(String string, String substring) {
		int[] pattern = pattern(substring);
		return checkIfMatchPattern(string, substring, pattern);
	}

	private static boolean checkIfMatchPattern(String string, String substring, int[] pattern) {
		final char[] str = string.toCharArray();
		final char[] substr = substring.toCharArray();

		int i = 0;
		int j = 0;
		while (i < str.length) {
			if(str[i] == substr[j]) {
				if(j == pattern.length - 1) {
					return true;
				}
				j++;
				i++;
			} else if (j > 0) {
				j = pattern[j-1] + 1;
			} else {
				i++;
			}
		}
		return false;
	}

	private static int[] pattern(String string) {
		int result[] = new int[string.length()];
		Arrays.fill(result, -1);
		int j = 0;
		int i = 1;
		while (i < string.length()) {
			if (string.charAt(j) == string.charAt(i)) {
				result[i] = j;
				i++;
				j++;
			} else if (j > 0) {
				j = result[j - 1] + 1;
			} else {
				i++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(knuthMorrisPrattAlgorithm("aaassaefaedaefadaefaefaasasa", "aefaedaefaefa"));

		"sss".contains("sss");
	}

}
