package _50to100;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

import java.util.Arrays;
import java.util.PriorityQueue;

import static se.embuc.utils.FilesKt.readFileAsString;

// Path Sum: Four Ways
public class JTask83 implements Task {
	@NotNull
	@Override
	public Object solve() {
		var map = readFileAsString("82_matrix.txt")
				.lines()
				.map(line -> Arrays.stream(line.split(","))
						.mapToInt(Integer::parseInt)
						.toArray())
				.toArray(int[][]::new);
		return aStar(map);
	}

	static class Node implements Comparable<Node> {
		int row;
		int col;
		int cost;
		int estimate;

		Node(int row, int col, int cost, int estimate) {
			this.row = row;
			this.col = col;
			this.cost = cost;
			this.estimate = estimate;
		}

		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.cost + this.estimate, other.cost + other.estimate);
		}
	}

	public static int aStar(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		Pair goal = new Pair(rows - 1, cols - 1);

		PriorityQueue<Node> openSet = new PriorityQueue<>();
		openSet.add(new Node(0, 0, matrix[0][0], heuristic(0, 0, goal)));

		int[][] costSoFar = new int[rows][cols];
		for (int[] row : costSoFar) {
			java.util.Arrays.fill(row, Integer.MAX_VALUE);
		}
		costSoFar[0][0] = matrix[0][0];

		while (!openSet.isEmpty()) {
			Node current = openSet.poll();

			if (current.row == goal.row && current.col == goal.col) {
				return costSoFar[goal.row][goal.col];
			}

			int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
			for (int[] dir : directions) {
				int nextRow = current.row + dir[0];
				int nextCol = current.col + dir[1];

				if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
					continue;
				}

				int newCost = costSoFar[current.row][current.col] + matrix[nextRow][nextCol];
				if (newCost < costSoFar[nextRow][nextCol]) {
					costSoFar[nextRow][nextCol] = newCost;
					int priority = newCost + heuristic(nextRow, nextCol, goal);
					openSet.add(new Node(nextRow, nextCol, newCost, priority));
				}
			}
		}

		return -1; // Goal not reachable
	}

	private static int heuristic(int row, int col, Pair goal) {
		return Math.abs(row - goal.row) + Math.abs(col - goal.col);
	}

	static class Pair {
		int row;
		int col;

		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
