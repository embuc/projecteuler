package _50to100;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JTask88 implements Task {

	@NotNull
	@Override
	public Object solve() {
		int maxK = 12000;
		// DP table to store the minimal product-sum number for each k
		int[] dp = new int[maxK + 1];
		Arrays.fill(dp, Integer.MAX_VALUE); // Initialize with "infinity"
		dp[0] = 0; // Base case (not used, but avoids indexing issues)

		// Function to explore all combinations recursively
		compute(1, 0, 0, 2, maxK, dp);

		// Extract all unique minimal product-sum numbers for k = 2 to maxK
		Set<Integer> uniqueNs = new HashSet<>();
		for (int k = 2; k <= maxK; k++) {
			uniqueNs.add(dp[k]);
		}

		// Return the sum of all unique values
		return uniqueNs.stream().mapToInt(Integer::intValue).sum();
	}

	private static void compute(int product, int sum, int numTerms, int start, int maxK, int[] dp) {
		// Calculate the effective size of the current combination
		int size = numTerms + (product - sum);

		// If size exceeds maxK, stop exploring
		if (size > maxK) return;

		// Update the DP table for this size with the minimal product-sum number
		dp[size] = Math.min(dp[size], product);

		// Recursively try adding more numbers to the combination
		for (int i = start; i <= 2 * maxK; i++) {
			// Stop if the product grows too large (avoiding overflow)
			if (product * i > 2 * maxK) break;

			// Recursive call with updated product, sum, and numTerms
			compute(product * i, sum + i, numTerms + 1, i, maxK, dp);
		}
	}
}
