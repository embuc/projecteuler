package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.readFileAsString
import java.util.*

// Path Sum: Four Ways
class Task83: Task {
	override fun solve(): Any {
		val map = readFileAsString("82_matrix.txt")
			.lines()
			.map { it.split(",").map { it.toInt() }.toTypedArray() }
			.toTypedArray()
		return aStar(map)
	}

	data class Node(val row: Int, val col: Int, val cost: Int, val estimate: Int) : Comparable<Node> {
		override fun compareTo(other: Node) = compareValuesBy(this, other, { it.cost + it.estimate }, { it.row }, { it.col })
	}

	fun aStar(matrix: Array<Array<Int>>): Int {
		val rows = matrix.size
		val cols = matrix[0].size
		val goal = Pair(rows - 1, cols - 1)

		// Heuristic function: Manhattan distance to the goal.
		fun heuristic(row: Int, col: Int) = Math.abs(row - goal.first) + Math.abs(col - goal.second)

		val openSet = PriorityQueue<Node>()
		openSet.add(Node(0, 0, matrix[0][0], heuristic(0, 0)))

		val costSoFar = Array(rows) { Array(cols) { Int.MAX_VALUE } }
		costSoFar[0][0] = matrix[0][0]

		while (openSet.isNotEmpty()) {
			val current = openSet.poll()

			if (current.row == goal.first && current.col == goal.second) {
				return costSoFar[goal.first][goal.second]
			}

			listOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1)).forEach { (dr, dc) ->
				val nextRow = current.row + dr
				val nextCol = current.col + dc

				if (nextRow !in 0 until rows || nextCol !in 0 until cols) return@forEach

				val newCost = costSoFar[current.row][current.col] + matrix[nextRow][nextCol]

				if (newCost < costSoFar[nextRow][nextCol]) {
					costSoFar[nextRow][nextCol] = newCost
					val priority = newCost + heuristic(nextRow, nextCol)
					openSet.add(Node(nextRow, nextCol, newCost, priority))
				}
			}
		}

		return -1 // Goal not reachable
	}

}