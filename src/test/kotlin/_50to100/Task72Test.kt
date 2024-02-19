package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task72

class Task72Test {

	@Test
	fun solve() {
		assertEquals(303963552391L, Task72().solve())
		assertEquals(303963552391L, JTask72().solve())
	}
}