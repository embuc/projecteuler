package _1to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to100.Task5

/** Smallest Multiple */
class Task5Test{

	@Test
	fun solve() {
		assertEquals(232792560L, Task5().solve());
		assertEquals(232792560L, JTask5().solve());
	}
}