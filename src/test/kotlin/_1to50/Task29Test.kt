package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task29

class Task29Test {

	@Test
	fun solve() {
		assertEquals(9183, Task29().solve())
		assertEquals(9183, _1to50.JTask29().solve())
	}
}