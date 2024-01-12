package _50to100

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import se.embuc._50to100.Task54

// Poker hands
class Task54Test {

	@Test
	fun solve() {
		assertEquals(376, Task54().solve())
		assertEquals(376, JTask54().solve())
	}

	@Test
	fun shouldEvaluate() {
		// pair of fives
		var hand = Task54.Hand("5H 5C 6S 7S KD".split(" ").map { Task54.Card(it) })
		// pair of eights
		var hand2 = Task54.Hand("2C 3S 8S 8D TD".split(" ").map { Task54.Card(it) })
		var winner = hand.compareTo(hand2)
		assertEquals(-1, winner)
		// Highest card Ace
		hand = Task54.Hand("5D 8C 9S JS AC".split(" ").map { Task54.Card(it) })
		// Highest card Queen
		hand2 = Task54.Hand("2C 5C 7D 8S QH".split(" ").map { Task54.Card(it) })
		winner = hand.compareTo(hand2)
		assertEquals(1, winner)
	}

	@Test
	fun shouldEvaluateHighestCard() {
		// Highest card Ace
		var hand = JTask54().Hand("5D 8C 9S JS AC".split(" ").map { JTask54().Card(it) })
	// Highest card Queen
		var hand2 = JTask54().Hand("2C 5C 7D 8S QH".split(" ").map { JTask54().Card(it) })
		var winner = hand.compareTo(hand2)
		assertEquals(1, winner)
	}
}