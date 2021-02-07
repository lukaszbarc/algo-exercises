package com.lbarc.aglo.exercises.kickstart.r2020.a.workout;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try (final Scanner input = new Scanner(new BufferedReader(new InputStreamReader((System.in))))) {
			final int testCasesCount = input.nextInt();
			for (int testCase = 0; testCase < testCasesCount; testCase++) {
				int workouts = input.nextInt();
				int maxAdditionalSessions = input.nextInt();

				int[] workout = new int[workouts];
				for (int i = 0; i < workouts; i++) {
					workout[i] = input.nextInt();
				}
				final int result = solve(workout, maxAdditionalSessions);
				System.out.printf("Case #%d: %d%n", testCase + 1, result);
			}
		}
	}

	public static int solve(int[] workouts, int maxAdditionalSession) {
		final Queue<Integer> oriQ = new PriorityQueue<>();
		int maxDif = 0;
		for (int i = 0; i < workouts.length; i++) {
			if (i > 0) {
				maxDif = Math.max(maxDif, workouts[i] - workouts[i - 1]);
			}
			oriQ.add(workouts[i]);
		}
		int l = 1;
		int r = maxDif;


		while (r - l > 200) {
			int m = (1 + r + l) / 2;
			if (testM(maxAdditionalSession, oriQ, m)) {
				r = m;
			} else {
				l = m;
			}
		}

		for (int i = l; i <= r; i++) {
			if (testM(maxAdditionalSession, oriQ, i)) {
				return i;
			}
		}

		throw new IllegalStateException();
	}

	private static boolean testM(int maxAdditionalSession, Queue<Integer> oriQ, int m) {
		final Queue<Integer> q = new PriorityQueue<>(oriQ);
		Integer val = q.poll();
		Integer next = q.poll();
		int remaining = maxAdditionalSession;
		while (val != null && next != null && remaining >= 0) {
			if (val + m >= next) {
				val = next;
				next = q.poll();
			} else {
				remaining--;
				val = val + m;
			}
		}
		return remaining >= 0;
	}
}
