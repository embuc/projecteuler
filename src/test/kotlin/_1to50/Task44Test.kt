package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task44

class Task44Test {

	@Test
	fun solve() {
		assertEquals(5482660, Task44().solve())
		assertEquals(5482660, JTask44().solve())
	}
}