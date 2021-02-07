package com.lbarc.aglo.exercises.expert.minheap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousMedian {

	static class ContinuousMedianHandler {

		private final PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());

		private final PriorityQueue<Integer> right = new PriorityQueue<>();

		double median = 0;

		public void insert(int number) {
			if (left.size() == 0 || number <= left.peek()) {
				left.add(number);
			} else {
				right.add(number);
			}

			int maxDiff = (left.size() + right.size()) % 2 == 0 ? 0 : 1;
			while (Math.abs(left.size() - right.size()) > maxDiff) {
				if (left.size() > right.size()) {
					right.add(left.poll());
				} else {
					left.add(right.poll());
				}
			}

			if (maxDiff == 0) {
				median = (left.peek() + right.peek()) / 2.0;
			} else {
				if (left.size() > right.size()) {
					median = left.peek();
				} else {
					median = right.peek();
				}
			}
		}

		public double getMedian() {
			return median;
		}
	}

	public static void main(String[] args) {
		System.out.println(3 - 4);
		PriorityQueue<Integer> test = null;

	}
}
