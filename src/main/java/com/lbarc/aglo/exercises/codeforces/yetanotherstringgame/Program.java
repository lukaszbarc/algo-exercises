package com.lbarc.aglo.exercises.codeforces.yetanotherstringgame;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int words = in.nextInt();
			String[] w = new String[words];
			for (int i = 0; i < words; i++) {
				w[i] = in.next();
			}

			for (String s : w) {
				System.out.println(solve(s));
			}

		}
	}

	private static String solve(String line) {
		char[] chars = line.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			if (i % 2 == 0) {
				chars[i] = chars[i] == 'a' ? 'b' : 'a';
			} else {
				chars[i] = chars[i] == 'z' ? 'y' : 'z';
			}
		}

		return String.valueOf(chars);
	}
}
