package _50to100;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JTask93 implements Task {

	private final Map<Integer, Set<Integer>> expressionCache = new HashMap<>();
	// Early termination threshold
	private static final int MAX_POSSIBLE_SEQUENCE = 100;

	@NotNull
	@Override
	public Object solve() {
		return findBestSet();
	}

	private String findBestSet() {
		int longestSequence = 0;
		int bestSet = 0;

		List<int[]> combinations = generateCombinations();

		for (int[] digits : combinations) {
			int digitKey = arrayToKey(digits);

			Set<Integer> results = expressionCache.computeIfAbsent(digitKey, k -> {
				Set<Integer> tempResults = new HashSet<>();
				List<Double> numbers = new ArrayList<>(4);
				for (int digit : digits) {
					numbers.add((double) digit);
				}
				backtrack(numbers, tempResults);
				return tempResults;
			});

			int consecutiveLength = findConsecutiveLength(results);
			if (consecutiveLength > longestSequence) {
				longestSequence = consecutiveLength;
				bestSet = digitKey;

				if (longestSequence >= MAX_POSSIBLE_SEQUENCE) {break;}
			}
		}

		return keyToString(bestSet);
	}

	private void backtrack(List<Double> numbers, Set<Integer> results) {
		if (numbers.size() == 1) {
			double result = numbers.get(0);
			if (result > 0 && result <= MAX_POSSIBLE_SEQUENCE * 2
					&& result == (int) result) {
				results.add((int) result);
			}
			return;
		}

		for (int i = 0; i < numbers.size(); i++) {
			for (int j = i + 1; j < numbers.size(); j++) {
				double num1 = numbers.get(i);
				double num2 = numbers.get(j);

				// Create new list with remaining numbers
				List<Double> remaining = new ArrayList<>(numbers.size() - 1);
				for (int k = 0; k < numbers.size(); k++) {
					if (k != i && k != j) {
						remaining.add(numbers.get(k));
					}
				}

				computeOperations(num1, num2, remaining, results);
			}
		}
	}

	private void computeOperations(double num1, double num2, List<Double> remaining,
			Set<Integer> results) {
		// Addition (commutative)
		tryOperation(num1 + num2, remaining, results);

		// Multiplication (also commutative)
		tryOperation(num1 * num2, remaining, results);

		// Subtraction (non-commutative)
		tryOperation(num1 - num2, remaining, results);
		tryOperation(num2 - num1, remaining, results);

		// Division (non-commutative)
		if (Math.abs(num2) > 1e-10) {tryOperation(num1 / num2, remaining, results);}
		if (Math.abs(num1) > 1e-10) {tryOperation(num2 / num1, remaining, results);}
	}

	private void tryOperation(double result, List<Double> remaining, Set<Integer> results) {
		if (Double.isFinite(result) && result > 0 && result <= MAX_POSSIBLE_SEQUENCE * 2) {
			List<Double> newNumbers = new ArrayList<>(remaining.size() + 1);
			newNumbers.addAll(remaining);
			newNumbers.add(result);
			backtrack(newNumbers, results);
		}
	}

	private int findConsecutiveLength(Set<Integer> results) {
		int count = 0;
		int current = 1;

		while (results.contains(current)) {
			count++;
			current++;
			if (count >= MAX_POSSIBLE_SEQUENCE) {break;}
		}

		return count;
	}

	private int arrayToKey(int[] digits) {
		Arrays.sort(digits);
		int key = 0;
		for (int digit : digits) {
			key = key * 10 + digit;
		}
		return key;
	}

	private String keyToString(int key) {
		StringBuilder sb = new StringBuilder();
		while (key > 0) {
			sb.insert(0, key % 10);
			key /= 10;
		}
		while (sb.length() < 4) {
			sb.insert(0, '0');
		}
		return sb.toString();
	}

	private List<int[]> generateCombinations() {
		List<int[]> combinations = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			for (int j = i + 1; j <= 9; j++) {
				for (int k = j + 1; k <= 9; k++) {
					for (int l = k + 1; l <= 9; l++) {
						combinations.add(new int[]{i, j, k, l});
					}
				}
			}
		}
		return combinations;
	}
}
