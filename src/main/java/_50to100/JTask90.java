package _50to100;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JTask90 implements Task {

	record Pair(int a, int b) {}
	@NotNull
	@Override
	public Object solve() {
		var squarePairs = List.of(
				new Pair(0, 1), new Pair(0, 4), new Pair(0, 9),
				new Pair(1, 6), new Pair(2, 5), new Pair(3, 6),
				new Pair(4, 9), new Pair(6, 4), new Pair(8, 1)
		);


		// Step 2: Generate all combinations of 6 digits for a die
		var allDice = combinations(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 6).stream().map(Set::copyOf).toList();

		// Step 3: Check all pairs of dice
		var count = 0;
		for (int i = 0; i < allDice.size(); i++) {
			for (int j = i; j < allDice.size(); j++) {
				var die1 = allDice.get(i);
				var die2 = allDice.get(j);

				// Check if the pair can represent all square numbers
				if (squarePairs.stream().allMatch(pair ->
						(canRepresent(die1, pair.a()) && canRepresent(die2, pair.b())) ||
								(canRepresent(die1, pair.b()) && canRepresent(die2, pair.a()))
				)) {
					count++;
				}
			}
		}

		return count;
	}

	// Function to check if a die can represent a digit (considering 6 ↔ 9)
	private boolean canRepresent(Set<Integer> die, int digit) {
		return die.contains(digit) || (digit == 6 && die.contains(9)) || (digit == 9 && die.contains(6));
	}

	private <T> List<List<T>> combinations(List<T> list, int k) {
		if (k == 0) return List.of(List.of());
		if (list.isEmpty()) return List.of();
		T head = list.get(0);
		List<T> tail = list.subList(1, list.size());
		List<List<T>> withHead = combinations(tail, k - 1).stream()
				.map(subList -> {
					List<T> newList = new ArrayList<>(subList);
					newList.add(head);
					return newList;
				}).toList();
		List<List<T>> withoutHead = combinations(tail, k);
		List<List<T>> result = new ArrayList<>(withHead);
		result.addAll(withoutHead);
		return result;
	}
}
