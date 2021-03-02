package com.lbarc.aglo.exercises.algoexpert.minimumarearectangle;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Program {

	static class Point {

		int x;

		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Point point = (Point) o;
			return x == point.x &&
					y == point.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}

	public int minimumAreaRectangle(int[][] points) {
		final Set<Point> allPoints = new HashSet<>();

		int minimum = Integer.MAX_VALUE;

		for (int[] point : points) {
			allPoints.add(new Point(point[0], point[1]));
		}

		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if (i == j) {
					continue;
				}
				Point first = new Point(points[i][0], points[i][1]);
				Point second = new Point(points[j][0], points[j][1]);

				if (allPoints.contains(new Point(first.x, second.y)) && allPoints.contains(new Point(second.x, first.y))) {
					int width = Math.abs(first.x - second.x);
					int height = Math.abs(first.y - second.y);
					int field = width * height;
					if (field == 0) {
						continue;
					}
					if (field < minimum) {
						minimum = field;
					}
				}
			}
		}
		return minimum == Integer.MAX_VALUE ? 0 : minimum;
	}

	public static void main(String[] args) {
		new Program().minimumAreaRectangle(new int[][]{
				{-4, 4},
				{4, 4},
				{4, -2},
				{-4, -2},
				{0, -2},
				{4, 2},
				{0, 2}
		});
	}

}
