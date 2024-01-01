package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task21
import se.embuc.utils.getDivisorsSum

class Task21Test {

	@Test
	fun solve() {
		assertEquals(31626L, Task21().solve())
		assertEquals(31626L, _1to50.JTask21().solve())
	}

	@Test
	fun solveExample() {
		assertEquals(220L, getDivisorsSum(284L))
		assertEquals(284L, getDivisorsSum(220L))
	}
}