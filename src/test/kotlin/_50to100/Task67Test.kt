package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task67
import se.embuc.utils.readFileAsString

class Task67Test {

	@Test
	fun solve() {
		assertEquals(7273, Task67(readFileAsString("67_triangle.txt")).solve())
		assertEquals(7273, JTask67(readFileAsString("67_triangle.txt")).solve())
	}
}