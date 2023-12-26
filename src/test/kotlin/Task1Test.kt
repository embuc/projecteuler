import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc.Task1

class Task1Test {

	@Test
	fun solve() {
		assertEquals(233168, Task1().solve())
		assertEquals(233168, JTask1().solve())
	}
}