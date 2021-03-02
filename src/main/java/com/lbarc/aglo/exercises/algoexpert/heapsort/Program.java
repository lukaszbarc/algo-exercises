package com.lbarc.aglo.exercises.algoexpert.heapsort;

public class Program {

	public static int[] heapSort(int[] array) {
		int lastParentIdx = parent(array.length - 1);
		for (int i = lastParentIdx; i >= 0; i--) {
			siftDown(i, array, array.length - 1);
		}

		int result[] = new int[array.length];

		int endIdx = array.length - 1;
		int idx = 0;
		while (endIdx >= 0) {
			result[idx++] = remove(array, endIdx);
			endIdx--;
		}
		return result;
	}

	private static int remove(int[] array, int endIdx) {
		int value = array[0];
		array[0] = array[endIdx];
		array[endIdx] = value;
		siftDown(0, array, endIdx - 1);
		return value;
	}

	private static void siftDown(int idx, int[] array, int endIdx) {
		int currentValue = array[idx];
		int leftChildIndex = childLeft(idx);
		int rightChildIndex = childRight(idx);

		if (leftChildIndex > endIdx) {
			return;
		}

		int leftChildValue = array[leftChildIndex];
		int rightChildValue = rightChildIndex <= endIdx ? array[rightChildIndex] : Integer.MAX_VALUE;

		int minChildValue = Math.min(leftChildValue, rightChildValue);
		int minChildIndex = leftChildValue == minChildValue ? leftChildIndex : rightChildIndex;

		if (currentValue > minChildValue) {
			array[minChildIndex] = currentValue;
			array[idx] = minChildValue;
		}
		siftDown(minChildIndex, array, endIdx);
	}

	private static int childLeft(int i) {
		return (2 * i) + 1;
	}

	private static int childRight(int i) {
		return (2 * i) + 2;
	}

	private static int parent(int i) {
		return (i - 1) / 2;
	}

	public static void main(String[] args) {
		heapSort(new int[]{2, 1});
	}

}
