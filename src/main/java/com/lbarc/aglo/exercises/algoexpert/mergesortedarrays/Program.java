package com.lbarc.aglo.exercises.algoexpert.mergesortedarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

	public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
		int indexes[] = new int[arrays.size()];
		int size = arrays.stream().mapToInt(a -> a.size()).sum();

		final List<Integer> result = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			int min = Integer.MAX_VALUE;
			int minIdx = -1;
			for (int j = 0; j < indexes.length; j++) {
				if (indexes[j] != -1) {
					List<Integer> arr = arrays.get(j);
					if (min > arr.get(indexes[j])) {
						min = arr.get(indexes[j]);
						minIdx = j;
					}
				}
			}
			result.add(arrays.get(minIdx).get(indexes[minIdx]));
			indexes[minIdx]++;
			if (indexes[minIdx] == arrays.get(minIdx).size()) {
				indexes[minIdx] = -1;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		ArrayList<List<Integer>> arrays = new ArrayList<>();
		//[[1, 5, 9, 21], [-1, 0], [-124, 81, 121], [3, 6, 12, 20, 150]]
		arrays.add(Arrays.asList(1, 5, 9, 21));
		arrays.add(Arrays.asList(-1, 0));
		arrays.add(Arrays.asList(-124, 81, 121));
		arrays.add(Arrays.asList(3, 6, 12, 20, 150));
		System.out.println(mergeSortedArrays(arrays));
	}

}
