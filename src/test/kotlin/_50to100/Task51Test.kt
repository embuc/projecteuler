package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task51

class Task51Test {

	@Test
	fun solve() {
		assertEquals(121313, Task51().solve())
		assertEquals(121313, JTask51().solve())
	}
}