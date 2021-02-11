package com.lbarc.aglo.exercises.codeforces.waytoolongwords;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int words = in.nextInt();
			for (int i = 0; i < words; i++) {
				System.out.println(solve(in.next()));
			}
		}
	}

	private static String solve(String line) {
		if (line.length() > 10) {
			return String.valueOf(
					line.charAt(0)) +
					(line.length() - 2) +
					line.charAt(line.length() - 1);
		} else {
			return line;
		}
	}
}
