package utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import se.embuc.utils.findNextPrime
import se.embuc.utils.isPrime

class UtilsTest {

	@ParameterizedTest
	@ValueSource(longs = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 7_652_413])
	fun checkIsPrime(n: Long) {
		assertEquals(true, isPrime(n))
	}

	@Test
	fun checkIsPrime() {
		assertEquals(true, isPrime(5))
	}

	@ParameterizedTest
	@CsvSource(
		"2, 3",  // Next prime after 2 is 3
		"3, 5",  // Next prime after 3 is 5
		"17, 19", // Next prime after 17 is 19
		"20, 23", // Next prime after 20 is 23
		"37, 41"  // Next prime after 37 is 41
	)
	fun findNextPrimeTest(input: Long, expected: Long) {
		assertEquals(expected, findNextPrime(input))
	}

}