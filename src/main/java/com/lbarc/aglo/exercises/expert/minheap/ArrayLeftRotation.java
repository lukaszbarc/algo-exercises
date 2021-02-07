package com.lbarc.aglo.exercises.expert.minheap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayLeftRotation {

	// Complete the rotLeft function below.
	static int[] rotLeft(int[] a, int d) {
		int[] result = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int newIdx = i - d;
			while (newIdx < 0) {
				newIdx += a.length;
			}
			result[newIdx] = a[i];
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(rotLeft(new int[] {1,2,3,4,5},4)));
	}

}
