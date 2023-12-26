import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import se.embuc.Task3

class JTask3Test {

	@Test
	fun solve() {
		val input = 600851475143L
		assertEquals(6857L, Task3(input).solve())
		assertEquals(6857L, JTask3(input).solve())
	}
}