package com.lbarc.aglo.exercises.algoexpert.sumoflinkedlist;

public class Program {

	// This is an input class. Do not edit.
	public static class LinkedList {

		public int value;

		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
	}

	public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
		int rest = 0;
		LinkedList a = linkedListOne;
		LinkedList b = linkedListTwo;

		int c = a.value + b.value;
		rest = c / 10;
		c = c % 10;
		LinkedList result = new LinkedList(c);
		LinkedList current = result;

		a = a.next;
		b = b.next;
		while (a != null || b != null) {
			c = rest;
			c += a == null ? 0 : a.value;
			c += b == null ? 0 : b.value;

			rest = c / 10;
			c = c % 10;

			current.next = new LinkedList(c);
			current = current.next;

			a = a == null ? null : a.next;
			b = b == null ? null : b.next;
		}
		if (rest > 0) {
			current.next = new LinkedList(c % 10);
			current = current.next;
			if (rest > 10) {
				current.next = new LinkedList(c / 10);
			}
		}
		// Write your code here.
		return result;
	}

	public static void main(String[] args) {
		LinkedList a = new LinkedList(2);
		a.next = new LinkedList(4);
		a.next.next = new LinkedList(7);
		a.next.next.next = new LinkedList(1);

		LinkedList b = new LinkedList(9);
		b.next = new LinkedList(4);
		b.next.next = new LinkedList(5);
		new Program().sumOfLinkedLists(a, b);
	}
}
