import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import se.embuc.Task1

class JTask1Test {

	@Test
	fun solve() {
		assertEquals(233168, Task1().solve())
		assertEquals(233168, JTask1().solve())
	}
}