package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task31

class Task31Test {

	@Test
	fun solve() {
		assertEquals(73682, Task31().solve())
		assertEquals(73682, JTask31().solve())
	}
}