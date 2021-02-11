package com.lbarc.aglo.exercises.algoexpert.powersets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

	public static List<List<Integer>> powerset(List<Integer> array) {
		final List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());

		for (Integer integer : array) {
			int size = result.size();
			for (int i = 0; i < size; i++) {
				final List<Integer> partResult = result.get(i);
				final List<Integer> newSubset = new ArrayList<>(partResult);
				newSubset.add(integer);
				result.add(newSubset);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(powerset(Arrays.asList(1, 2, 3)));
	}

}
