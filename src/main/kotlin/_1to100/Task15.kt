package se.embuc._1to100

import se.embuc.Task
import se.embuc.utils.factorial
import java.math.BigInteger

// Lattice paths
class Task15(private val size: Int) : Task {

	override fun solve(): Any {
		return findNumberOfPaths(size)
	}

	/**
	 * Calculates the number of paths from the top left corner to the bottom right corner of a grid.
	 * The movement is constrained to only rightward and downward steps.
	 *
	 * This method uses the concept of binomial coefficients to determine the number of distinct paths
	 * in a grid of a specified size. In a grid of size 20x20, for instance, one must move 20 steps down
	 * and 20 steps to the right in any order, resulting in a total of 40 moves.
	 *
	 * The problem can be reduced to finding the number of ways to choose 20 moves to the right
	 * (or equivalently 20 moves down) out of a total of 40 moves. The number of ways to choose 'k'
	 * items out of 'n' items, without regard to the order of selection, is given by the binomial coefficient,
	 * often denoted as 'n choose k' or C(n, k).
	 *
	 * The binomial coefficient is calculated as:
	 * C(n, k) = n! / (k! * (n - k)!)
	 * where 'n!' represents the factorial of 'n'.
	 *
	 * @param gridSize The size of the grid (e.g., 20 for a 20x20 grid).
	 * @return The number of distinct paths from the top left corner to the bottom right corner
	 * of the grid, only moving down or right.
	 */
	fun findNumberOfPaths(gridSize: Int): BigInteger {
		val n = gridSize * 2
		val k = gridSize
		return factorial(n) / (factorial(k) * factorial(n - k))
	}

}