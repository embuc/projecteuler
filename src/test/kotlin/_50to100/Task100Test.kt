package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task100

class Task100Test {

	@Test
	fun solve() {
		assertEquals(756872327473L, Task100().solve())
		assertEquals(756872327473L, JTask100().solve())
	}
}