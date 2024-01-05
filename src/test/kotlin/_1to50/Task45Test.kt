package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task45

class Task45Test {
	@Test
	fun solve() {
		assertEquals(1533776805L, Task45().solve())
		assertEquals(1533776805L, JTask45().solve())
	}
}