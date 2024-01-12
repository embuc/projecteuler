package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task57

class Task57Test {

	@Test
	fun solve() {
		assertEquals(153, Task57().solve())
		assertEquals(153, JTask57().solve())
	}
}