package com.lbarc.aglo.exercises.algoexpert.airportconnections;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Program {

	public static int airportConnections(List<String> airports, List<List<String>> routes, String startingAirport) {
		final Map<String, List<String>> graph = new HashMap<>();
		airports.forEach(airport ->
				graph.put(
						airport,
						routes.stream()
								.filter(a -> a.get(0).equals(airport))
								.map(a -> a.get(1))
								.collect(Collectors.toList())
				)
		);
		Set<String> alreadyReachable = getReachableFrom(startingAirport, graph, new HashSet<>());
		int result = 0;
		while (alreadyReachable.size() != airports.size()) {
			result++;
			final Map<String, Set<String>> score = new HashMap<>();
			for (String airport : airports) {
				score.put(airport, getReachableFrom(airport, graph, alreadyReachable));
			}
			final Set<String> finalAlreadyReachable = alreadyReachable;
			final String mostValuableAirport =
					score.entrySet().stream()
							.filter(a -> !finalAlreadyReachable.contains(a.getKey()))
							.max(Comparator.comparingInt(o -> o.getValue().size())).orElseThrow(IllegalStateException::new).getKey();
			graph.get(startingAirport).add(mostValuableAirport);
			alreadyReachable = getReachableFrom(startingAirport, graph, alreadyReachable);
		}

		return result;
	}

	private static Set<String> getReachableFrom(String startingAirport, Map<String, List<String>> graph, Set<String> alreadyReachable) {
		final Set<String> alreadyVisited = new HashSet<>();
		final Queue<String> toVisit = new ArrayDeque<>();
		toVisit.add(startingAirport);
		while (!toVisit.isEmpty()) {
			String currentAirport = toVisit.poll();
			if (alreadyVisited.add(currentAirport)) {
				if (!alreadyReachable.contains(currentAirport) && !currentAirport.equals(startingAirport)) {
					alreadyVisited.add(currentAirport);
				}
				toVisit.addAll(graph.get(currentAirport));
			}
		}
		return alreadyVisited;
	}

	public static void main(String[] args) {
		final List<String> airports =
				Arrays.asList("BGI", "CDG", "DEL", "DOH", "DSM", "EWR", "EYW", "HND", "ICN", "JFK", "LGA", "LHR", "ORD", "SAN", "SFO", "SIN", "TLV", "BUD");
		final List<List<String>> connections = Arrays.asList(
				Arrays.asList("DSM", "ORD"),
				Arrays.asList("ORD", "BGI"),
				Arrays.asList("BGI", "LGA"),
				Arrays.asList("SIN", "CDG"),
				Arrays.asList("CDG", "SIN"),
				Arrays.asList("CDG", "BUD"),
				Arrays.asList("DEL", "DOH"),
				Arrays.asList("DEL", "CDG"),
				Arrays.asList("TLV", "DEL"),
				Arrays.asList("EWR", "HND"),
				Arrays.asList("HND", "ICN"),
				Arrays.asList("HND", "JFK"),
				Arrays.asList("ICN", "JFK"),
				Arrays.asList("JFK", "LGA"),
				Arrays.asList("EYW", "LHR"),
				Arrays.asList("LHR", "SFO"),
				Arrays.asList("SFO", "SAN"),
				Arrays.asList("SFO", "DSM"),
				Arrays.asList("SAN", "EYW")
		);
		airportConnections(airports, connections, "LGA");
	}
}
