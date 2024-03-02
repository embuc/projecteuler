package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task82

class Task82Test {

	@Test
	fun solve() {
		assertEquals(260324, Task82().solve())
		assertEquals(260324, JTask82().solve())
	}
}