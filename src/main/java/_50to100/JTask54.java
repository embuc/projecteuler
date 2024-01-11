package _50to100;

import kotlin.Pair;
import lombok.ToString;
import se.embuc.Task;

import java.util.*;
import java.util.stream.Collectors;

import static se.embuc.utils.UtilsKt.readFileAsString;

// Poker Hands
public class JTask54 implements Task {
	@Override
	public Object solve() {
		var games = readFileAsString("54_poker.txt").lines().map(this::parseGame).toList();
		var countPlayer1 = 0;
		for (Game game : games) {
			if (game.hand1().compareTo(game.hand2()) > 0) {
				countPlayer1++;
			}
		}
		return countPlayer1;
	}

	private Game parseGame(String s) {
		var cards = s.split(" ");
		List<Card> cards1 = new ArrayList<>();
		List<Card> cards2 = new ArrayList<>();
		for (int i = 0; i < cards.length; i++) {
			if (i < 5) {
				cards1.add(new Card(cards[i]));
			} else {
				cards2.add(new Card(cards[i]));
			}
		}
		var player1 = new Hand(cards1);
		var player2 = new Hand(cards2);
		return new Game(player1, player2);
	}

}

record Game(Hand hand1, Hand hand2) {
}

class Hand implements Comparable<Hand> {

	public final List<Card> hand;
	public List<Integer> sortedCards;
	public int score = 0;

	Hand(List<Card> hand) {
		this.hand = hand;
		Pair<Integer, List<Integer>> evaluatedHand = evaluateHand();
		this.score = evaluatedHand.getFirst();
		this.sortedCards = evaluatedHand.getSecond();
	}

	private Pair<Integer, List<Integer>> evaluateHand() {
		Map<Integer, Long> cardCounts = hand.stream()
				.collect(Collectors.groupingBy(Card::getValue, Collectors.counting()));
		List<Integer> sortedCards = cardCounts.entrySet().stream()
				.sorted(Map.Entry.<Integer, Long>comparingByValue(Comparator.reverseOrder())
						.thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder())))
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());

		boolean isFlush = hand.stream()
				.map(Card::getSuit)
				.distinct()
				.count() == 1;

		List<Integer> sortedValues = hand.stream()
				.map(Card::getValue)
				.sorted()
				.collect(Collectors.toList());

		boolean isStraight = true;
		for (int i = 0; i < sortedValues.size() - 1; i++) {
			if (sortedValues.get(i + 1) - sortedValues.get(i) != 1) {
				isStraight = false;
				break;
			}
		}

		boolean isStraightFlush = isFlush && isStraight;
		boolean isRoyalFlush = isFlush &&
				sortedValues.equals(Arrays.asList(10, 11, 12, 13, 14));

		int score;
		if (isRoyalFlush) {
			score = 10;
		} else if (isStraightFlush) {
			score = 9;
		} else if (cardCounts.values().stream().anyMatch(count -> count == 4)) {
			score = 8; // Four of a kind
		} else if (cardCounts.size() == 2 && cardCounts.values().stream().anyMatch(count -> count == 3)) {
			score = 7; // Full house
		} else if (isFlush) {
			score = 6;
		} else if (isStraight) {
			score = 5;
		} else if (cardCounts.values().stream().anyMatch(count -> count == 3)) {
			score = 4; // Three of a kind
		} else if (cardCounts.size() == 3) {
			score = 3; // Two pair
		} else if (cardCounts.size() == 4) {
			score = 2; // One pair
		} else {
			score = 1; // High card
		}

		return new Pair(score, sortedCards);
	}

	public int compareTo(Hand other) {
		if (this.score == other.score) {
			return compareLexicographically(this.sortedCards, other.sortedCards);
		}
		return Integer.compare(this.score - other.score, 0);
	}

	private int compareLexicographically(List<Integer> handA, List<Integer> handB) {
		for (int i = 0; i < handA.size(); i++) {
			int diff = handA.get(i).intValue() - handB.get(i).intValue();
			if (diff != 0) {return Integer.compare(diff, 0);}
		}
		return 0;
	}

	@Override
	public String toString() {
		return "cards=" + sortedCards.stream().map(i-> i.toString()).reduce((i,j)->""+i +","+j) +", score=" + score;
	}
}

@ToString
class Card {
	public int value;
	public char suit;

	Card(String s) {
		switch (s.toCharArray()[0]) {
			case 'T':
				value = 10;
				break;
			case 'J':
				value = 11;
				break;
			case 'Q':
				value = 12;
				break;
			case 'K':
				value = 13;
				break;
			case 'A':
				value = 14;
				break;
			default:
				value = Integer.parseInt(s.substring(0, 1));
		}

		suit = s.toCharArray()[1];
	}

	public Integer getValue() {return value;}

	public char getSuit() {return suit;}
}