package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task90

class Task90Test {

	@Test
	fun solve() {
		assertEquals(1217, Task90().solve())
		assertEquals(1217, JTask90().solve())
	}


}