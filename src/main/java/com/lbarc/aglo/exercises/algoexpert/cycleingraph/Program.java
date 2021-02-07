package com.lbarc.aglo.exercises.algoexpert.cycleingraph;

public class Program {

	public boolean cycleInGraph(int[][] edges) {
		boolean[] visited = new boolean[edges.length];
		boolean[] stacked = new boolean[edges.length];
		boolean result = false;
		for (int i = 0; i < edges.length; i++) {
			if (!visited[i]) {
				result |= dfs(i, edges, visited, stacked);
			}
		}
		return result;
	}

	private boolean dfs(int edge, int[][] edges, boolean[] visited, boolean[] stacked) {
		visited[edge] = true;
		stacked[edge] = true;
		for (int nextEdge : edges[edge]) {
			if (stacked[nextEdge]) {
				return true;
			}
			if (!visited[nextEdge] && dfs(nextEdge, edges, visited, stacked)) {
				return true;
			}
		}
		stacked[edge] = false;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new Program().cycleInGraph(new int[][]{
				{1}, {2}, {3}, {0}
		}));
	}

}
