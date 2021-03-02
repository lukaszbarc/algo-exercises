package com.lbarc.aglo.exercises.algoexpert.tournamentwinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

	public String tournamentWinner(
			ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

		final Map<String, Integer> team2Points = new HashMap<>();

		String winning = "";
		int winnerScore = 0;
		for (int i = 0; i < competitions.size(); i++) {
			final List<String> teams = competitions.get(i);

			final String home = teams.get(0);
			final String away = teams.get(1);

			final String winner = results.get(i).equals(1) ? home : away;

			team2Points.putIfAbsent(winner, 0);
			team2Points.replace(winner, team2Points.get(winner) + 3);

			if (team2Points.get(winner) > winnerScore) {
				winnerScore = team2Points.get(winner);
				winning = winner;
			}
		}

		return winning;
	}
}
