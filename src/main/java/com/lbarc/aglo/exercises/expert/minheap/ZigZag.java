package com.lbarc.aglo.exercises.expert.minheap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZag {

	public static void main(String[] args) {
		System.out.println(zigzagTraverse(Arrays.asList(
				Arrays.asList(1, 3, 4, 10),
				Arrays.asList(2, 5, 9, 11),
				Arrays.asList(6, 8, 12, 15),
				Arrays.asList(7, 13, 14, 16)
		)));
	}

	public static enum Direction {
		RU, R, D, LD
	}

	public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
		final List<Integer> result = new ArrayList<>();

		final int width = array.get(0).size();
		final int height = array.size();

		int x = 0;
		int y = 0;
		Direction direction = Direction.LD;
		for (int i = 0; i < width * height; i++) {
			result.add(array.get(y).get(x));
			if (isMovePossible(x, y, direction, array)) {
				switch (direction) {
					case LD: {
						x--;
						y++;
						break;
					}
					case RU: {
						x++;
						y--;
						break;
					}
				}
			} else {
				if (direction == Direction.LD) {
					if (isMovePossible(x, y, Direction.D, array)) {
						y++;
					} else {
						x++;
					}
					direction = Direction.RU;
				} else if (direction == Direction.RU) {
					if (isMovePossible(x, y, Direction.R, array)) {
						x++;
					} else {
						y++;
					}
					direction = Direction.LD;
				}
			}
		}

		return result;
	}

	static boolean isMovePossible(int x, int y, Direction direction, List<List<Integer>> array) {
		switch (direction) {
			case LD: {
				return x > 0 && y + 1 < array.size();
			}
			case RU: {
				return x + 1 < array.get(0).size() && y > 0;
			}
			case R: {
				return x + 1 < array.get(0).size();
			}
			case D: {
				return y + 1 < array.size();
			}
		}
		throw new IllegalStateException();
	}
}
