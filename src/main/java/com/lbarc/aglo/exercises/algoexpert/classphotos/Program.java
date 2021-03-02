package com.lbarc.aglo.exercises.algoexpert.classphotos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Program {

	public boolean classPhotos(
			List<Integer> redShirtHeights, List<Integer> blueShirtHeights) {

		Collections.sort(redShirtHeights);
		Collections.sort(blueShirtHeights);

		Integer maxRed = redShirtHeights.get(redShirtHeights.size() - 1);
		Integer maxBlue = blueShirtHeights.get(blueShirtHeights.size() - 1);

		boolean redHigher = maxRed > maxBlue;

		for (int i = 0; i < redShirtHeights.size(); i++) {
			if (redHigher) {
				if (redShirtHeights.get(i) <= blueShirtHeights.get(i)) {
					return false;
				}
			} else {
				if (blueShirtHeights.get(i) <= redShirtHeights.get(i)) {
					return false;
				}
			}
		}

		// Write your code here.
		return true;
	}

	public static void main(String[] args) {
		new Program().classPhotos(Arrays.asList(6, 9, 2, 4, 5), Arrays.asList(5, 8, 1, 3, 4));
	}

}
