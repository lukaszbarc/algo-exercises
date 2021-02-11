package com.lbarc.aglo.exercises.algoexpert.findsuccessor;

public class Program {

	static class BinaryTree {

		public int value;

		public BinaryTree left = null;

		public BinaryTree right = null;

		public BinaryTree parent = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
		final BinaryTree parent = node.parent;
		if (node == parent.left) {
			return parent;
		}
		return node.right;
	}

}
