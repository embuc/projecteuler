package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task58

class Task58Test {

	@Test
	fun solve() {
		assertEquals(26241, Task58().solve())
		assertEquals(26241, JTask58().solve())
	}
}