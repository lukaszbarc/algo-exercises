package com.lbarc.aglo.exercises.algoexpert.taskassignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

	public List<List<Integer>> taskAssignment(int k, List<Integer> tasks) {
		final Map<Integer, List<Integer>> indexes = new HashMap<>();
		for (int i = 0; i < tasks.size(); i++) {
			final Integer value = tasks.get(i);
			indexes.computeIfAbsent(value, k1 -> new ArrayList<>());
			indexes.get(value).add(i);
		}
		Collections.sort(tasks);
		final List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < tasks.size() / 2; i++) {
			int val1 = tasks.get(i);
			int val2 = tasks.get(tasks.size() - 1 - i);

			int val1Idx = indexes.get(val1).remove(0);
			int val2Idx = indexes.get(val2).remove(0);

			result.add(Arrays.asList(val1Idx, val2Idx));
		}
		return result;
	}
}
