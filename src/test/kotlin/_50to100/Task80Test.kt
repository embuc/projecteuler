package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task80

class Task80Test {

	@Test
	fun solve() {
		assertEquals(40886, Task80().solve())
		assertEquals(40886, JTask80().solve())
	}
}