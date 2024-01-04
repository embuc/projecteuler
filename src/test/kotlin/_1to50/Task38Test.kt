package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task38

class Task38Test {

	@Test
	fun solve() {
		assertEquals(932718654, Task38().solve())
		assertEquals(932718654, JTask38().solve())
	}
}