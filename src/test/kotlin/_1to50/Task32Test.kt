package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task32

class Task32Test {

	@Test
	fun solve() {
		assertEquals(45228, Task32().solve())
		assertEquals(45228, JTask32().solve())
	}
}