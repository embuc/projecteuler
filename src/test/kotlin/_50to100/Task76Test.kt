package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task76

class Task76Test {

	@Test
	fun solve() {
		assertEquals(190569291, Task76().solve())
		assertEquals(190569291, JTask76().solve())
	}
}