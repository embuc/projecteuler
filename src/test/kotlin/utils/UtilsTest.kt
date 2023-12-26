package utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc.utils.isPrime

class UtilsTest {

//	@ParameterizedTest
//	@ValueSource(longs = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29])
	fun checkIsPrime(n: Long) {
		assertEquals(true, isPrime(n))
	}

	@Test
	fun checkIsPrime() {
		assertEquals(true, isPrime(5))
	}

}