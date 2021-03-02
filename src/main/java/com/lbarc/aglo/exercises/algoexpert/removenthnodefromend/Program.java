package com.lbarc.aglo.exercises.algoexpert.removenthnodefromend;

public class Program {

	public static void removeKthNodeFromEnd(LinkedList head, int k) {
		LinkedList p1 = head;
		LinkedList p2 = head;
		int counter = 1;
		while (counter <= k) {
			p2 = p2.next;
			counter++;
		}
		if (p2 == null) {
			head.value = head.next.value;
			head.next = head.next.next;
			return;
		}
		while (p2.next != null) {
			p2 = p2.next;
			p1 = p1.next;
		}
		p1.next = p1.next.next;
	}

	static class LinkedList {

		int value;

		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}
}
