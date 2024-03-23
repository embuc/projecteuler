package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task85

class Task85Test {

	@Test
	fun solve() {
		assertEquals(2772, Task85().solve())
		assertEquals(2772, JTask85().solve())
	}
}