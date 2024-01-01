package _1to50;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

import java.util.Arrays;
import java.util.List;

public class JTask18 implements Task {

	@NotNull
	private final List<String> input;

	public JTask18(@NotNull List<String> input) {this.input = input;}

	@NotNull
	@Override
	public Object solve() {
		int[][] triangle = input.stream().map(s -> s.split(" "))
				.map(strings -> Arrays.stream(strings).mapToInt(Integer::valueOf).toArray())
				.toArray(int[][]::new);
		for (int i = triangle.length - 2; i >= 0; i--) {
			for (int j = 0; j < triangle[i].length; j++) {
				triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
			}
		}
		return triangle[0][0];
	}
}
