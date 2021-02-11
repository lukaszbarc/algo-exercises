package com.lbarc.aglo.exercises.leetcode.google.treesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Solution {

	public List<List<Integer>> threeSum(int[] nums) {
		final Map<Integer, Long> availableNums = Arrays.stream(nums).boxed().collect(groupingBy(Function.identity(), counting()));
		final Set<List<Integer>> result = new HashSet<>();

		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int a = nums[i];
				int b = nums[j];
				int c = (a + b) * -1;
				if (availableNums.containsKey(c)) {
					long aFreq = availableNums.get(a);
					long bFreq = availableNums.get(b);
					long cFreq = availableNums.get(c);

					final List<Integer> res = new ArrayList<>(3);
					res.add(a);
					res.add(b);
					res.add(c);

					for (Integer re : res) {
						if (a == re) {
							aFreq--;
						}
						if (b == re) {
							bFreq--;
						}
						if (c == re) {
							cFreq--;
						}
					}

					if (aFreq >= 0 && bFreq >= 0 && cFreq >= 0) {
						Collections.sort(res);
						result.add(res);
					}
				}
			}
		}
		return new ArrayList<>(result);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
	}
}
