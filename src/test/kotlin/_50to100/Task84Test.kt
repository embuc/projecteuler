package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task84

class Task84Test {

	@Test
	fun solve() {
		assertEquals("101524", Task84().solve())
		assertEquals("101524", JTask84().solve())
	}
}