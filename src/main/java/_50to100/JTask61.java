package _50to100;

import se.embuc.Task;

import java.util.*;
import java.util.stream.Collectors;

import static se.embuc.utils.UtilsKt.*;

// Cyclical figurate numbers
public class JTask61 implements Task {

	enum NumType {
		Triangle,
		Square,
		Pentagonal,
		Hexagonal,
		Heptagonal,
		Octagonal
	}

	record Node(Integer value, NumType type) {
	}

	protected void dfs(Map<Node, List<Node>> graph, Node current, int targetLength, Set<Node> visited,
			List<Node> currentPath, Set<List<Node>> paths) {
//		break if right size and circular
		if (currentPath.size() == targetLength &&
				currentPath.get(0).value / 100 == currentPath.get(currentPath.size() - 1).value % 100) {
			paths.add(new ArrayList<>(currentPath)); // Add a copy of the current path
			return;
		}

		List<Node> nextNodes = graph.get(current);
		if (nextNodes != null) {
			for (Node next : nextNodes) {
				Set<NumType> types = currentPath.stream().map(Node::type).collect(Collectors.toSet());
				if (!visited.contains(next) && !types.contains(next.type)) {
					visited.add(next);
					currentPath.add(next);

					dfs(graph, next, targetLength, visited, currentPath, paths);

					// Backtrack
					visited.remove(next);
					currentPath.remove(currentPath.size() - 1);
				}
			}
		}
	}

	@Override
	public Object solve() {
		var triangles = new ArrayList<Node>();
		var squares = new ArrayList<Node>();
		var pentagonals = new ArrayList<Node>();
		var hexagonals = new ArrayList<Node>();
		var heptagonals = new ArrayList<Node>();
		var octagonals = new ArrayList<Node>();

		for (int i = 0; i < 10_000; i++) {
			int triangle = getTriangleNumber(i);
			if (triangle > 999 && triangle < 10_000) {triangles.add(new Node(triangle, NumType.Triangle));}
			int square = getSquareNumber(i);
			if (square > 999 && square < 10_000) {squares.add(new Node(square, NumType.Square));}
			int pentagonal = getPentagonalNumber(i);
			if (pentagonal > 999 && pentagonal < 10_000) {pentagonals.add(new Node(pentagonal, NumType.Pentagonal));}
			int hexagonal = getHexagonalNumber(i);
			if (hexagonal > 999 && hexagonal < 10_000) {hexagonals.add(new Node(hexagonal, NumType.Hexagonal));}
			int heptagonal = getHeptagonalNumber(i);
			if (heptagonal > 999 && heptagonal < 10_000) {heptagonals.add(new Node(heptagonal, NumType.Heptagonal));}
			int octagonal = getOctagonalNumber(i);
			if (octagonal > 999 && octagonal < 10_000) {octagonals.add(new Node(octagonal, NumType.Octagonal));}
		}
		var graph = buildGraph(triangles, squares, pentagonals, hexagonals, heptagonals, octagonals);
		var paths = findPathsOfLength(graph, 6);
		//there will be 6 paths but they are all the same only starting from different sets
		return paths.iterator().next().stream().mapToInt(Node::value).sum();
	}

	private Map<Node, List<Node>> buildGraph(List<Node>... lists) {
		var graph = new HashMap<Node, List<Node>>();
		for (int i = 0; i < lists.length; i++) {
			var currentList = lists[i];
			for (var num : currentList) {
				var suffix = num.value % 100; // Last two digits of the current number
				for (int j = 0; j < lists.length; j++) {
					if (i == j) {
						continue;// Skip the current list if same as the outer loop
					}
					var otherList = lists[j];
					for (var nextNum : otherList) {
						var prefix = nextNum.value / 100; // First two digits of the next number
						if (suffix == prefix) {
							graph.computeIfAbsent(num, k -> new ArrayList<>()).add(nextNum);
						}
					}
				}
			}
		}

		return graph;
	}

	protected Set<List<Node>> findPathsOfLength(Map<Node, List<Node>> graph, int length) {
		Set<List<Node>> paths = new HashSet<>();

		for (Node start : graph.keySet()) {
			Set<Node> visited = new HashSet<>();
			visited.add(start);

			List<Node> currentPath = new ArrayList<>();
			currentPath.add(start);

			dfs(graph, start, length, visited, currentPath, paths);
		}

		return paths;
	}

}
