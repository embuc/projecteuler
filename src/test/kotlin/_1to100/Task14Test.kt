package _1to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to100.Task14

class Task14Test {

	@Test
	fun solve() {
		assertEquals(837799L, Task14().solve())
		assertEquals(837799L, JTask14().solve())
	}

	@Test
	fun findColatzSeqLength() {
		assertEquals(10, Task14().findColatzSeqLength(13))
	}
}