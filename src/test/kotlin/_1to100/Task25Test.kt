package _1to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to100.Task25

class Task25Test {

	@Test
	fun solve() {
		assertEquals(4782, Task25().solve())
		assertEquals(4782, _1to50.JTask25().solve())
	}
}