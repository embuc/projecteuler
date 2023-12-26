import org.junit.jupiter.api.Test;
import se.embuc.Task4;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

	@Test
	void solve() {
		assertEquals(906609, Task4().solve());
		assertEquals(906609, JTask4().solve());
	}
}