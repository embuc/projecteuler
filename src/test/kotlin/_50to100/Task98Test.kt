package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task98

class Task98Test {

	@Test
	fun solve() {
		assertEquals(18769L, Task98().solve())
		assertEquals(18769L, JTask98().solve())
	}
}