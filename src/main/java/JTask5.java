import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

import static se.embuc.utils.UtilsKt.lcm;

/** Smallest Multiple */
public class JTask5 implements Task {
	@NotNull
	@Override
	public Object solve() {
		long result = 1L;
		for (int i = 1; i <= 20; i++) {
			result = lcm(result, i);
		}
		return result;
	}

}
