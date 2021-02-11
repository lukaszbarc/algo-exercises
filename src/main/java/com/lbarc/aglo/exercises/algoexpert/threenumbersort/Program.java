package com.lbarc.aglo.exercises.algoexpert.threenumbersort;

public class Program {

	public int[] threeNumberSort(int[] array, int[] order) {
		int[] counts = new int[3];

		for (int i : array) {
			if (i == order[0]) {
				counts[0]++;
			}
			if (i == order[1]) {
				counts[1]++;
			}
			if (i == order[2]) {
				counts[2]++;
			}
		}

		for (int i = 0; i < array.length; i++) {
			if (counts[0] > 0) {
				array[i] = order[0];
				counts[0]--;
			} else if (counts[1] > 0) {
				array[i] = order[1];
				counts[1]--;
			} else if (counts[2] > 0) {
				array[i] = order[2];
				counts[2]--;
			}
		}
		return array;

	}

}
