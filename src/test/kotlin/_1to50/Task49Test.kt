package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task49
import se.embuc.utils.isPermutation

class Task49Test {

	@Test
	fun solve() {
		assertEquals("296962999629", Task49().solve())
		assertEquals("296962999629", JTask49().solve())
	}

	@Test
	fun shouldFindPermutation() {
		assertEquals(true, isPermutation(1487, 4817))
		assertEquals(false, isPermutation(1487, 4818))
	}
}