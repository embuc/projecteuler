package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task64

class Task64Test {

	@Test
	fun solve() {
		assertEquals(1322, Task64().solve())
		assertEquals(1322, JTask64().solve())
	}

	@Test
	fun shouldFindOddCycle() {
		assertTrue(JTask64().getRecurringContinuousFractionCycle(2) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(5) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(10) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(13) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(17) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(26) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(29) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(37) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(41) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(50) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(53) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(58) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(61) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(65) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(73) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(74) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(82) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(85) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(89) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(97) % 2 == 1)

		assertTrue(JTask64().getRecurringContinuousFractionCycle(9865) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(9866) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(9938) % 2 == 1)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(9997) % 2 == 1)
	}

	@Test
	fun shouldFindEvenCycle() {
		assertTrue(JTask64().getRecurringContinuousFractionCycle(3) % 2 == 0)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(6) % 2 == 0)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(7) % 2 == 0)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(8) % 2 == 0)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(11) % 2 == 0)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(12) % 2 == 0)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(14) % 2 == 0)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(15) % 2 == 0)
		assertTrue(JTask64().getRecurringContinuousFractionCycle(18) % 2 == 0)
	}
}