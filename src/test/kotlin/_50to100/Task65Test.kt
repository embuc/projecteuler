package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task65
import java.math.BigInteger

class Task65Test {

	@Test
	fun solve() {
		assertEquals(272, Task65().solve())
		assertEquals(272, JTask65().solve())
	}

	@Test
	fun testEulerConvergents() {
		assertEquals(Pair(BigInteger("2"), BigInteger("1")), Task65().computeEConvergent(1))
		assertEquals(Pair(BigInteger("3"), BigInteger("1")), Task65().computeEConvergent(2))
		assertEquals(Pair(BigInteger("8"), BigInteger("3")), Task65().computeEConvergent(3))
		assertEquals(Pair(BigInteger("11"), BigInteger("4")), Task65().computeEConvergent(4))
		assertEquals(Pair(BigInteger("19"), BigInteger("7")), Task65().computeEConvergent(5))
		assertEquals(Pair(BigInteger("87"), BigInteger("32")), Task65().computeEConvergent(6))
		assertEquals(Pair(BigInteger("106"), BigInteger("39")), Task65().computeEConvergent(7))
		assertEquals(Pair(BigInteger("193"), BigInteger("71")), Task65().computeEConvergent(8))
		assertEquals(Pair(BigInteger("1264"), BigInteger("465")), Task65().computeEConvergent(9))
		assertEquals(Pair(BigInteger("1457"), BigInteger("536")), Task65().computeEConvergent(10))
	}
}