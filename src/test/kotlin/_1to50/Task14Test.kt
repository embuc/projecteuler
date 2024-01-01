package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task14
import kotlin.test.Ignore

class Task14Test {

	@Test
	fun solve() {
		assertEquals(837799L, Task14().solve())
		assertEquals(837799L, _1to50.JTask14().solve())
	}

	@Ignore
	@Test
	fun findColatzSeqLength() {
		assertEquals(10, Task14().findColatzSeqLength(13))
	}
}
