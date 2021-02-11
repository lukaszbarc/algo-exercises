package com.lbarc.aglo.exercises.leetcode.google.uniqueemailaddress;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public int numUniqueEmails(String[] emails) {
		final Set<String> uniqueAddresses = new HashSet<>();
		for (String email : emails) {
			uniqueAddresses.add(normalize(email));
		}
		return uniqueAddresses.size();
	}

	private String normalize(String email) {
		char[] chars = email.toCharArray();

		char[] normalized = new char[chars.length];
		int normalizedLength = 0;
		boolean skipUntilAt = false;
		boolean beforeAt = true;
		for (int i = 0; i < chars.length; i++) {
			if (beforeAt && skipUntilAt && chars[i] != '@') {
				continue;
			}
			if (beforeAt && chars[i] == '.') {
				continue;
			}
			if (chars[i] == '+') {
				skipUntilAt = true;
				continue;
			}
			if (chars[i] == '@') {
				beforeAt = false;
			}
			normalized[normalizedLength++] = chars[i];
		}
		return String.valueOf(normalized, 0, normalizedLength);
	}

	public static void main(String[] args) {
		new Solution().numUniqueEmails(new String[]{"test.email+alex@leetcode.com"});
	}
}
