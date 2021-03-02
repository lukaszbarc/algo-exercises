package com.lbarc.aglo.exercises.algoexpert.patternmatcher;

public class Program {

	public static void main(String[] args) {
		patternMatcher("yyyy", "testtesttesttest");
	}

	public static String[] patternMatcher(String pattern, String str) {
		char[] normalizedPattern = normalizePattern(pattern);
		int len = str.length();
		int numX = 0;
		int numY = 0;
		for (char c : normalizedPattern) {
			if (c == 'y') {
				numY++;
			} else {
				numX++;
			}
		}
		int xLen = 0;

		while (xLen < len) {
			xLen++;
			int yLen = numY == 0 ? 0 : (len - (xLen * numX)) / numY;
			if ((xLen * numX) + (yLen * numY) != len || yLen < 0) {
				continue;
			}
			char[] x = new char[xLen];
			boolean xSet = false;
			char[] y = new char[yLen];
			boolean ySet = false;
			int idx = 0;
			boolean result = true;
			for (int i = 0; i < normalizedPattern.length; i++) {
				if (!result) {
					break;
				}
				char xy = normalizedPattern[i];
				if (xy == 'x') {
					for (int j = 0; j < xLen; j++) {
						if (!xSet) {
							x[j] = str.charAt(idx);
						} else {
							if (x[j] != str.charAt(idx)) {
								result = false;
							}
						}
						idx++;
					}
					xSet = true;
				} else {
					for (int j = 0; j < yLen; j++) {
						if (!ySet) {
							y[j] = str.charAt(idx);
						} else {
							if (y[j] != str.charAt(idx)) {
								result = false;
							}
						}
						idx++;
					}
					ySet = true;
				}
			}
			if (result) {
				return pattern.charAt(0) == normalizedPattern[0] ?
						new String[]{String.valueOf(x), String.valueOf(y)}
						: new String[]{String.valueOf(y), String.valueOf(x)};
			}

		}

		return new String[]{};
	}

	private static char[] normalizePattern(String pattern) {
		char[] result = new char[pattern.length()];

		boolean replace = pattern.charAt(0) == 'y';

		for (int i = 0; i < result.length; i++) {
			char c = pattern.charAt(i);
			if (replace) {
				c = c == 'y' ? 'x' : 'y';
			}
			result[i] = c;

		}
		return result;
	}

}
