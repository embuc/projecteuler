package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.concatenate
import se.embuc.utils.isPrime
import se.embuc.utils.readPrimesFromFile

// Prime Pair Sets
class Task60 : Task {
	override fun solve(): Any {
		val (primesOrg, sieve) = readPrimesFromFile("primesBelow100_000_000.dat")
		val limit = 1100
		val primes = primesOrg.take(limit)
		var sums = mutableSetOf<Int>()
		for (p1 in 0..primes.size - 5) {
			var restP1 = primes.get(p1) % 3
			for (p2 in p1+1..primes.size - 4) {
				var restP2 = primes.get(p2) % 3
				if (restP2 != restP1) continue
				if (isConcatPrime(primes.get(p1), primes.get(p2), sieve) && isConcatPrime(primes.get(p2), primes.get(p1), sieve)) {
					for (p3 in p2+1..primes.size - 3) {
						var restP3 = primes.get(p3) % 3
						if (restP3 != restP2) continue
						if (isConcatPrime(primes.get(p3), primes.get(p1), sieve) && isConcatPrime(primes.get(p3), primes.get(p2), sieve)
							&& isConcatPrime(primes.get(p1), primes.get(p3), sieve) && isConcatPrime(primes.get(p2), primes.get(p3), sieve)
						) {
							for (p4 in p3+1..primes.size - 2) {
								var restP4 = primes.get(p4) % 3
								if (restP4 != restP3) continue
								if (isConcatPrime(primes.get(p4), primes.get(p1), sieve) && isConcatPrime(primes.get(p4), primes.get(p2), sieve)
									&& isConcatPrime(primes.get(p4), primes.get(p3), sieve) && isConcatPrime(primes.get(p1), primes.get(p4), sieve)
									&& isConcatPrime(primes.get(p2), primes.get(p4), sieve) && isConcatPrime(primes.get(p3), primes.get(p4), sieve)
								) {
									for (p5 in p4+1..primes.size - 1) {
										var restP5 = primes.get(p5) % 3
										if (restP5 != restP4) continue
										if (isConcatPrime(primes.get(p5), primes.get(p1), sieve) && isConcatPrime(primes.get(p5), primes.get(p2), sieve)
											&& isConcatPrime(primes.get(p5), primes.get(p3), sieve) && isConcatPrime(primes.get(p5), primes.get(p4), sieve)
											&& isConcatPrime(primes.get(p1), primes.get(p5), sieve) && isConcatPrime(primes.get(p2), primes.get(p5), sieve)
											&& isConcatPrime(primes.get(p3), primes.get(p5), sieve) && isConcatPrime(primes.get(p4), primes.get(p5), sieve)) {
											sums.add(primes.get(p1) + primes.get(p2) + primes.get(p3) + primes.get(p4) + primes.get(p5))
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return sums.minOrNull() ?: -1
	}

	private fun isConcatPrime(prime: Int, prime2: Int, sieve: BooleanArray): Boolean {
		val concat = concatenate(prime.toLong(), prime2.toLong())
		return if (concat < sieve.size) sieve[concat.toInt()] else isPrime(concat)
	}
}