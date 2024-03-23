package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task86

class Task86Test {

	@Test
	fun solve() {
		assertEquals(1818, Task86().solve())
		assertEquals(1818, JTask86().solve())
	}
}