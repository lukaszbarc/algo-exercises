package com.lbarc.aglo.exercises.algoexpert.removeduplicatesfromlinkedlist;

import java.util.HashSet;
import java.util.Set;

public class Program {

	public static class LinkedList {

		public int value;

		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}

		public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
			final Set<Integer> values = new HashSet<>();

			final LinkedList startNode = linkedList;

			LinkedList currentNode = linkedList;
			values.add(currentNode.value);
			while (currentNode.next != null) {
				final LinkedList nextNode = currentNode.next;
				if (!values.add(nextNode.value)) {
					currentNode.next = nextNode.next;
				} else {
					currentNode = nextNode;
				}
			}

			return startNode;
		}
	}

}
