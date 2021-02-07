package com.lbarc.aglo.exercises.expert.minheap;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFS {

	static class Node {

		String name;

		List<Node> children = new ArrayList<Node>();

		public Node(String name) {
			this.name = name;
		}

		public List<String> breadthFirstSearch(List<String> array) {
			final List<String> result = new ArrayList<>();
			final Queue<Node> queue = new ArrayDeque<>();
			queue.add(this);
			while (!queue.isEmpty()) {
				final Node node = queue.poll();
				result.add(node.name);
				queue.addAll(node.children);
			}
			return result;
		}

		public Node addChild(String name) {
			Node child = new Node(name);
			children.add(child);
			return this;
		}
	}
}
