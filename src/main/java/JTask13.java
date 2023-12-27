import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

import java.math.BigInteger;
import java.util.Arrays;

//Large sum
public class JTask13 implements Task {
	@NotNull
	private final String input;

	public JTask13(@NotNull String input) {this.input = input;}

	@Override
	public Object solve() {
		return Arrays.stream(input.split("\n")).map(String::trim).map(BigInteger::new).reduce(
				BigInteger::add).get().toString();
	}
}
