package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task63

class Task63Test {

	@Test
	fun solve() {
		assertEquals(49, Task63().solve())
		assertEquals(49, JTask63().solve())
	}
}