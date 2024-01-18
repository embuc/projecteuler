package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.*

// Cyclical figurate numbers
class Task61 : Task {

	override fun solve(): Any {
		var triangles = mutableListOf<Int>()
		var squares = mutableListOf<Int>()
		var pentagonals = mutableListOf<Int>()
		var hexagonals = mutableListOf<Int>()
		var heptagonals = mutableListOf<Int>()
		var octagonals = mutableListOf<Int>()

		for (i in 3..10_000) {
			val triangle = getTriangleNumber(i)
			if (triangle >= 10_000)
				break

			if (triangle > 1000 && triangle < 10_000)
				triangles.add(triangle)
			val square = getSquareNumber(i)
			if (square > 1000 && square < 10_000)
				squares.add(square)
			val pentagonal = getPentagonalNumber(i)
			if (pentagonal > 1000 && pentagonal < 10_000)
				pentagonals.add(pentagonal)
			val hexagonal = getHexagonalNumber(i)
			if (hexagonal > 1000 && hexagonal < 10_000)
				hexagonals.add(hexagonal)
			val heptagonal = getHeptagonalNumber(i)
			if (heptagonal > 1000 && heptagonal < 10_000)
				heptagonals.add(heptagonal)
			val octagonal = getOctagonalNumber(i)
			if (octagonal > 1000 && octagonal < 10_000)
				octagonals.add(octagonal)
		}
		println("triangles: ${triangles.size}")
		println("squares: ${squares.size}")
		println("pentagonals: ${pentagonals.size}")
		println("hexagonals: ${hexagonals.size}")
		println("heptagonals: ${heptagonals.size}")
		println("octagonals: ${octagonals.size}")

		val cyclicNumbers = findCyclicNumbers(listOf(triangles, squares, pentagonals, hexagonals, heptagonals, octagonals))
		println(cyclicNumbers)
		println("### " + intArrayOf(1281, 8128, 2882, 8256, 5625, 2512).sum())
		return cyclicNumbers.last().sum()
	}
	fun isValidCycle(path: List<Int>): Boolean {
		return path.first() / 100 == path.last() % 100
	}

	fun isCyclic(prevNumber: Int, nextNumber: Int): Boolean {
		return prevNumber % 100 == nextNumber / 100
	}

	fun findCyclicNumbers(
		lists: List<List<Int>>,
		currentPath: MutableList<Int> = mutableListOf(),
		usedSets: MutableSet<Int> = mutableSetOf(),
		results: MutableList<List<Int>> = mutableListOf()
	): List<List<Int>> {
		if (currentPath.size == lists.size && isValidCycle(currentPath)) {
			results.add(ArrayList(currentPath)) // Found a valid cycle
			println("Found cycle: $currentPath")
		} else if (currentPath.size < lists.size) {
			for ((index, list) in lists.withIndex()) {
				if (index !in usedSets) { // Avoid using the same list twice
					for (number in list) {
						if (currentPath.isEmpty() || isCyclic(currentPath.last(), number)) {
							currentPath.add(number)
							usedSets.add(index)

							findCyclicNumbers(lists, currentPath, usedSets, results)

							// Backtrack
							currentPath.removeAt(currentPath.size - 1)
							usedSets.remove(index)
						}
					}
				}
			}
		}
		return results
	}
}