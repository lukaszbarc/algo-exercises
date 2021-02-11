package com.lbarc.aglo.exercises.balancedbrackets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Program {

	public static boolean balancedBrackets(String str) {
		final Set<Character> validChars = new HashSet<>();
		validChars.add('[');
		validChars.add('{');
		validChars.add('(');
		validChars.add(')');
		validChars.add('}');
		validChars.add(']');
		final Map<Character, Character> matching = new HashMap<>();
		matching.put('(', ')');
		matching.put('[', ']');
		matching.put('{', '}');
		final Stack<Character> stack = new Stack<>();
		for (char c : str.toCharArray()) {
			if (!validChars.contains(c)) {
				continue;
			}
			if (matching.keySet().contains(c)) {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				Character pop = stack.pop();
				if (c != matching.get(pop)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		balancedBrackets("([])(){}(())()()");
	}
}
