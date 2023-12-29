package se.embuc.utils

import java.math.BigInteger

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

fun findNextPrime(n: Long): Long {
	var i = n + 1
	while (!isPrime(i)) i++
	return i
}

fun isPalindrome(n: Int): Boolean {
	return n.toString() == n.toString().reversed()
}

fun gcd(a: Long, b: Long): Long {
	if (b == 0L) return a
	return gcd(b, a % b)
}

fun lcm(a: Long, b: Long): Long {
	return a / gcd(a, b) * b
}


fun isDivisibleByAll(n: Long, d: Long): Boolean {
	for (i in 1..d) {
		if (n % i != 0L) {
			return false
		}
	}
	return true
}

fun getTriangleNumber(n: Long): Long = n * (n + 1) / 2

/* not efficient for large n but nice for debug and printing */
fun getDivisors(n: Long): List<Long> {
	val divisors = mutableListOf<Long>()
	for (i in 1..n) {
		if (n % i == 0L) {
			divisors.add(i)
		}
	}
	return divisors
}

/**
 * Instead of iterating all the way up to n, you only need to go up to the square root of n. Every divisor found below
 * the square root has a corresponding divisor above the square root. For example, if n is divisible by i, then it's
 * also divisible by n / i. This reduces the time complexity significantly.
 */
fun getDivisorsCount(n: Long): Int {
	var count = 0
	var i = 1L
	while (i * i <= n) {
		if (n % i == 0L) {
			count += 1
			if (i != n / i) count += 1  // Count the divisor pair only if they are different
		}
		i++
	}
	return count
}
/* Similar to above */
fun getDivisorsSum(n: Long): Long {
	var count = 0L
	var i = 1L
	while (i * i <= n) {
		if (n % i == 0L) {
			count += i
			if (i != n / i && i != 1L){//skip n itself too
				count += n / i
			}  // Count the divisor pair only if they are different
		}
		i++
	}
	return count
}

//Sieve of Eratosthenes algorithm. This algorithm is highly efficient for finding all prime numbers up to a certain
//limit. It works by iteratively marking the multiples of each prime number as non-prime.
//This implementation initializes a Boolean array, prime, to keep track of whether each number up to n is prime.
//Initially, all entries in the array are set to true. Then, for each number starting from 2, if the number is marked as
//prime, it's added to the sum, and all of its multiples are marked as non-prime (false).
fun sumOfPrimesBelow(n: Int): Long {
	if (n < 2) return 0
	val sievePrimes = BooleanArray(n) { true }
	var sum = 0L
	for (i in 2 until n) {
		if (sievePrimes[i]) {
			sum += i
			for (j in i * 2 until n step i) {
				sievePrimes[j] = false
			}
		}
	}
	return sum
}

fun factorial(n: Int): BigInteger {
	return if (n == 0) BigInteger.ONE else BigInteger.valueOf(n.toLong()) * factorial(n - 1)
}