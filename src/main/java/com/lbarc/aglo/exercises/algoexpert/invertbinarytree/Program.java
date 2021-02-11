package com.lbarc.aglo.exercises.algoexpert.invertbinarytree;

public class Program {

	public static void invertBinaryTree(BinaryTree tree) {
		if (tree == null) {
			return;
		}
		BinaryTree tmp = tree.right;
		tree.right = tree.left;
		tree.left = tmp;

		invertBinaryTree(tree.right);
		invertBinaryTree(tree.left);
	}

	static class BinaryTree {

		public int value;

		public BinaryTree left;

		public BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

}
