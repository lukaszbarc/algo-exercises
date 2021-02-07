package com.lbarc.aglo.exercises.expert.minheap;

public class MinNumberOfJumps {

	public static int minNumberOfJumps(int[] array) {
		int tmp[] = new int[array.length];
		tmp[array.length - 1] = 0;

		for (int i = tmp.length - 2; i >= 0; i--) {
			int maxJump = array[i];
			int min = Integer.MAX_VALUE;
			for (int j = i+1; j < array.length && (j - i) <= maxJump; j++) {
				min = Math.min(tmp[j], min);
			}
			tmp[i] = min + 1;
		}
		return tmp[0];
	}

	public static void main(String[] args) {
		System.out.println(minNumberOfJumps(new int[]{3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3}));
	}
}
