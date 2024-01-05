package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task43

class Task43Test {

	@Test
	fun solve() {
		assertEquals(16695334890L, Task43().solve())
		assertEquals(16695334890L, JTask43().solve())
	}

}