package _50to100;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

//Large Non-Mersenne Prime
public class JTask97 implements Task {

	@NotNull
	@Override
	public Object solve() {
		long num = 2L;
		for (int i = 1; i < 7_830_457; i++) {
			num = (num * 2) % 10_000_000_000L;
		}
		num = (num * 28433) % 10_000_000_000L;
		return num + 1;
	}
}
