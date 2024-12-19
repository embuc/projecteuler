package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.readFileAsString
import kotlin.math.sign

// Poker hands
class Task54 : Task {
	override fun solve(): Any {
		val games = readFileAsString("54_poker.txt").lines().map { parseGame(it) }
		var countPlayer1 = 0
		for (game in games) {
			if (game.hand1.compareTo(game.hand2) > 0) {
				countPlayer1++
			}
		}
		return countPlayer1
	}

	data class Card(val s: String) : Comparable<Card> {
		val value: Int
		val suit: Char

		init {
			value = when (s[0]) {
				'T' -> 10
				'J' -> 11
				'Q' -> 12
				'K' -> 13
				'A' -> 14
				else -> s[0].toString().toInt()
			}
			suit = s[1]
		}

		override fun compareTo(other: Card): Int {
			return this.value.compareTo(other.value)
		}
	}

	data class Game(val hand1: Hand, val hand2: Hand)
	data class Hand(val hand: List<Card>) : Comparable<Hand> {
		var soretedCards: List<Int>
		var score: Int = 0

		init {
			val (score, sortedCards) = evaluateHand()
			this.score = score
			this.soretedCards = sortedCards
		}

		private fun evaluateHand(): Pair<Int, List<Int>> {
			val cardCounts = hand.groupingBy { it.value }.eachCount()
			// Sort cards based on frequency, then by their poker value
			val sortedCards = cardCounts.entries.sortedWith(
				compareByDescending<Map.Entry<Int, Int>> { it.value }
					.thenByDescending { it.key }
			).map { it.key }

			val isFlush = hand.map { it.suit }.distinct().size == 1

			val sortedValues = hand.map { it.value }.sorted()
			val isStraight = sortedValues.zipWithNext().all { (a, b) -> b - a == 1 }

			val isStraightFlush = isFlush && isStraight
			val isRoyalFlush = isFlush && sortedValues == listOf(10, 11, 12, 13, 14)

			val score = when {
				isRoyalFlush -> 10
				isStraightFlush -> 9
				cardCounts.any { it.value == 4 } -> 8 // Four of a kind
				cardCounts.size == 2 && cardCounts.any { it.value == 3 } -> 7 // Full house
				isFlush -> 6
				isStraight -> 5
				cardCounts.any { it.value == 3 } -> 4 // Three of a kind
				cardCounts.size == 3 -> 3 // Two pair
				cardCounts.size == 4 -> 2 // One pair
				else -> 1 // High card
			}

			return Pair(score, sortedCards)
		}

		override fun compareTo(other: Hand): Int {
			return this.score.compareTo(other.score).let { if (it != 0) it else compareLexicographically(this.soretedCards, other.soretedCards) }
		}

		private fun compareLexicographically(handA: List<Int>, handB: List<Int>): Int {
			handA.forEachIndexed { index, charA ->
				val charB = handB[index]
				val diff = charA - charB
				if (diff != 0) return diff.sign
			}
			return 0
		}
	}

	private fun parseGame(s: String): Game {
		val cards = s.split(" ")
		val player1 = Hand(cards.subList(0, 5).map { Card(it) })
		val player2 = Hand(cards.subList(5, 10).map { Card(it) })
		return Game(player1, player2)
	}
}
