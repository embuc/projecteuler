package _1to50;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

//Largest product in a grid
public class JTask11 implements Task {

	private final String input;

	public JTask11(String input) {
		this.input = input;
	}

	@NotNull
	@Override
	public Object solve() {
		int max = 0;
		int[][] grid = new int[20][20];
		String[] lines = input.split("\n");
		for (int i = 0; i < lines.length; i++) {
			String[] numbers = lines[i].split(" ");
			for (int j = 0; j < numbers.length; j++) {
				grid[i][j] = Integer.parseInt(numbers[j]);
			}
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length - 3; j++) {
				int product = grid[i][j] * grid[i][j + 1] * grid[i][j + 2] * grid[i][j + 3];
				if (product > max) {
					max = product;
				}
			}
		}
		for (int i = 0; i < grid.length - 3; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int product = grid[i][j] * grid[i + 1][j] * grid[i + 2][j] * grid[i + 3][j];
				if (product > max) {
					max = product;
				}
			}
		}
		for (int i = 0; i < grid.length - 3; i++) {
			for (int j = 0; j < grid[0].length - 3; j++) {
				int product = grid[i][j] * grid[i + 1][j + 1] * grid[i + 2][j + 2] * grid[i + 3][j + 3];
				if (product > max) {
					max = product;
				}
			}
		}
		for (int i = 0; i < grid.length - 3; i++) {
			for (int j = 3; j < grid[0].length; j++) {
				int product = grid[i][j] * grid[i + 1][j - 1] * grid[i + 2][j - 2] * grid[i + 3][j - 3];
				if (product > max) {
					max = product;
				}
			}
		}
		return max;
	}
}
