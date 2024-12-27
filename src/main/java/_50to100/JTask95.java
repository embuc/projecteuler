package _50to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JTask95 {

	public int solve() {
		int limit = 1_000_000;
		int[] divisorSums = new int[limit];

		// divisor sums (sieve method)
		for (int i = 1; i < limit; i++) {
			for (int j = 2 * i; j < limit; j += i) {
				divisorSums[j] += i;
			}
		}

		int[] chainLengths = new int[limit];
		Arrays.fill(chainLengths,0); // Initialize with 0 (untested), -1 (bad), n (chain length)
		chainLengths[0] = -1;


		for (int i = 1; i < limit; i++) {
			if (chainLengths[i] != 0) continue; // Skip if already processed

			List<Integer> sequence = new ArrayList<>();
			sequence.add(i);
			int current = i;


			while(true){
				int next = divisorSums[current];
				if (next >= limit || chainLengths[next] != 0 || sequence.contains(next)) {
					break;
				}
				current = next;
				sequence.add(current);
			}

			int lastDivisorSum = divisorSums[sequence.get(sequence.size() - 1)];
			if (sequence.contains(lastDivisorSum)) {
				int loopStart = sequence.indexOf(lastDivisorSum);

				// Mark within-loop numbers with the chain length
				for (int k = loopStart; k < sequence.size(); k++) {
					chainLengths[sequence.get(k)] = sequence.size() - loopStart;
				}
			} else {
				for (int s : sequence) {
					chainLengths[s] = -1;
				}
			}
		}

		int maxIndex=0;
		int max = -1;
		for(int i = 0; i < chainLengths.length; i++){
			if (chainLengths[i] > max){
				max = chainLengths[i];
				maxIndex = i;
			}
		}
		return maxIndex;

	}

}