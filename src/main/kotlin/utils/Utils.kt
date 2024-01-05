package se.embuc.utils

import java.io.File
import java.math.BigInteger
import kotlin.math.sqrt

fun readFileAsString(path: String): String {
	return File("src/test/resources/$path").inputStream().use { return it.bufferedReader().readText() }
}

fun readFileFromClassPathAsString(path: String): String {
	val inputStream = Thread.currentThread().contextClassLoader.getResourceAsStream(path)
		?: throw IllegalArgumentException("File not found")
	return inputStream.bufferedReader().use { it.readText() }
}

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

// this one is neat and simple but not fast for many numbers to check
fun isPalindrome(n: Int): Boolean {
	return n.toString() == n.toString().reversed()
}

fun isPalindrome(n: String): Boolean {
	return n == n.reversed()
}

fun isDecimalPalindrome(number: Int): Boolean {
	var reversed = 0
	var temp = number
	while (temp > 0) {
		reversed = reversed * 10 + temp % 10
		temp /= 10
	}
	return number == reversed
}

fun isBinaryPalindrome(number: Int): Boolean {
	var reversed = 0
	var temp = number
	while (temp > 0) {
		reversed = (reversed shl 1) or (temp and 1)
		temp = temp ushr 1
	}
	return number == reversed
}

fun gcd(a: Int, b: Int): Int {
	return if (b == 0) a else gcd(b, a % b)
}

fun gcd(a: Long, b: Long): Long {
	if (b == 0L) return a
	return gcd(b, a % b)
}

fun lcm(a: Long, b: Long): Long {
	return a / gcd(a, b) * b
}

fun lcm(a: Int, b: Int): Int {
	return if (a == 0 || b == 0) 0 else Math.abs(a * b) / gcd(a, b)
}

fun findLCD(denominators: List<Int>): Int {
	return denominators.fold(1) { lcm, denominator ->
		lcm(lcm, denominator)
	}
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
fun getTriangleNumbersUpTo(n: Int) : BooleanArray {
	val triangleNumbers = BooleanArray(n) { false }
	for (i in 1..sqrt(n.toDouble()).toInt()) {
		val triangleNumber = getTriangleNumber(i.toLong()).toInt()
		triangleNumbers[triangleNumber] = true
	}
	return triangleNumbers
}

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
			if (i != n / i && i != 1L) {//skip n itself too
				count += n / i
			}  // Count the divisor pair only if they are different
		}
		i++
	}
	return count
}

fun getDivisorsSum(n: Int): Int {
	var count = 0
	var i = 1
	while (i * i <= n) {
		if (n % i == 0) {
			count += i
			if (i != n / i && i != 1) {//skip n itself too
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

	val sqrtN = kotlin.math.sqrt(n.toDouble()).toInt()
	for (i in 3..sqrtN step 2) {
		if (sievePrimes[i]) {
			for (j in i * i until n step 2 * i) {
				sievePrimes[j] = false
			}
		}
	}
	return sievePrimes
}


fun factorialBig(n: Int): BigInteger {
	return if (n == 0) BigInteger.ONE else BigInteger.valueOf(n.toLong()) * factorialBig(n - 1)
}

fun factorial(n: Int): Int = if (n <= 1) 1 else n * factorial(n - 1)

// This method is used to find the number of permutations of a string. It will find ALL permutations, this is quite slow
// for instance for a string of length 10(Task 24). Better to use specialized method bellow, that one is O(n)
fun String.permutations(): List<String> {
	if (this.length == 1) return listOf(this)
	val perms = mutableListOf<String>()
	val toInsert = this[0]
	val subPerms = this.substring(1).permutations()
	for (perm in subPerms) {
		for (i in 0..perm.length) {
			val newPerm = perm.substring(0, i) + toInsert + perm.substring(i)
			perms.add(newPerm)
		}
	}
	return perms
}

// this one is fast, O(n)
fun computeNthPermutation(numbers: MutableList<Char>, n: Int): String {
	var index = n - 1 // Adjusting index to be zero-based
	var result = ""

	while (numbers.isNotEmpty()) {
		val factorial = factorial(numbers.size - 1)
		if (index >= factorial * numbers.size) {
			// If the index is out of the valid range
			return "Invalid permutation index"
		}
		val listIndex = index / factorial
		result += numbers[listIndex]
		index %= factorial
		numbers.removeAt(listIndex)
	}

	return result
}

fun isPanDigit(arr: IntArray): Boolean {
	var map = 0 // (binary 0000000000) no digits encountered yet
	for (number in arr) {
		var num = number
		while (num > 0) {
			val bit = 1 shl (num % 10) // shift left in java: <<
			if (map and bit != 0) return false // bit already set in map, not pandigital
			map = map or bit
			num /= 10
		}
	}
	val width = arr.map { getIntMagnitude(it).second }.sum()

	when (width) {
		1 -> return map == 2 //1digits binary 10, representing digit 1 once for length of 1
		2 -> return map == 6 //2digits binary 110, representing digits 1 to 2 once for length of 2
		3 -> return map == 14
		4 -> return map == 30
		5 -> return map == 62
		6 -> return map == 126
		7 -> return map == 254
		8 -> return map == 510
		9 -> return map == 1022
		}
	return 	(  map == 1022 	//9digits binary 1111111110, representing digits 1 to 9 once for length of 9
			|| map == 510	//8digits
			|| map == 254	//7digits
			|| map == 126	//6digits
			|| map == 62	//5digits
			|| map == 30	//4digits
			|| map == 14	//3digits
			|| map == 6		//2digits
			|| map == 2);	//1digits
}

fun getIntMagnitude(i: Int): Pair<Int, Int> {
	var n = i
	var log = 1
	var exp = 1
	// Loop (Determining the Magnitude): The while loop increases exp by multiplying it by 10 each time
	// until 10*exp is >= than n. Simultaneously, log is incremented to track the number of digits in n.
	// For example, if n is 1234, after this loop, exp will be 1000 and log will be 4.
	while (10 * exp <= n) {
		exp *= 10
		++log
	}
	return Pair(exp, log)
}