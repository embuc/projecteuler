package utils

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import se.embuc.utils.Utils.isPrime

class UtilsTest {

	@ParameterizedTest
	@ValueSource(longs = [2, 3, 5, 7, 11, 13, 17])
	fun checkIsPrime(n: Long) {
		assertEquals(true, isPrime(n))
	}

	@Test
	fun isPalindrome() {
	}

	@Test
	fun gcd() {
	}

	@Test
	fun lcm() {
	}

	@Test
	fun factorial() {
	}

	@Test
	fun fibonacci() {
	}
}