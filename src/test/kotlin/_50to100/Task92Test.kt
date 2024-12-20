package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task92

class Task92Test {

	@Test
	fun solve() {
		assertEquals(8581146, Task92().solve())
		assertEquals(8581146, JTask92().solve())
	}
}