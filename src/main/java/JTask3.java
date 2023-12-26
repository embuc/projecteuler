import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

/* Largest Prime factor */
public class JTask3 implements Task {

	private long number;

	public JTask3(long input) {
		this.number = input;
	}

	@NotNull
	@Override
	public Object solve() {
		long lowest = 1;
		while (lowest != number && number != 1) {
			lowest = findLowest(number);
			number = number / lowest;
		}
		return lowest;

	}

	private static int findLowest(long number) {
		int next = 2;
		int lowest = next;
		while ((number % next) != 0 && number >= next) {
			next++;
			lowest = next;
		}
		return lowest;
	}

}
