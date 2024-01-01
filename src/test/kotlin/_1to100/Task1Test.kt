package _1to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task1

class Task1Test {

	@Test
	fun solve() {
		assertEquals(233168, se.embuc._1to50.Task1().solve())
		assertEquals(233168, _1to50.JTask1().solve())
	}
}