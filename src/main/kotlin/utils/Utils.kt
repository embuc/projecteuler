package se.embuc.utils

import java.math.BigInteger
import java.util.*
import kotlin.math.abs
import kotlin.math.sqrt


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
	return if (a == 0 || b == 0) 0 else abs(a * b) / gcd(a, b)
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
fun getTriangleNumber(n: Int): Int = n * (n + 1) / 2
fun getTriangleNumbersUpTo(n: Int): BooleanArray {
	val triangleNumbers = BooleanArray(n) { false }
	for (i in 1..sqrt(n.toDouble()).toInt()) {
		val triangleNumber = getTriangleNumber(i.toLong()).toInt()
		triangleNumbers[triangleNumber] = true
	}
	return triangleNumbers
}

fun getSquareNumber(n: Long): Long = n * n
fun getSquareNumber(n: Int): Int = n * n
fun getPentagonalNumber(n: Long): Long = n * (3 * n - 1) / 2
fun getPentagonalNumber(n: Int): Int = n * (3 * n - 1) / 2
fun getHexagonalNumber(n: Long): Long = n * (2 * n - 1)
fun getHexagonalNumber(n: Int): Int = n * (2 * n - 1)
fun getHeptagonalNumber(n: Long): Long = n * (5 * n - 3) / 2
fun getHeptagonalNumber(n: Int): Int = n * (5 * n - 3) / 2
fun getOctagonalNumber(n: Long): Long = n * (3 * n - 2)
fun getOctagonalNumber(n: Int): Int = n * (3 * n - 2)


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

