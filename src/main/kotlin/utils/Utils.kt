package se.embuc.utils

fun isPrime(n: Long): Boolean {
	if (n < 2) return false
	if (n == 2L) return true
	if (n % 2L == 0L) return false
	for (i in 3..Math.sqrt(n.toDouble()).toLong() step 2) {
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