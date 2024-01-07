package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task52

class Task52Test {

	@Test
	fun solve() {
		assertEquals(142857, Task52().solve())
		assertEquals(142857, JTask52().solve())
	}
}