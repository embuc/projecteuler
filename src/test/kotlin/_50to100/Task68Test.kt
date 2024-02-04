package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task68

class Task68Test {

	@Test
	fun solve() {
		assertEquals("6531031914842725", Task68().solve())
		assertEquals("6531031914842725", JTask68().solve())
	}
}