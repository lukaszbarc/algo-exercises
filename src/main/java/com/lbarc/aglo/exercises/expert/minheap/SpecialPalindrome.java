package com.lbarc.aglo.exercises.expert.minheap;

import java.util.ArrayList;
import java.util.List;

public class SpecialPalindrome {

	static class Foo {

		int number;

		char c;

		public Foo(int number, char c) {
			this.number = number;
			this.c = c;
		}
	}

	// Complete the substrCount function below.
	static long substrCount(int n, String s) {
		final char[] chars = s.toCharArray();

		final List<Foo> normalized = new ArrayList<>();
		int counter = 1;
		for (int i = 0; i < chars.length - 1; i++) {
			if (chars[i] == chars[i + 1]) {
				counter++;
			} else {
				normalized.add(new Foo(counter, chars[i]));
				counter = 1;
			}
		}
		normalized.add(new Foo(counter, chars[chars.length - 1]));

		int sum = s.length();
		for (Foo foo : normalized) {
			if (foo.number > 1) {
				sum += ((foo.number * (foo.number + 1)) / 2) - foo.number;
			}
		}
		for (int i = 0; i < normalized.size() - 2; i++) {
			final Foo f1 = normalized.get(i);
			final Foo f2 = normalized.get(i + 1);
			final Foo f3 = normalized.get(i + 2);
			if (f1.c == f3.c && f2.number == 1) {
//				sum += Math.min(f1.number, f2.number);
				sum += 1;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(substrCount(10, "mnonopoo"));
		System.out.println(substrCount(10, "aaaabaa"));
	}

}
