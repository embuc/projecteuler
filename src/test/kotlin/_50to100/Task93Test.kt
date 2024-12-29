package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task93

class Task93Test {

	@Test
	fun solve() {
		assertEquals("1258", Task93().solve())
		assertEquals("1258", JTask93().solve())
	}

}