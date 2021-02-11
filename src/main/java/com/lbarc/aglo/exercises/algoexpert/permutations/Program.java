package com.lbarc.aglo.exercises.algoexpert.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

	public static List<List<Integer>> getPermutations(List<Integer> array) {
		final List<List<Integer>> result = new ArrayList<>();

		getPermutations(array, new ArrayList<>(), result);

		return result;
	}

	private static void getPermutations(List<Integer> array, List<Integer> currentPermutation, List<List<Integer>> permutations) {
		if (array.size() == 0 && currentPermutation.size() > 0) {
			permutations.add(currentPermutation);
		} else {
			for (int i = 0; i < array.size(); i++) {
				final List<Integer> newArray = new ArrayList<>(array);
				newArray.remove(i);
				final List<Integer> newPermutation = new ArrayList<>(currentPermutation);
				newPermutation.add(array.get(i));
				getPermutations(newArray, newPermutation, permutations);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(getPermutations(Arrays.asList(1, 2, 3, 4, 5, 6)));
	}

}
