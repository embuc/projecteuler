package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task81

class Task81Test {

	@Test
	fun solve() {
		assertEquals(427337, Task81().solve())
		assertEquals(427337, JTask81().solve())
	}
}