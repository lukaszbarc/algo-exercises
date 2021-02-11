package com.lbarc.aglo.exercises.algoexpert.phonenumbermnemonics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

	private static final Map<Character, String[]> MAPPING = new HashMap<>();

	public Program() {
		MAPPING.put('0', new String[]{"0"});
		MAPPING.put('1', new String[]{"1"});
		MAPPING.put('2', new String[]{"a", "b", "c"});
		MAPPING.put('3', new String[]{"d", "e", "f"});
		MAPPING.put('4', new String[]{"g", "h", "i"});
		MAPPING.put('5', new String[]{"j", "k", "l"});
		MAPPING.put('6', new String[]{"m", "n", "o"});
		MAPPING.put('7', new String[]{"p", "q", "r", "s"});
		MAPPING.put('8', new String[]{"t", "u", "v"});
		MAPPING.put('9', new String[]{ "w", "x", "y", "z"});
	}

	public List<String> phoneNumberMnemonics(String phoneNumber) {
		final List<String> result = new ArrayList<>();

		final String[] currentMnemonics = new String[phoneNumber.length()];
		Arrays.fill(currentMnemonics, "0");

		helper(0, currentMnemonics, phoneNumber, result);

		return result;
	}

	private void helper(int i, String[] currentMnemonic, String phoneNumber, List<String> result) {
		if (i == phoneNumber.length()) {
			result.add(String.join("", currentMnemonic));
		} else {
			char c = phoneNumber.charAt(i);
			String[] mappings = MAPPING.get(c);
			for (String mapping : mappings) {
				currentMnemonic[i] = mapping;
				helper(i + 1, currentMnemonic, phoneNumber, result);
			}

		}
	}

	public static void main(String[] args) {
		System.out.println(new Program().phoneNumberMnemonics("1905"));
	}

}
