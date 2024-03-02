package _50to100;

import se.embuc.Task;

import java.util.Arrays;

import static se.embuc.utils.FilesKt.readFileAsString;

//Path Sum: Two Ways
public class JTask81 implements Task {
	@Override
	public Object solve() {
		int [][] map = readFileAsString("81_matrix.txt")
				.lines()
				.map(line -> Arrays.stream(line.split(","))
						.mapToInt(Integer::parseInt)
						.toArray())
				.toArray(int[][]::new);

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (i == 0 && j == 0) continue;
				if (i == 0) {
					map[i][j] += map[i][j - 1];
					continue;
				}
				if (j == 0) {
					map[i][j] += map[i - 1][j];
					continue;
				}
				map[i][j] += Math.min(map[i - 1][j], map[i][j - 1]);
			}
		}

		return map[map.length - 1][map[0].length - 1];
	}
}
