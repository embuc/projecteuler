package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task89

class Task89Test {

	@Test
	fun solve() {
		assertEquals(743, Task89().solve())
		assertEquals(743, JTask89().solve())
	}
}