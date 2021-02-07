package com.lbarc.aglo.exercises.expert.minheap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeap {

	private final List<Integer> heap;

	public MinHeap(List<Integer> array) {
		heap = buildHeap(array);
	}

	public List<Integer> buildHeap(List<Integer> array) {
		final List<Integer> copy = new ArrayList<>(array);
		System.out.println(copy);
		int lastParentIndex = (copy.size() - 1) / 2;
		for (int idx = lastParentIndex; idx >= 0; idx--) {
			siftDown(idx, copy.size() - 1, copy);
		}
		System.out.println(copy);
		return copy;
	}

	public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
		int currentValue = heap.get(currentIdx);
		int leftIdx = currentIdx * 2 + 1;
		int rightIdx = (currentIdx * 2) + 2;
		if (endIdx < leftIdx) {
			return;
		}

		int leftValue = heap.get(leftIdx);
		int rightValue = endIdx >= rightIdx ? heap.get(rightIdx) : Integer.MAX_VALUE;

		int minChildValue = Math.min(leftValue, rightValue);
		int minChildIdx = minChildValue == leftValue ? leftIdx : rightIdx;

		if (currentValue > minChildValue) {
			heap.set(minChildIdx, currentValue);
			heap.set(currentIdx, minChildValue);
		}

		siftDown(minChildIdx, endIdx, heap);
	}

	public void siftUp(int currentIdx, List<Integer> heap) {
		if (currentIdx == 0) {
			return;
		}
		int parentIdx = (currentIdx - 1) / 2;

		int currentValue = heap.get(currentIdx);
		int parentValue = heap.get(parentIdx);

		if (currentValue < parentValue) {
			heap.set(currentIdx, parentValue);
			heap.set(parentIdx, currentValue);
			siftUp(parentIdx, heap);
		}

	}

	public int peek() {
		return heap.get(0);
	}

	public int remove() {
		int result = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		siftDown(0, heap.size() - 1, heap);
		return result;
	}

	public void insert(int value) {
		heap.add(value);
		siftUp(heap.size() - 1, heap);
	}

	public static void main(String[] args) {
		final MinHeap heap = new MinHeap(Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41));
		//		heap.insert(76);
		//		System.out.println(heap.heap);
		heap.insert(-4);
		System.out.println(heap.heap);

	}

}
