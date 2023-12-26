import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import se.embuc.Task2

class JTask2Test {

	@Test
	fun solve() {
		assertEquals(4613732, Task2().solve())
		assertEquals(4613732, JTask2().solve())
	}
}