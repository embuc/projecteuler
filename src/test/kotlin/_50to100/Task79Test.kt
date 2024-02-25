package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task79

class Task79Test {

	@Test
	fun solve() {
		assertEquals("73162890", Task79().solve())
		assertEquals("73162890", JTask79().solve())
	}
}