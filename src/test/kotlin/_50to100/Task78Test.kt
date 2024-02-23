package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task78

class Task78Test {

	@Test
	fun solve() {
		assertEquals(55374, Task78().solve())
		assertEquals(55374, JTask78().solve())
	}
}