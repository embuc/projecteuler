package _50to100

import org.junit.jupiter.api.Test
import se.embuc._50to100.Task96
import se.embuc.utils.readFileAsString
import kotlin.test.assertEquals

class Task96Test {

	@Test
	fun solve() {
		val input = readFileAsString("p096_sudoku.txt")
		assertEquals(24702, Task96(input).solve())
		assertEquals(24702, JTask96(input).solve())
	}
}