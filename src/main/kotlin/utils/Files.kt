package se.embuc.utils

import java.io.*
import java.util.*

fun readFileAsString(path: String): String {
	File("src/test/resources/$path").inputStream().use { return it.bufferedReader().readText() }
}

fun readFileFromClassPathAsString(path: String): String {
	val inputStream = Thread.currentThread().contextClassLoader.getResourceAsStream(path)
		?: throw IllegalArgumentException("File not found")
	return inputStream.bufferedReader().use { it.readText() }
}

fun writeBitSetToFile(bitSet: BitSet, fileName: String) {
	ObjectOutputStream(FileOutputStream(fileName)).use { oos ->
		oos.writeObject(bitSet)
	}
}

fun readBitSetFromFile(fileName: String): BitSet {
	return ObjectInputStream(FileInputStream(fileName)).use { ois ->
		ois.readObject() as BitSet
	}
}

fun writePrimesToFile(sieve: BooleanArray, fileName: String) {
	val bits = BitSet(sieve.size)
	for (i in 0 until sieve.size) {
		bits.set(i, sieve[i])
	}
	ObjectOutputStream(FileOutputStream(fileName)).use { oos ->
		oos.writeObject(bits)
	}
}

fun readPrimesFromFile(fileName: String): Pair<List<Int>, BooleanArray> {
	var bits = ObjectInputStream(File("src/main/resources/$fileName").inputStream()).use { ois -> ois.readObject() as BitSet}
	val sieve = BooleanArray(bits.size()) { i -> bits.get(i) }
	val primes = mutableListOf<Int>()
	for (i in 0 until sieve.size) {
		if (sieve[i]) primes.add(i)
	}
	return Pair(primes, sieve)
}