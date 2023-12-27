import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc.Task12

class Task12Test {

	@Test
	fun solve() {
		assertEquals(76576500L, Task12().solve())
		assertEquals(76576500L, JTask12().solve())
	}
}