package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task56

class Task56Test {

	@Test
	fun solve() {
		assertEquals(972, Task56().solve())
		assertEquals(972, JTask56().solve())
	}
}