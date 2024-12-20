package _50to100;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;
import se.embuc.utils.UtilsKt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JTask93 implements Task {

	@NotNull
	@Override
	public Object solve() {
		return findBestSet();
	}

	public static String findBestSet() {
		int longestSequence = 0;
		String bestSet = "";

		for (List<Integer> digits : UtilsKt.allCombinationsOfFourDigits()) {
			Set<Integer> results = new HashSet<>();

			for (List<Integer> perm : UtilsKt.permute(digits)) {
				// Step 3: Use backtracking to evaluate all possible expressions
				backtrack(convertToDoubleList(perm), results);
			}

			int consecutiveLength = findConsecutiveLength(results);
			if (consecutiveLength > longestSequence) {
				longestSequence = consecutiveLength;
				Collections.sort(digits);
				bestSet = digitsToString(digits);
			}
		}

		return bestSet;
	}

	private static void backtrack(List<Double> numbers, Set<Integer> results) {
		// Base case, one number left
		if (numbers.size() == 1) {
			double result = numbers.get(0);
			if (result > 0 && result == Math.floor(result)) { // Check if result is a positive integer
				results.add((int) result);
			}
			return;
		}

		for (int i = 0; i < numbers.size(); i++) {
			for (int j = 0; j < numbers.size(); j++) {
				if (i == j) {
					continue; // Skip same index
				}

				double num1 = numbers.get(i);
				double num2 = numbers.get(j);

				List<Double> remaining = new ArrayList<>();
				for (int k = 0; k < numbers.size(); k++) {
					if (k != i && k != j) {
						remaining.add(numbers.get(k));
					}
				}

				List<Double> resultsToTry = Arrays.asList(
						num1 + num2,
						num1 - num2,
						num1 * num2,
						(num2 != 0) ? num1 / num2 : null
				);

				for (Double result : resultsToTry) {
					if (result != null) {
						List<Double> newNumbers = new ArrayList<>(remaining);
						newNumbers.add(result);
						backtrack(newNumbers, results);
					}
				}
			}
		}
	}

	private static int findConsecutiveLength(Set<Integer> results) {
		List<Integer> sortedResults = new ArrayList<>(results);
		Collections.sort(sortedResults);

		int count = 0;
		for (int num : sortedResults) {
			if (num == count + 1) {
				count++;
			} else if (num > count + 1) {
				break;
			}
		}

		return count;
	}

	private static List<Double> convertToDoubleList(List<Integer> integers) {
		List<Double> doubles = new ArrayList<>();
		for (Integer integer : integers) {
			doubles.add(integer.doubleValue());
		}
		return doubles;
	}

	private static String digitsToString(List<Integer> digits) {
		StringBuilder sb = new StringBuilder();
		for (int digit : digits) {
			sb.append(digit);
		}
		return sb.toString();
	}

}
