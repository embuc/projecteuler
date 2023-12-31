package _1to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to100.Task24

class Task24Test {

	@Test
	fun solve() {
		assertEquals("2783915460", Task24().solve())
		assertEquals("2783915460", JTask24().solve())
	}
}