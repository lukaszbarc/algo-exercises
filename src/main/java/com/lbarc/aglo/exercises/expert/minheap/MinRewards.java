package com.lbarc.aglo.exercises.expert.minheap;

public class MinRewards {

	public static int minRewards(int[] scores) {
		int[] rewards = new int[scores.length];

		int localMaxIdx = 0;
		rewards[0] = 1;
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] < scores[i - 1]) {
				int a = i;
				while (a >= localMaxIdx) {
					rewards[a] = rewards[a] + 1;
					a--;
					if (a >= 0 && rewards[a] > rewards[a + 1]) {
						break;
					}
				}
			} else {
				localMaxIdx = i;
				rewards[localMaxIdx] = rewards[localMaxIdx - 1] + 1;

			}
		}

		int sum = 0;
		for(Integer reward : rewards) {
			sum += reward;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(minRewards(new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5}));
	}
}
