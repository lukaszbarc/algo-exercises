package com.lbarc.aglo.exercises.expert.minheap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DiskStacking {

	public static List<Integer[]> diskStacking(List<Integer[]> arg1) {

		final List<Integer[]> disks = new ArrayList<>(arg1);

		disks.sort(Comparator.comparing(a -> a[2]));

		int[] maxHeight = new int[disks.size()];
		int[] sequence = new int[disks.size()];

		for (int i = 0; i < disks.size(); i++) {
			maxHeight[i] = disks.get(i)[2];
			sequence[i] = i;
		}

		for (int i = 0; i < maxHeight.length; i++) {
			final Integer[] current = disks.get(i);
			for (int j = 0; j < i; j++) {
				final Integer[] other = disks.get(j);
				if (other[0] < current[0] && other[1] < current[1] && other[2] < current[2]) {
					int currentMax = maxHeight[i];
					int otherMax = maxHeight[j] + current[2];
					if (currentMax < otherMax) {
						sequence[i] = j;
					}
					maxHeight[i] = Math.max(currentMax, otherMax);
				}
			}
		}

		int max = 0;
		int maxIdx = 0;
		for (int i = 0; i < maxHeight.length; i++) {
			if (maxHeight[i] > max) {
				max = maxHeight[i];
				maxIdx = i;
			}
		}

		final List<Integer[]> result = new ArrayList<>();
		int currentIdx = maxIdx;
		while (true) {
			result.add(disks.get(currentIdx));
			if (currentIdx == sequence[currentIdx]) {
				break;
			}
			currentIdx = sequence[currentIdx];
		}

		Collections.reverse(result);
		return result;
	}

	public static void main(String[] args) {
		diskStacking(Arrays.asList(
				new Integer[]{2, 1, 2},
				new Integer[]{3, 2, 3},
				new Integer[]{2, 2, 8},
				new Integer[]{2, 3, 4},
				new Integer[]{1, 3, 1},
				new Integer[]{4, 4, 5}
		));
	}

}
