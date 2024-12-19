package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task87

class Task87Test {

	@Test
	fun solve() {
		assertEquals(1097343, Task87().solve())
		assertEquals(1097343, JTask87().solve())
	}
}