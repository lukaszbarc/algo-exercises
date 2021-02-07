package com.lbarc.aglo.exercises.expert.minheap;

public class BSTProgram {

	static class BST {

		public int value;

		public BST left;

		public BST right;

		public BST(int value) {
			this.value = value;
		}

		public BST insert(int value) {
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
			return this;
		}

		public boolean contains(int value) {
			if (this.value == value) {
				return true;
			}
			if (value > this.value && right != null) {
				return right.contains(value);
			}
			if (value < this.value && left != null) {
				return left.contains(value);
			}
			return false;
		}

		public BST remove(int value) {
			remove(value, null);
			return this;
		}

		public void remove(int value, BST parent) {
			if (value < this.value) {
				if (left != null) {
					left.remove(value, this);
				}
			} else if (value > this.value) {
				if (right != null) {
					right.remove(value, this);
				}
			} else {
				if (left != null && right != null) {
					this.value = right.getMinValue();
					right.remove(this.value, this);
				} else if (parent == null) {
					if (left != null) {
						this.value = left.value;
						right = left.right;
						left = left.left;
					} else if (right != null) {
						this.value = right.value;
						left = right.left;
						right = right.right;
					} else {
						// single node tree
					}
				} else if (parent.left == this) {
					parent.left = left != null ? left : right;
				} else if (parent.right == this) {
					parent.right = right != null ? left : right;
				}
			}
		}

		private int getMinValue() {
			if (left == null) {
				return this.value;
			}
			return left.getMinValue();
		}
	}

	public static void main(String[] args) {
		BST bst = new BST(1);
		bst.insert(2);
		bst.insert(3);
		bst.insert(4);
		bst.insert(5);
		bst.insert(6);
		bst.insert(7);
		bst.insert(8);
		bst.insert(9);
		bst.insert(10);
		bst.insert(11);
		bst.insert(12);
		bst.insert(13);
		bst.insert(14);
		bst.insert(15);
		bst.insert(16);
		bst.insert(17);
		bst.insert(18);
		bst.insert(19);
		bst.insert(20);

		bst.remove(2);
		bst.remove(4);
		bst.remove(6);
		bst.remove(8);
		bst.remove(11);
		bst.remove(13);
		bst.remove(13);
		bst.remove(15);
		bst.remove(17);
		bst.remove(19);

		bst.insert(1);
		bst.insert(2);
		bst.insert(3);
		bst.insert(4);
		bst.insert(5);
		bst.insert(6);
		bst.insert(7);
		bst.insert(8);
		bst.insert(9);
		bst.insert(10);
		boolean result = bst.contains(9000);

		System.out.println(result);


	}

}
