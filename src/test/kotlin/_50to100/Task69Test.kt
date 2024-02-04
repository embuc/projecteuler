package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task69

class Task69Test {

	@Test
	fun solve() {
		assertEquals(510510, Task69().solve())
		assertEquals(510510, JTask69().solve())
	}
}