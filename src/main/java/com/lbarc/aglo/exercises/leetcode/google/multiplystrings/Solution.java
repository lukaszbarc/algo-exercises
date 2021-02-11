package com.lbarc.aglo.exercises.leetcode.google.multiplystrings;

public class Solution {

	public String multiply(String num1, String num2) {
		char[] a = num1.length() > num2.length() ? num1.toCharArray() : num2.toCharArray(); // a is longer
		char[] b = num1.length() > num2.length() ? num2.toCharArray() : num1.toCharArray(); // b is shorter

		char[][] components = new char[b.length][];

		for (int i = 0; i < b.length; i++) {
			int bI = toInt(b, b.length - 1 - i);
			int carry = 0;
			int[] c = new int[a.length + 1 + i];
			for (int j = 0; j < a.length; j++) {
				int aI = toInt(a, a.length - 1 - j);
				int cI = (aI * bI) + carry;
				carry = cI / 10;
				cI = cI % 10;
				c[c.length - 1 - j - i] = cI;
			}
			if (carry > 0) {
				c[0] = carry;
			}

			components[i] = new char[c.length];
			for (int j = 0; j < components[i].length; j++) {
				components[i][j] = (char) ('0' + c[j]);
			}
		}

		if (components.length == 1) {
			return trimLeadingZeros(String.valueOf(components[0]));
		} else {
			String sum = "0";
			for (char[] component : components) {
				sum = add(sum, String.valueOf(component));
			}
			return trimLeadingZeros(sum);

		}
	}

	public String trimLeadingZeros(String s) {
		char[] arr = s.toCharArray();
		for (int i = 0; i < s.length() - 1; i++) {
			if (arr[i] == '0') {
				arr[i] = ' ';
			} else {
				break;
			}
		}
		return String.valueOf(arr).trim();
	}

	private String add(String num1, String num2) {
		char[] a = num1.toCharArray();
		char[] b = num2.toCharArray();

		char[] c = new char[Math.max(a.length, b.length) + 1];

		int carry = 0;

		for (int i = 0; i < c.length; i++) {
			int aI = toInt(a, a.length - 1 - i);
			int bI = toInt(b, b.length - 1 - i);

			int cI = aI + bI + carry;
			carry = cI / 10;
			cI = cI % 10;

			c[c.length - 1 - i] = String.valueOf(cI).charAt(0);
		}

		return String.valueOf(c);
	}

	private int toInt(char[] arr, int idx) {
		try {
			return Integer.parseInt(String.valueOf(arr[idx]));
		} catch (ArrayIndexOutOfBoundsException exception) {
			return 0;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().multiply("0", "0"));
	}
}
