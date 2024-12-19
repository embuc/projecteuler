package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task88

class Task88Test {
	@Test
	fun solve() {

		assertEquals(4, Task88().minimalProductSumNumbersDP(2))
		assertEquals(10, Task88().minimalProductSumNumbersDP(3))
		assertEquals(30, Task88().minimalProductSumNumbersDP(6))
		assertEquals(61, Task88().minimalProductSumNumbersDP(12))
		assertEquals(7587457, Task88().solve())
		assertEquals(7587457, JTask88().solve())
	}

}