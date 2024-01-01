package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task25

class Task25Test {

	@Test
	fun solve() {
		assertEquals(4782, Task25().solve())
		assertEquals(4782, _1to50.JTask25().solve())
	}
}