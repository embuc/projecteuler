package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task60

class Task60Test {

	@Test
	fun solve() {
		assertEquals(26033, Task60().solve())
		assertEquals(26033, JTask60().solve())
	}
}