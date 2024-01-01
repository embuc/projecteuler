package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task31

class Task31Test {

	@Test
	fun solve() {
		val coins = intArrayOf(1, 2, 5, 10, 20, 50, 100, 200)
		val amount = 200
		assertEquals(73682, Task31(coins, amount).solve())
		assertEquals(73682, JTask31(coins, amount).solve())
	}

	@Test
	fun solveSmallerExample() {
		val coins = intArrayOf(1, 2, 5, 10)
		val amount = 10

		assertEquals(11, Task31(coins, amount).solve())
		assertEquals(11, JTask31(coins, amount).solve())
	}
}