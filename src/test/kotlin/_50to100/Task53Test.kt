package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task53

class Task53Test {

	@Test
	fun solve() {
		assertEquals(4075, Task53().solve())
		assertEquals(4075, JTask53().solve())
	}
}