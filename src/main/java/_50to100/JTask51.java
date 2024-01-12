package _50to100;

import kotlin.Pair;
import se.embuc.Task;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static se.embuc.utils.PrimesKt.getPrimesBelow;

// Prime digit replacements
public class JTask51 implements Task {
	@Override
	public Object solve() {
		Pair<List<Integer>, boolean[]> primesBelow = getPrimesBelow(1_000_000);
		List<Integer> primes = primesBelow.getFirst();
		boolean[] sieve = primesBelow.getSecond();
		var length = 8;
		for (int i = 0; i < primes.size(); i++) {
			var prime = primes.get(i);
			if (prime < 56000) {
				continue;
			}
			var patterns = generatePatterns(prime);
			for (var pattern : patterns) {
				var primesInPattern = countPrimesInPattern(pattern, sieve);
				if (primesInPattern.size() == length) {
					return primesInPattern.stream().min(Integer::compareTo).get();
				}
			}
		}
		return 0;
	}

	Set<String> generatePatterns(Integer prime) {
		var primeStr = prime.toString();
		var length = primeStr.length();
		var patterns = new HashSet<String>();
		// generate 2^n patterns, where n is the number of digits in the prime
		for (int i = 1; i < 1 << length; i++) {
			var pattern = new StringBuilder(primeStr);
			for (int j = 0; j < length; j++) {
				if ((i & (1 << j)) != 0) {
					pattern.setCharAt(j, '*');
				}
			}
			patterns.add(pattern.toString());
		}
		return patterns;
	}

	Set<Integer> countPrimesInPattern(String pattern, boolean[] sieve) {
		var set = new HashSet<Integer>();
		// replace * with 0-9 and check if it is a prime
		char[] digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		for (int i = 0; i < digits.length; i++) {
			if (pattern.charAt(0) == '*' && digits[i] == '0') {
				continue;
			}
			if (pattern.charAt(pattern.length() - 1) == '*') {
				continue;
			}
			var number = pattern.replace('*', digits[i]);
			if (sieve[Integer.parseInt(number)]) {
				set.add(Integer.parseInt(number));
			}
		}
		return set;
	}
}
