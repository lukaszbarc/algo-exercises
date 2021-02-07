package com.lbarc.aglo.exercises.expert.minheap;

public class MinimumSwaps2 {

	// Complete the minimumSwaps function below.
	static int minimumSwaps(int[] arr) {
		int swaps = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == i + 1) {
				continue;
			}
			for (int j = i; j < arr.length; j++) {
				if (arr[j] == i + 1) {
					swaps++;
					int tmp = arr[i];
					arr[i] = i + 1;
					arr[j] = tmp;
					break;
				}
			}
		}
		return swaps;
	}

	public static void main(String[] args) {
		System.out.println(minimumSwaps(new int[]{2,3,4,1,5}));
	}

}
