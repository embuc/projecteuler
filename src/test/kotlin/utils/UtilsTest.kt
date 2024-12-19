package utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import se.embuc.utils.*

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

	@ParameterizedTest
	@CsvSource(
		"1, 1",
		"12, 2",
		"123, 3",
		"1234, 4",
		"12345, 5",
		"123456, 6",
		"1234567, 7",
		"12345678, 8",
		"123456789, 9"
	)
	fun shouldGetIntMagnitude(input: Int, expected: Int) {
		assertEquals(expected, getIntMagnitude(input).second)
	}

	@Test
	fun shouldCheckArrayOfIntsMagnitude() {
		var arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
		assertEquals(9, arr.map { getIntMagnitude(it).second }.sum())
		arr = intArrayOf(12,123,4567)
		assertEquals(9, arr.map { getIntMagnitude(it).second }.sum())
	}

	@Test
	fun shouldFindPositiveIntegerRoot(){
		val integerRoot = findPositiveIntegerRoot(3 / 2.0, -1 / 2.0, -40755.0)
		assertEquals(165.0, integerRoot)
	}

	@Test
	fun shouldNotFindPositiveIntegerRoot(){
		val integerRoot = findPositiveIntegerRoot(3 / 2.0, -1 / 2.0, -40754.0)
		assertNull(integerRoot)
	}

	@Test
	fun solvePell(){
		assertEquals(3.toBigInteger(), solvePell(2).numerator)
		assertEquals(2.toBigInteger(), solvePell(3).numerator)
		assertEquals(9.toBigInteger(), solvePell(5).numerator)
		assertEquals(5.toBigInteger(), solvePell(6).numerator)
		assertEquals(8.toBigInteger(), solvePell(7).numerator)
		assertEquals(19.toBigInteger(), solvePell(10).numerator)
		assertEquals(649.toBigInteger(), solvePell(13).numerator)
		assertEquals(15.toBigInteger(), solvePell(14).numerator)
	}
}