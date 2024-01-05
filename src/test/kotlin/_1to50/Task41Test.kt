package _1to50

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task41
import se.embuc.utils.isPanDigit
import se.embuc.utils.isPrime
import kotlin.test.Ignore

class Task41Test {

	@Test
	fun solve() {
		assertEquals("7652413", Task41().solve())
		assertEquals(7652413, JTask41().solve())
	}

	@Ignore
	@Test
	fun test() {
		assertTrue(isPrime(7_652_413))
		assertTrue(isPanDigit(intArrayOf(7652413)))
		assertTrue(isPrime(2143))
		assertTrue(isPanDigit(intArrayOf(2143)))
		assertTrue(isPrime(98_765_431))
		assertFalse(isPanDigit(intArrayOf(98765431)))// this is not a pan digit, but it does have unique digits
	}
}