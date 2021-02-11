package com.lbarc.aglo.exercises.algoexpert.minheightbst;

import java.util.Arrays;
import java.util.List;

class Program {

	public static BST minHeightBst(List<Integer> array) {
		return bst(array, 0, array.size() - 1);
	}

	public static BST bst(List<Integer> array, int leftIdx, int rightIdx) {
		if (rightIdx < leftIdx) {
			return null;
		}
		int midIdx = (rightIdx + leftIdx) / 2;
		final BST bst = new BST(array.get(midIdx));
		bst.left = bst(array, leftIdx, midIdx - 1);
		bst.right = bst(array, midIdx + 1, rightIdx);
		return bst;
	}

	public static void main(String[] args) {
		BST bst = minHeightBst(Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22));
		System.out.println(bst);
	}

	static class BST {

		public int value;

		public BST left;

		public BST right;

		public BST(int value) {
			this.value = value;
			left = null;
			right = null;
		}

		public void insert(int value) {
			if (value < this.value) {
				if (left == null) {
					left = new BST(value);
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					right = new BST(value);
				} else {
					right.insert(value);
				}
			}
		}
	}
}

