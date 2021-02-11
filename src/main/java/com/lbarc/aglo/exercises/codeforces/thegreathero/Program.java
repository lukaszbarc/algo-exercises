package com.lbarc.aglo.exercises.codeforces.thegreathero;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int testCases = in.nextInt();
			for (int tc = 0; tc < testCases; tc++) {

				int attackPower = in.nextInt();
				int initialHealth = in.nextInt();
				int monsters = in.nextInt();

				int monsterAttacks[] = new int[monsters];
				int monstersHealths[] = new int[monsters];
				for (int i = 0; i < monsters; i++) {
					monsterAttacks[i] = in.nextInt();
				}
				for (int i = 0; i < monsters; i++) {
					monstersHealths[i] = in.nextInt();
				}
				solve(attackPower, initialHealth, monsterAttacks, monstersHealths);
			}
		}
	}

	private static void solve(int attackPower, int initialHealth, int[] monsterAttacks, int[] monstersHealths) {
		int health = initialHealth;
		for (int i = 0; i < monsterAttacks.length; i++) {
			int rounds = (int) Math.ceil(monstersHealths[i] / (double) attackPower);
			health -= (rounds * monsterAttacks[i]);
			if (i == monsterAttacks.length - 1) {
				health += monsterAttacks[i];
			}
			if (health < 1) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

}
