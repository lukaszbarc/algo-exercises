package com.lbarc.aglo.exercises.expert.minheap;

public class MakingAnagrams {

	// Complete the makeAnagram function below.
	static int makeAnagram(String a, String b) {
		int[] freq = new int['z' - 'a' + 1];

		for (char c : a.toCharArray()) {
			freq[c - 'a']++;
		}

		for (char c : b.toCharArray()) {
			freq[c - 'a']--;
		}

		int sum = 0;
		for (int i : freq) {
			sum += Math.abs(i);
		}
		return sum;
	}

	public static void main(String[] args) {
		makeAnagram("cde", "abc");
	}
}
