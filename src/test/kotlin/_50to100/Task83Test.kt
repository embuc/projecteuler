package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task83

class Task83Test {

	@Test
	fun solve() {
		assertEquals(425185, Task83().solve())
		assertEquals(425185, JTask83().solve())
	}
}