package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task6

class Task6Test {

	@Test
	fun solve() {
		assertEquals(25164150L, Task6().solve())
		assertEquals(25164150L, _1to50.JTask6().solve())
	}
}