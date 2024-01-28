package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task66

class Task66Test {

	@Test
	fun solve() {
		assertEquals(661, Task66().solve())
		assertEquals(661, JTask66().solve())
	}

}