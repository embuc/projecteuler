package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task15
import java.math.BigInteger

class Task15Test {

	@Test
	fun solve() {
		assertEquals(BigInteger.valueOf(137846528820), Task15(20).solve())
		assertEquals(BigInteger.valueOf(137846528820), _1to50.JTask15(20).solve())
	}

	@Test
	fun solveExample() {
		assertEquals(BigInteger.valueOf(6), Task15(2).solve())
		assertEquals(BigInteger.valueOf(6), _1to50.JTask15(2).solve())
	}
}