// Int version, be cautious with large n
fun getDivisors(n: Int): Set<Int> {
	val divisors = mutableSetOf<Int>()
	for (i in 1..n) {
		if (n % i == 0) {
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

fun factorialBig(n: Int): BigInteger {
	return if (n == 0) BigInteger.ONE else BigInteger.valueOf(n.toLong()) * factorialBig(n - 1)
}

fun factorial(n: Int): Int = if (n <= 1) 1 else n * factorial(n - 1)
fun factorial(n: Long): Long = if (n <= 1) 1 else n * factorial(n - 1)

fun factorialUnder10(n: Int): Int = when (n) {
	0 -> 1
	1 -> 1
	2 -> 2
	3 -> 6
	4 -> 24
	5 -> 120
	6 -> 720
	7 -> 5040
	8 -> 40320
	9 -> 362880
	else -> 0
}

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

fun isPermutation(i: Int, j: Int): Boolean {
	val digitsI = IntArray(10)
	val digitsJ = IntArray(10)
	var numI = i
	var numJ = j
	while (numI > 0) {
		digitsI[numI % 10]++
		numI /= 10
	}
	while (numJ > 0) {
		digitsJ[numJ % 10]++
		numJ /= 10
	}
	for (k in 0..9) {
		if (digitsI[k] != digitsJ[k]) return false
	}
	return true
}

fun isPermutation(i: Long, j: Long): Boolean {
	val digitsI = LongArray(getLongMagnitude(i).second.toInt())
	val digitsJ = LongArray(getLongMagnitude(j).second.toInt())
	var numI = i
	var numJ = j
	while (numI > 0) {
		digitsI[(numI % 10).toInt()]++
		numI /= 10
	}
	while (numJ > 0) {
		digitsJ[(numJ % 10).toInt()]++
		numJ /= 10
	}
	for (k in 0..9) {
		if (digitsI[k] != digitsJ[k]) return false
	}
	return true
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
	val width = arr.sumOf { getIntMagnitude(it).second }

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
	return (map == 1022    //9digits binary 1111111110, representing digits 1 to 9 once for length of 9
			|| map == 510    //8digits
			|| map == 254    //7digits
			|| map == 126    //6digits
			|| map == 62    //5digits
			|| map == 30    //4digits
			|| map == 14    //3digits
			|| map == 6        //2digits
			|| map == 2)    //1digits
}

fun getIntMagnitude(i: Int): Pair<Int, Int> {
	val n = i
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

fun getLongMagnitude(i: Long): Pair<Long, Long> {
	val n = i
	var log = 1L
	var exp = 1L
	// Loop (Determining the Magnitude): The while loop increases exp by multiplying it by 10 each time
	// until 10*exp is >= than n. Simultaneously, log is incremented to track the number of digits in n.
	// For example, if n is 1234, after this loop, exp will be 1000 and log will be 4.
	while (10 * exp <= n) {
		exp *= 10
		++log
	}
	return Pair(exp, log)
}

fun getPentagonalNumbers(n: Int): Pair<IntArray, BooleanArray> {
	val arrDict = BooleanArray(n * 3 * n / 2) { false }
	val arr = IntArray(n)
	for (i in 1..n) {
		val pentagonalNumber = i * (3 * i - 1) / 2
		arrDict[pentagonalNumber] = true
		arr[i - 1] = pentagonalNumber
	}
	return Pair(arr, arrDict)
}

fun getHexagonalNumbers(n: Int): Pair<IntArray, BooleanArray> {
	val arrDict = BooleanArray(n * 2 * n) { false }
	val arr = IntArray(n)
	for (i in 1..n) {
		val hexagonalNumber = i * (2 * i - 1)
		arrDict[hexagonalNumber] = true
		arr[i - 1] = hexagonalNumber
	}
	return Pair(arr, arrDict)
}

fun findPositiveIntegerRoot(a: Double, b: Double, c: Double): Double? {
	if (a == 0.0) {
		// Not a quadratic equation
		return null
	}

	val discriminant = b * b - 4 * a * c

	if (discriminant < 0) {
		// No real roots
		return null
	}

	val sqrtDiscriminant = sqrt(discriminant)
	val root1 = (-b + sqrtDiscriminant) / (2 * a)
	val root2 = (-b - sqrtDiscriminant) / (2 * a)

	// Check for positive integer roots
	if (root1 > 0 && root1 % 1 == 0.0) {
		// Root1 is a positive integer
		return root1
	}
	if (root2 > 0 && root2 % 1 == 0.0) {
		// Root2 is a positive integer
		return root2
	}

	return null
}

fun Long.digitsCount(): IntArray {
	val map = IntArray(10) // (0, 1, 2 ....) no digits encountered yet
	val digits = this.digits()
	for (number in digits) {
		map[number]++
	}
	return map
}

fun Long.digits(): IntArray {
	val digits = mutableListOf<Int>()
	var number = this
	while (number > 0L) {
		digits.add((number % 10L).toInt())
		number /= 10L
	}
	return digits.toIntArray()
}

fun Int.digits(): IntArray {
	val digits = mutableListOf<Int>()
	var number = this
	while (number > 0L) {
		digits.add((number % 10).toInt())
		number /= 10
	}
	return digits.toIntArray()
}

fun BigInteger.digits(): IntArray {
	val digits = mutableListOf<Int>()
	var number = this
	while (number > BigInteger.ZERO) {
		digits.add((number % BigInteger.TEN).toInt())
		number /= BigInteger.TEN
	}
	return digits.toIntArray()
}

fun Int.pow(exponent: Int): Int {
	require(exponent >= 0) { "Exponent must be non-negative" }

	var result = 1
	val base = this
	for (i in 1..exponent) {
		result *= base
	}
	return result
}

// 37,18 -> 3718 etc.
fun concatenate(first: Int, second: Int): Int {
	var power = 1
	while (power <= second) {
		power *= 10
	}
	return first * power + second
}

fun concatenate(first: Long, second: Long): Long {
	var power = 1
	while (power <= second) {
		power *= 10
	}
	return first * power + second
}

data class Fraction(var numerator: BigInteger, var denominator: BigInteger)

fun solvePell(n: Int): Fraction {
	val initialRoot = sqrt(n.toDouble()).toInt()
	var y = initialRoot
	var z = 1
	var r = initialRoot * 2
	val fraction1 = Fraction(BigInteger.ONE, BigInteger.ZERO)
	val fraction2 = Fraction(BigInteger.ZERO, BigInteger.ONE)
	val resultFraction = Fraction(BigInteger.ZERO, BigInteger.ZERO)
	while (true) {
		y = r * z - y
		z = (n - y * y) / z
		r = (initialRoot + y) / z

		nextNum(fraction1, r)
		nextNum(fraction2, r)
		var invFraction = Fraction(fraction1.denominator, fraction2.denominator)
		nextNum(invFraction, initialRoot)
		resultFraction.numerator = invFraction.denominator
		resultFraction.denominator = fraction2.denominator

		if (resultFraction.numerator * resultFraction.numerator -
			n.toBigInteger() * resultFraction.denominator * resultFraction.denominator == BigInteger.ONE) {
			return Fraction(resultFraction.numerator, resultFraction.denominator)
		}
	}
}

private fun nextNum(f: Fraction, term: Int) {
	val temp = f.numerator
	f.numerator = f.denominator
	f.denominator = f.denominator * BigInteger.valueOf(term.toLong()) + temp
}
//Euler's totient function(phi) counts the positive integers up to a given integer n that are relatively prime to n
fun phi(n: Int): Int {
	var num = n
	var result = num

	var i = 2
	while (i * i <= num) {
		if (num % i == 0) {
			while (num % i == 0) num /= i
			result -= result / i
		}
		i++
	}

	if (num > 1) result -= result / num
	return result
}
fun calculateTotientSum(n: Int): Long {
	val phi = IntArray(n + 1)
	for (i in 0..n) {
		phi[i] = i // Initialize phi[i] to i
	}

	val isPrime = BooleanArray(n + 1)
	Arrays.fill(isPrime, true)
	isPrime[1] = false
	isPrime[0] = false // 0 and 1 are not prime

	for (i in 2..n) {
		if (isPrime[i]) {
			phi[i] = i - 1 // phi(prime) = prime - 1
			var j = 2
			while (i * j <= n) {
				isPrime[i * j] = false // Mark multiples of i as not prime
				phi[i * j] = (phi[i * j] / i) * (i - 1) // Update phi value
				j++
			}
		}
	}

	var sum: Long = 0
	for (i in 2..n) {
		sum += phi[i].toLong() // Sum phi values
	}

	return sum
}

// Function to generate all permutations of a list
fun <T> permute(list: List<T>): List<List<T>> {
	if (list.size == 1) return listOf(list) // Base case: only one element
	val permutations = mutableListOf<List<T>>()
	for (i in list.indices) {
		val remaining = list.toMutableList()
		val current = remaining.removeAt(i) // Take one element
		val subPermutations = permute(remaining) // Permute the rest
		for (perm in subPermutations) {
			permutations.add(listOf(current) + perm) // Add current to each sub-permutation
		}
	}
	return permutations
}

fun allCombinationsOfFourDigits(): List<List<Int>> {
	return (0..9).toList().combinations(4) // Generate all combinations of four digits
}

fun <T> List<T>.combinations(k: Int): List<List<T>> {
	if (k == 0) return listOf(emptyList())
	if (this.isEmpty()) return emptyList()
	val head = first()
	val tail = drop(1)
	val withHead = tail.combinations(k - 1).map { listOf(head) + it }
	val withoutHead = tail.combinations(k)
	return withHead + withoutHead
}
