package _1to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to100.Task26

class Task26Test {

	@Test
	fun solve() {
		assertEquals(983, Task26().solve())
		assertEquals(983, _1to50.JTask26().solve())
	}
}