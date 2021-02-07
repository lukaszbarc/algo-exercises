package com.lbarc.aglo.exercises.expert.minheap;

public class MinimumBribes {

	static void minimumBribes(int[] q) {

		int sum = 0;
		for (int i = 0; i < q.length; i++) {

			int num = q[i];
			int part = 0;
			for (int j = i; j < Math.min(i + 100, q.length); j++) {
				if (q[j] < num) {
					part++;
					if (part > 2) {
						System.out.println("Too chaotic");
						return;
					}
				}
			}
			sum += part;
		}

		System.out.println(sum);
	}

	public static void main(String[] args) {
		minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4});
	}

}
