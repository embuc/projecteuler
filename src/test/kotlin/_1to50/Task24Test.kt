package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task24

class Task24Test {

	@Test
	fun solve() {
		assertEquals("2783915460", Task24().solve())
		assertEquals("2783915460", _1to50.JTask24().solve())
	}
}