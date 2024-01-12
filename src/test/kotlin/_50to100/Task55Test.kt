package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task55

class Task55Test {

	@Test
	fun solve() {
		assertEquals(249, Task55().solve())
		assertEquals(249, JTask55().solve())
	}
}