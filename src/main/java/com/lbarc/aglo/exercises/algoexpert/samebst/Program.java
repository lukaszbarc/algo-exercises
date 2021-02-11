package com.lbarc.aglo.exercises.algoexpert.samebst;

import java.util.List;
import static java.util.stream.Collectors.toList;

public class Program {

	public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
		return same(arrayOne, arrayTwo);
	}

	public static boolean same(List<Integer> arrayOne, List<Integer> arrayTwo) {
		if (arrayOne.size() != arrayTwo.size()) {
			return false;
		}
		if (arrayOne.size() == 0) {
			return true;
		}
		if (!arrayOne.get(0).equals(arrayTwo.get(0))) {
			return false;
		}
		if (arrayOne.size() == 1 && arrayOne.get(0).equals(arrayTwo.get(0))) {
			return true;
		}

		final Integer rootValue = arrayOne.get(0);
		return same(arrayOne.stream().skip(1).filter(a -> a < rootValue).collect(toList()), arrayTwo.stream().skip(1).filter(a -> a < rootValue).collect(toList()))
				&& same(arrayOne.stream().skip(1).filter(a -> a >= rootValue).collect(toList()), arrayTwo.stream().skip(1).filter(a -> a >= rootValue).collect(toList()));
	}

}
