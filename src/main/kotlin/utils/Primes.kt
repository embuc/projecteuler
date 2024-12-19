package se.embuc.utils

import kotlin.math.sqrt

fun isPrime(n: Long): Boolean {
	if (n < 2) return false
	if (n == 2L) return true
	if (n % 2L == 0L) return false
	val sqrtN = Math.sqrt(n.toDouble()).toLong()
	for (i in 3..sqrtN step 2) {
		if (n % i == 0L) return false
	}
	return true
}
fun isPrime(n: Int): Boolean {
	if (n < 2) return false
	if (n == 2) return true
	if (n % 2 == 0) return false
	val sqrtN = Math.sqrt(n.toDouble()).toLong()
	for (i in 3..sqrtN step 2) {
		if (n % i == 0L) return false
	}
	return true
}

fun findNextPrime(n: Long): Long {
	var i = n + 1
	while (!isPrime(i)) i++
	return i
}

fun primeFactors(n: Int, primes: List<Int>): Set<Int> {
	var number = n
	val factors = mutableSetOf<Int>()

	// Check divisibility by provided prime numbers
	for (prime in primes) {
		if (prime > number) break // No need to check primes greater than the remaining number
		while (number % prime == 0) {
			factors.add(prime)
			number /= prime
		}
	}

	// If number is a prime greater than the last prime in the list
	if (number > 1) {
		factors.add(number)
	}

	return factors
}

fun primeFactorsCount(n: Int): Int {
	var number = n
	var count = 0
	var primeTest = -1
	val rootOfN = sqrt(n.toDouble())

	// Divide out all factors of 2
	while (number % 2 == 0) {
		if (primeTest != 2) {
			count++
			primeTest = 2
		}
		number /= 2
	}
	var i = 3
	while (i <= rootOfN) {
		while (number % i == 0) {
			if (primeTest != i) {
				count++
				primeTest = i
			}
			number /= i
		}
		i += 2
	}
	// add any remaining prime factors greater than 2
	if (number > 2) {
		count++
	}
	return count
}

// with primes for caching
fun primeFactorsCount(n: Int, primes: List<Int>): Int {
	var number = n
	var count = 0
	var primeTest = -1
	val rootOfN = sqrt(n.toDouble()).toInt()
	for (prime in primes) {
		if (prime > rootOfN) break // No need to check primes greater than the root of the number
		while (number % prime == 0) {
			if (primeTest != prime) {
				count++
				primeTest = prime
			}
			number /= prime
		}
	}
	// If number is a prime greater than the last prime in the list
	if (number > 1) {
		count++
	}

	return count
}

//Sieve of Eratosthenes algorithm. This algorithm is highly efficient for finding all prime numbers up to a certain
//limit. It works by iteratively marking the multiples of each prime number as non-prime.
//This implementation initializes a Boolean array, prime, to keep track of whether each number up to n is prime.
//Initially, all entries in the array are set to true. Then, for each number starting from 2, if the number is marked as
//prime, it's added to the sum, and all of its multiples are marked as non-prime (false).
fun sumOfPrimesBelow(n: Int): Long {
	var sum = 0L
	val primes = getPrimesSieveBelow(n)
	primes.forEachIndexed { index, b ->
		if (b) sum += index
	}
	return sum
}

//optimized version for whole array of primes:
//All even numbers except 2 are marked as non-prime initially.
//The outer loop runs through odd numbers starting from 3 and only up to the square root of n.
//The inner loop starts from i * i and steps through numbers at intervals of 2 * i (since we're only considering odd
//multiples of i, which are odd).
fun getPrimesSieveBelow(n: Int): BooleanArray {
	val sievePrimes = BooleanArray(n) { true }
	if (n > 0) sievePrimes[0] = false
	if (n > 1) sievePrimes[1] = false

	for (i in 4 until n step 2) {//jump over 2 and mark all even numbers as non-prime
		sievePrimes[i] = false
	}

	val sqrtN = sqrt(n.toDouble()).toInt()
	for (i in 3..sqrtN step 2) {
		if (sievePrimes[i]) {
			for (j in i * i until n step 2 * i) {
				sievePrimes[j] = false
			}
		}
	}
	return sievePrimes
}

fun getUpToNPrimes(limit: Int): List<Int> {
//	Pn < n ln (n ln n) for n ≥ 6
	val size = if (limit < 6) 13 else (limit * Math.log(limit.toDouble() * Math.log(limit.toDouble()))).toInt()
	val sieve = getPrimesSieveBelow(size)
	val primes = mutableListOf<Int>()
	for (i in 2 until sieve.size) {
		if (sieve[i]) {
			primes.add(i)
		}
		if (primes.size == limit) break
	}
	return primes
}

fun getPrimesBelow(limit: Int): Pair<MutableList<Int>, BooleanArray> {
	val sieve = getPrimesSieveBelow(limit)
	val primes = mutableListOf<Int>()
	for (i in 2 until sieve.size) {
		if (sieve[i]) {
			primes.add(i)
		}
	}
	return Pair(primes, sieve)
}