import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc.Task6

class Task6Test {

	@Test
	fun solve() {
		assertEquals(25164150L, Task6().solve())
		assertEquals(25164150L, JTask6().solve())
	}
}