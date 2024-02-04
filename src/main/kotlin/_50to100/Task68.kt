package se.embuc._50to100

import se.embuc.Task

//Magic 5-gon ring
class Task68:Task {

	override fun solve(): Any {
		val result = findMagicRing(10)
		return result?:""
	}

	fun findMagicRing(n: Int): String? {
		val values = (n downTo 1).toList()
		for (permutation in lexicographicalPermutations(values)) {
			val split = n / 2
			val outer = permutation.subList(0, split)
			val inner = permutation.subList(split, permutation.size)
			if (isValidGonRing(outer, inner)) {
				return formatGonRing(outer, inner)
			}
		}
		return null
	}

	fun lexicographicalPermutations(list: List<Int>): Sequence<List<Int>> = sequence {
		if (list.size == 1) {
			yield(list)
		} else {
			for (i in list.indices) {
				for (end in lexicographicalPermutations(list.take(i) + list.drop(i + 1))) {
					yield(listOf(list[i]) + end)
				}
			}
		}
	}

	fun isValidGonRing(outer: List<Int>, inner: List<Int>): Boolean {
		val total = outer[0] + inner[0] + inner[1]
		for (i in 1 until outer.size) {
			if (outer[i] + inner[i] + inner[(i + 1) % inner.size] != total) return false
		}
		return true
	}

	fun formatGonRing(outer: List<Int>, inner: List<Int>): String {
		val rot = outer.indices.minByOrNull { outer[it] } ?: 0
		val rotatedOuter = outer.rotate(rot)
		val rotatedInner = inner.rotate(rot)
		return (rotatedOuter.indices).joinToString("") {
			"${rotatedOuter[it]}${rotatedInner[it]}${rotatedInner[(it + 1) % inner.size]}"
		}
	}

	fun <T> List<T>.rotate(distance: Int): List<T> {
		val listSize = this.size
		return this.drop(distance % listSize) + this.take(distance % listSize)
	}
}