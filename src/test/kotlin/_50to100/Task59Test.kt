package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task59

class Task59Test {

	@Test
	fun solve() {
		assertEquals(129448, Task59().solve())
		assertEquals(129448, JTask59().solve())
	}
}