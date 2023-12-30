package se.embuc._1to100

import se.embuc.Task

// Names Scores
class Task22(private val input: String) :Task {
	override fun solve(): Long {
		val names = input.split(",").map { it.replace("\"", "") }.sorted()
		return names.mapIndexed { index, name ->
			(name.sumOf { it - 'A' + 1 }) * (index + 1)
		}.sum().toLong()
	}
}