package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.readFileAsString

// XOR Decryption
class Task59:Task {
	override fun solve(): Any {
		val file = readFileAsString("59_cipher.txt")
		val encrypted = file.split(",").map { it.toInt() }
		val aChar = 'a'.code
		val zChar = 'z'.code
		for (a in aChar..zChar) {
			for (b in aChar..zChar) {
				for (c in aChar..zChar) {
					val key = listOf(a, b, c)
					val decrypted = decrypt(encrypted, key)
					if (decrypted.contains(" the ")) {
//						println(decrypted)
						return decrypted.map { it.code }.sum()
					}
				}
			}
		}
		return -1
	}

	private fun decrypt(encrypted: List<Int>, key: List<Int>): String {
		val decrypted = mutableListOf<Char>()
		for (i in encrypted.indices) {
			val keyChar = key[i % key.size]//rotate key bytes
			val decryptedChar = encrypted[i] xor keyChar
			decrypted.add(decryptedChar.toChar())
		}
		return decrypted.joinToString("")
	}
}