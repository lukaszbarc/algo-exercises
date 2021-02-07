package com.lbarc.aglo.exercises.expert.minheap;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstring {

	public static void main(String[] args) {
		System.out.println(smallestSubstringContaining("14562435612z!8828!193236!336!5$41!23!5!6789901#z2!", "#!2z"));
	}



	public static String smallestSubstringContaining(String bigString, String smallString) {

		int bestResultStartIdx = 0;
		int bestResultLength = Integer.MAX_VALUE;

		int resultStartIdx = 0;

		char big[] = bigString.toCharArray();


		for (int i = 0; i < bigString.length() - smallString.length() +1; i++) {
			Map<Character, Integer> requiredChars = createCharReqMap(smallString);
			if (requiredChars.get(big[i]) == null) {
				continue;
			}

			resultStartIdx = i;
			for (int j = i; j < bigString.length() && j - i <= bestResultLength; j++) {

				Integer req = requiredChars.get(big[j]);
				if (req == null) {
					continue;
				}
				if (req == 1) {
					requiredChars.remove(big[j]);
					if (requiredChars.isEmpty()) {
						if (j - resultStartIdx < bestResultLength) {
							bestResultStartIdx = resultStartIdx;
							bestResultLength = j - resultStartIdx + 1;
						}
						break;
					}
				} else {
					requiredChars.replace(big[j], req - 1);
				}
			}

		}
		if (bestResultLength == Integer.MAX_VALUE) {
			return "";
		}
		return bigString.substring(bestResultStartIdx, bestResultStartIdx + bestResultLength);
	}

	public static Map<Character, Integer> createCharReqMap(String str) {
		final Map<Character, Integer> result = new HashMap<>();
		final char[] chars = str.toCharArray();
		for (char c : chars) {
			if (result.get(c) == null) {
				result.put(c, 0);
			}
			result.replace(c, result.get(c) + 1);
		}
		return result;
	}
}
