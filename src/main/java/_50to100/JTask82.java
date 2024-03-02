package _50to100;

import se.embuc.Task;

import java.util.Arrays;

import static se.embuc.utils.FilesKt.readFileAsString;

// three ways sum
public class JTask82 implements Task {
	@Override
	public Object solve() {
		var map = readFileAsString("82_matrix.txt")
				.lines()
				.map(line -> Arrays.stream(line.split(","))
						.mapToInt(Integer::parseInt)
						.toArray())
				.toArray(int[][]::new);
		return findMinimumPathSum(map);
	}

	private static int findMinimumPathSum(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		int[][] dp = new int[rows][cols];
		for (int row = 0; row < rows; row++) {
			System.arraycopy(matrix[row], 0, dp[row], 0, cols);
		}

		for (int col = cols - 2; col >= 0; col--) {
			// First: Initialize with right neighbor
			for (int row = 0; row < rows; row++) {
				dp[row][col] += dp[row][col + 1];
			}

			// Second: Scan upwards, update if we find a shorter path
			for (int row = 1; row < rows; row++) {
				dp[row][col] = Math.min(dp[row][col], dp[row - 1][col] + matrix[row][col]);
			}

			// Third: ...and then downwards
			for (int row = rows - 2; row >= 0; row--) {
				dp[row][col] = Math.min(dp[row][col], dp[row + 1][col] + matrix[row][col]);
			}
		}

		// Find the minimum path sum in the leftmost column
		return Arrays.stream(dp).mapToInt(row -> row[0]).min().orElse(Integer.MAX_VALUE);
	}
}
