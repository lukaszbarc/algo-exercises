package com.lbarc.aglo.exercises.expert.minheap;

public class ArrayManipulation {

	static long arrayManipulation(int n, int[][] qq) {
		long[] nn = new long[n + 1];
		for (int[] q : qq) {
			nn[q[0] - 1] += q[2];
			nn[q[1]] -= q[2];
		}
		long max = 0;
		long current = 0;
		for (long i : nn) {
			current += i;
			if (current > max) {
				max = current;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		arrayManipulation(10, new int[][]{
				{1, 5, 3},
				{4, 8, 7},
				{6, 9, 1},
		});
	}
}
