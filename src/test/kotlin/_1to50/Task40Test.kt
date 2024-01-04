package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task40

class Task40Test {

	@Test
	fun solve() {
		assertEquals(210, Task40().solve())
		assertEquals(210, JTask40().solve())
	}
}