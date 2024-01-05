package _1to50;

import se.embuc.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// Sub-string divisibility
public class JTask43 implements Task {

	@Override
	public Object solve() {
		var divisorPrimes = new ArrayList<>(Arrays.asList(13, 11, 7, 5, 3, 2, 1));
		//ensure we skip any with duplicate digits (chars().distinct().count() == 3)
		var validPermutations = IntStream.range(102, 999)
										 .filter(i -> i % 17 == 0)
				 						 .mapToObj(String::valueOf)
									  	 .filter(s -> s.chars().distinct().count() == 3)
										 .toList();
		return backtrackByDivisors(divisorPrimes, validPermutations);
	}

	Long backtrackByDivisors(List<Integer> primeDivisors, List<String> validPermutations ) {
		var divisor = primeDivisors.remove(0);
		var numbers = new ArrayList<String>();

		for (String permutation :validPermutations) {
			for (char digit :"0123456789".toCharArray()) {
				if (permutation.indexOf(digit)==-1) { //ensure pandigital
					var nextPermutation = digit + permutation;
					if (Integer.valueOf(nextPermutation.substring(0, 3)).intValue() % divisor == 0) {
						numbers.add(nextPermutation);
					}
				}
			}
		}

		if (primeDivisors.isEmpty()) {
			return numbers.stream().mapToLong(Long::valueOf).sum();
		} else {
			return backtrackByDivisors(primeDivisors, numbers);
		}
	}

}
