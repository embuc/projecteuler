import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc.Task4

class Task4Test {

	@Test
	fun solve() {
		assertEquals(906609, Task4().solve());
		assertEquals(906609, JTask4().solve());
	}
}