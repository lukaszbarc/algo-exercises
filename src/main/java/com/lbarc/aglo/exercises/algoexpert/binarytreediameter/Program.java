package com.lbarc.aglo.exercises.algoexpert.binarytreediameter;

public class Program {

	static class BinaryTree {

		public int value;

		public BinaryTree left = null;

		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}



	public int binaryTreeDiameter(BinaryTree tree) {
		return getTreeInfo(tree).diameter;
	}

	private TreeInfo getTreeInfo(BinaryTree tree) {
		if (tree == null) {
			return new TreeInfo(0, 0);
		}

		TreeInfo left = getTreeInfo(tree.left);
		TreeInfo right = getTreeInfo(tree.right);

		int longestPath = left.height + right.height;
		int maxDiameter = Math.max(left.diameter, right.diameter);
		int currentDiameter = Math.max(maxDiameter, longestPath);
		int currentHeight = 1 + Math.max(left.height, right.height);

		return new TreeInfo(currentDiameter, currentHeight);
	}

	static class TreeInfo {

		int diameter;

		int height;

		public TreeInfo(int diameter, int height) {
			this.diameter = diameter;
			this.height = height;
		}
	}

}
