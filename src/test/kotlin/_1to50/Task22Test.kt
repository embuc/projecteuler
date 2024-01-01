package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task22
import se.embuc.utils.readFileAsString

class Task22Test {

	@Test
	fun solve() {
		val input = readFileAsString("22_names.txt")
		assertEquals(871198282L, Task22(input).solve())
		assertEquals(871198282L, _1to50.JTask22(input).solve())
	}

	@Test
	fun solveExample() {
		val input = "COLIN"
		assertEquals(53, Task22(input).solve())
		assertEquals(53, _1to50.JTask22(input).solve())
	}

}