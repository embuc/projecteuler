package _1to50

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task37
import se.embuc.utils.getPrimesSieveBelow
import kotlin.test.Ignore

class Task37Test {

	@Test
	fun solve() {
		assertEquals(748317, Task37().solve())
		assertEquals(748317, JTask37().solve())
	}

	@Ignore
	@Test
	fun checkIsTrucatablePrime() {
		val sieve = getPrimesSieveBelow(1_000_000);
		assertFalse(Task37().isTruncatablePrime(59, sieve))
		assertTrue(Task37().isTruncatablePrime(53, sieve))
		assertTrue(Task37().isTruncatablePrime(23, sieve))
	}
}