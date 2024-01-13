package _50to100;

import kotlin.Pair;
import lombok.val;
import se.embuc.Task;

import java.util.List;

import static se.embuc.utils.FilesKt.readPrimesFromFile;
import static se.embuc.utils.PrimesKt.isPrime;
import static se.embuc.utils.UtilsKt.concatenate;

// Prime Pair Sets
public class JTask60 implements Task {
	@Override
	public Object solve() {
		Pair<List<Integer>, boolean[]> listPair = readPrimesFromFile("primesBelow100_000_000.dat");
		final var primesOrg = listPair.getFirst();
		final var sieve = listPair.getSecond();

		final var limit = 1100;
		var primes = primesOrg.subList(0, limit);

		var sums = new java.util.ArrayList<Integer>();
		for (int p1 = 0; p1<primes.size() - 5 ; p1++) {
			var restP1 = primes.get(p1) % 3;
			for (int p2 = p1+1; p2<primes.size() - 4; p2++) {
				var restP2 = primes.get(p2) % 3;
				if (restP2 != restP1) continue;
				if (isConcatPrime(primes.get(p1), primes.get(p2), sieve) && isConcatPrime(primes.get(p2), primes.get(p1), sieve)) {
					for (int p3 = p2+1; p3<primes.size() - 3; p3++) {
						var restP3 = primes.get(p3) % 3;
						if (restP3 != restP2) continue;
						if (isConcatPrime(primes.get(p3), primes.get(p1), sieve) && isConcatPrime(primes.get(p3), primes.get(p2), sieve)
								&& isConcatPrime(primes.get(p1), primes.get(p3), sieve) && isConcatPrime(primes.get(p2), primes.get(p3), sieve)
						) {
							for (int p4 = p3+1; p4<primes.size() - 2; p4++) {
								var restP4 = primes.get(p4) % 3;
								if (restP4 != restP3) continue;
								if (isConcatPrime(primes.get(p4), primes.get(p1), sieve) && isConcatPrime(primes.get(p4), primes.get(p2), sieve)
										&& isConcatPrime(primes.get(p4), primes.get(p3), sieve) && isConcatPrime(primes.get(p1), primes.get(p4), sieve)
										&& isConcatPrime(primes.get(p2), primes.get(p4), sieve) && isConcatPrime(primes.get(p3), primes.get(p4), sieve)
								) {
									for (int p5 = p4+1; p5< primes.size() - 1; p5++) {
										var restP5 = primes.get(p5) % 3;
										if (restP5 != restP4) continue;
										if (isConcatPrime(primes.get(p5), primes.get(p1), sieve) && isConcatPrime(primes.get(p5), primes.get(p2), sieve)
												&& isConcatPrime(primes.get(p5), primes.get(p3), sieve) && isConcatPrime(primes.get(p5), primes.get(p4), sieve)
												&& isConcatPrime(primes.get(p1), primes.get(p5), sieve) && isConcatPrime(primes.get(p2), primes.get(p5), sieve)
												&& isConcatPrime(primes.get(p3), primes.get(p5), sieve) && isConcatPrime(primes.get(p4), primes.get(p5), sieve)) {
											sums.add(primes.get(p1) + primes.get(p2) + primes.get(p3) + primes.get(p4) + primes.get(p5));
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return sums.stream().min(Integer::compareTo).get();
	}

	private boolean isConcatPrime(int prime, int prime2, boolean [] sieve) {
		val concat = concatenate(prime, prime2);
		return (concat < sieve.length) ? sieve[(int)concat] : isPrime(concat);
	}
}
