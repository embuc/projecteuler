package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.concatenate
import se.embuc.utils.getPrimesBelow
import se.embuc.utils.isPrime

// Prime Pair Sets
class Task60 : Task {
	override fun solve(): Any {
		val (primesOrg, sieve) = getPrimesBelow(100_000_000)
		val limit = 1100
		val primes = primesOrg.take(limit)
		var sums = mutableSetOf<Int>()
		for (prime in primes) {
			for (prime2 in primes) {
				if (prime2 <= prime) continue
				if (isConcatPrime(prime, prime2, sieve) && isConcatPrime(prime2, prime, sieve)) {
					for (prime3 in primes) {
						if (prime3 <= prime2) continue
						if (isConcatPrime(prime3, prime, sieve) && isConcatPrime(prime3, prime2, sieve)
							&& isConcatPrime(prime, prime3, sieve) && isConcatPrime(prime2, prime3, sieve)
						) {
							for (prime4 in primes) {
								if (prime4 <= prime3) continue
								if (isConcatPrime(prime4, prime, sieve) && isConcatPrime(prime4, prime2,sieve)
									&& isConcatPrime(prime4, prime3, sieve) && isConcatPrime(prime,	prime4, sieve)
									&& isConcatPrime(prime2, prime4, sieve) && isConcatPrime(prime3, prime4, sieve)
								) {
									for (prime5 in primes) {
										if (prime5 <= prime4) continue
										if (isConcatPrime(prime5, prime, sieve) && isConcatPrime(prime5, prime2, sieve)
											&& isConcatPrime(prime5, prime3, sieve) && isConcatPrime(prime5, prime4, sieve)
											&& isConcatPrime(prime, prime5, sieve) && isConcatPrime(prime2,	prime5,	sieve)
											&& isConcatPrime(prime3, prime5, sieve) && isConcatPrime(prime4, prime5, sieve)) {
											sums.add(prime + prime2 + prime3 + prime4 + prime5)
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