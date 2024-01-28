package _50to100;

import se.embuc.Task;

import java.util.Arrays;

// Maximum path sum II
public class JTask67 implements Task {

	private final String input;

	public JTask67(String input) {
		this.input = input;
	}

	@Override
	public Object solve() {
		int[][] array = Arrays.stream(input.split("\n")).map(s -> s.split(" ")).map(
				strings -> Arrays.stream(strings).mapToInt(Integer::valueOf).toArray()).toArray(int[][]::new);
		for (int i = array.length - 2; i >= 0; i--) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] += Math.max(array[i + 1][j], array[i + 1][j + 1]);
			}
		}
		return array[0][0];
	}
}
