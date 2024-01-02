package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task34

class Task34Test {

	@Test
	fun solve() {
		assertEquals(40730, Task34().solve())
		assertEquals(40730, JTask34().solve())
	}
}