package _50to100

import org.junit.jupiter.api.Test
import se.embuc._50to100.Task97
import kotlin.test.assertEquals

class Task97Test {

	@Test
	fun solve() {
		assertEquals(8739992577L, Task97().solve())
		assertEquals(8739992577L, JTask97().solve())
	}
}