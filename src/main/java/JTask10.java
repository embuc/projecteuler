import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

import static se.embuc.utils.UtilsKt.sumOfPrimesBelow;

/** Summation of primes */
public class JTask10 implements Task {
	@NotNull
	@Override
	public Object solve() {
		return sumOfPrimesBelow(2_000_000);
	}

}
