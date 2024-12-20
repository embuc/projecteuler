package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task91

class Task91Test {

	@Test
	fun solve() {
		assertEquals(14234, Task91(50).solve())
		assertEquals(14, JTask91(2).solve())
		assertEquals(33, JTask91(3).solve())
		assertEquals(14234, JTask91(50).solve())
	}
}