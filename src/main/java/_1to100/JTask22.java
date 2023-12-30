package _1to100;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

import java.util.Arrays;

// Names Scores
public class JTask22 implements Task {
	@NotNull
	private final String input;

	public JTask22(@NotNull String input) {this.input = input;}

	@Override
	public Long solve() {
		var list = Arrays.stream(input.replace("\"","")
				.split(","))
				.sorted()
				.map(this::toNameScore)
				.toList();
		long sum = 0L;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i) * (i + 1);
		}
		return sum;
	}

	long toNameScore(String s) {
		long sum = 0L;
		for (int i = 0; i < s.length(); i++) {
			sum += s.charAt(i) - 'A' + 1;
		}
		return sum;
	}
}
