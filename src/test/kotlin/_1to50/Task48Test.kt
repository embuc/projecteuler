package _1to50

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._1to50.Task48

class Task48Test {

	@Test
	fun solve() {
//		val time = measureTimeMillis {
			assertEquals("9110846700", Task48().solve())
			assertEquals("9110846700", JTask48().solve())
//		}
//		println("Task 48 took $time ms")
	}
}