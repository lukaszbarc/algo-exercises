package com.lbarc.aglo.exercises.expert.minheap;

public class LL {

	static class LinkedList<T> {

		private T value;

		private LinkedList<T> next;

		public LinkedList() {
		}

		public void add(T value) {
			if(this.value == null) {
				this.value = value;
				return;
			}
			LinkedList<T> tmpNext = this;
			while (tmpNext.next != null) {
				tmpNext = tmpNext.next;
			}
			tmpNext.next = new LinkedList<>();
			tmpNext.next.value = value;
		}
	}

	public static <T> LinkedList<T> reverse(LinkedList<T> list) {
		LinkedList<T> previous = null;
		LinkedList<T> current = list;
		while (current != null) {
			LinkedList<T> next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		list = previous;
		return list;
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list);

		final LinkedList<Integer> reversed = reverse(list);
		System.out.println(reversed);

	}
}
