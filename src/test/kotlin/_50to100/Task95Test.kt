package _50to100

import org.junit.jupiter.api.Test
import se.embuc._50to100.Task95
import kotlin.test.assertEquals

class Task95Test {

	@Test
	fun solve() {
		assertEquals(14316, Task95().solve())
		assertEquals(14316, JTask95().solve())
	}
}