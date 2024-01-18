package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task61

class Task61Test {

	@Test
	fun solve() {
		assertEquals(28684, Task61().solve())
		assertEquals(28684, JTask61().solve())
	}

}