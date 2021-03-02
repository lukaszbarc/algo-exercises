package com.lbarc.aglo.exercises.algoexpert.linkedlist;

public class Program {

	static class DoublyLinkedList {

		public Node head;

		public Node tail;

		public void setHead(Node node) {
			if (head == null) {
				head = node;
				tail = node;
			} else {
				head.prev = node;
				node.next = head;
				head = node;
			}
		}

		public void setTail(Node node) {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}

		public void insertBefore(Node node, Node nodeToInsert) {
			Node current = head;
			while (current != null && current.value != node.value) {
				current = current.next;
			}
			if (current == null) {
				return;
			}
			nodeToInsert.next = current;
			nodeToInsert.prev = current.prev;
			if (current.prev != null) {
				current.prev.next = nodeToInsert;
			}
		}

		public void insertAfter(Node node, Node nodeToInsert) {
			Node current = head;
			while (current != null && current.value != node.value) {
				current = current.next;
			}
			if (current == null) {
				return;
			}
			nodeToInsert.prev = current;
			nodeToInsert.next = current.next;
			current.next = nodeToInsert;
			if (nodeToInsert.next == null) {
				tail = nodeToInsert;
			}
		}

		public void insertAtPosition(int position, Node nodeToInsert) {
			Node current = head;
			int currentPos = 1;
			while (currentPos < position && current.next != null) {
				currentPos++;
				current = current.next;
			}
			if (current == null) {
				return;
			}
			if (position > 1) {
				insertAfter(current, nodeToInsert);
			} else {
				setHead(nodeToInsert);
			}
		}

		public void removeNodesWithValue(int value) {
			Node current = head;
			while (current != null) {
				if (current.value == value) {
					if (current.prev != null) {
						current.prev.next = current.next;
						current = current.next;
						continue;
					} else {
						head = current.next;
					}
				}
				current = current.next;
			}
		}

		public void remove(Node node) {
			Node current = head;
			while (current != null && current.value != node.value) {
				current = current.next;
			}
			if (current == null) {
				return;
			}
			current.prev.next = current.next;
		}

		public boolean containsNodeWithValue(int value) {
			Node current = head;
			while (current != null) {
				if (current.value == value) {
					return true;
				}
				current = current.next;
			}
			return false;
		}
	}

	// Do not edit the class below.
	static class Node {

		public int value;

		public Node prev;

		public Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.setHead(new Node(1));
		list.insertAtPosition(2, new Node(2));
		list.insertAtPosition(3, new Node(3));
		list.insertAtPosition(4, new Node(4));
		list.insertAtPosition(5, new Node(5));

		list.setHead(new Node(4));
		list.setTail(new Node(6));
		list.insertBefore(new Node(6), new Node(3));
		list.insertAfter(new Node(6), new Node(3));

		list.insertAtPosition(1, new Node(3));
		list.removeNodesWithValue(3);
		list.remove(new Node(2));
		System.out.println(list);

	}
}
