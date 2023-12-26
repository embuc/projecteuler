import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc.Task2

class Task2Test {

	@Test
	fun solve() {
		assertEquals(4613732, Task2().solve())
		assertEquals(4613732, JTask2().solve())
	}
}