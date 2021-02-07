package com.lbarc.aglo.exercises.expert.minheap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

	private final Map<Integer, List<String>> map = new HashMap<>();

	public Program() {
		for (int i = 0; i < 81; i++) {
			final StringBuilder sb = new StringBuilder();
			final int first = (i / 27 % 3) + 1;
			final int second = (i / 9 % 3) + 1;
			final int third = (i / 3 % 3) + 1;
			final int fourth = (i % 3) + 1;
			sb.append(first);
			sb.append(second);
			sb.append(third);
			sb.append(fourth);
			final int sum = first + second + third + fourth;
			if (map.get(sum) == null) {
				map.put(sum, new ArrayList<>());
			}
			map.get(sum).add(sb.toString());

		}
	}

	public ArrayList<String> validIPAddresses(String string) {
		final List<String> numbers = map.get(string.length());
		if (numbers == null || numbers.isEmpty()) {
			return new ArrayList<>();
		}
		final ArrayList<String> result = new ArrayList<>();
		for (String number : numbers) {
			int first = getNumberOfCharsAtPart(number, 1);
			int second = getNumberOfCharsAtPart(number, 2);
			int third = getNumberOfCharsAtPart(number, 3);
			int forth = getNumberOfCharsAtPart(number, 4);

			int firstPart = Integer.parseInt(string.substring(0, first));
			int secondPart = Integer.parseInt(string.substring(first, first + second));
			int thirdPart = Integer.parseInt(string.substring(first + second, first + second + third));
			int fourthPart = Integer.parseInt(string.substring(first + second + third));

			if (validatePart(first, firstPart)
					&& validatePart(second, secondPart)
					&& validatePart(third, thirdPart)
					&& validatePart(forth, fourthPart)) {
				result.add(String.valueOf(firstPart) + '.' + secondPart + '.' + thirdPart + '.' + fourthPart);
			}

		}

		return result;
	}

	private boolean validatePart(int count, int value) {
		if (value > 255 || (count == 2 && value < 10) || (count == 3 && value < 100)) {
			return false;
		}
		return true;
	}

	private int getNumberOfCharsAtPart(String number, int i) {
		return Integer.parseInt(number.substring(i - 1, i));
	}

	public static void main(String[] args) {
		final Program program = new Program();
		System.out.println(program.validIPAddresses("1921680"));

	}

}
