import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc.Task7

class Task7Test {

	@Test
	fun solve() {
		assertEquals(104743L, Task7().solve())
		assertEquals(104743L, JTask7().solve())
	}
}