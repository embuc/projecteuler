package se.embuc._50to100

import se.embuc.Task

//SuDoku
class Task96(val input: String) : Task {

	data class SudokuCell(
		var value: Int = 0,
	)

	override fun solve(): Any {
		val input = input.split("\n")
		val grids = mutableListOf<List<List<Int>>>()
		for (i in input.indices step 10) {
			val grid = input.subList(i + 1, i + 10).map { it -> it.toCharArray().map { it.digitToInt() } }
			grids.add(grid)
		}

		var sum = 0
		for (grid in grids) {
			val initGrid = createSudokuGrid(grid)
			if (solveSudoku(initGrid)) {
				sum += initGrid[0][0].value * 100 + initGrid[0][1].value * 10 + initGrid[0][2].value
			}
		}

		return sum
	}

	private fun createSudokuGrid(grid: List<List<Int>>): Array<Array<SudokuCell>> {
		val result = Array(9) { Array(9) { SudokuCell(0) } }
		for (i in grid.indices) {
			for (j in grid[i].indices) {
				result[i][j] = SudokuCell(grid[i][j])
			}
		}
		return result
	}

	fun solveSudoku(grid: Array<Array<SudokuCell>>): Boolean {
		for (row in 0..8) {
			for (col in 0..8) {
				if (grid[row][col].value == 0) {
					// Try every number from 1 to 9
					for (num in 1..9) {
						if (isValid(grid, row, col, num)) {
							grid[row][col].value = num
							// Recursively solve the rest of the grid
							if (solveSudoku(grid)) {
								return true // If solved, return immediately
							}
							// Undo the move (backtrack)
							grid[row][col].value = 0
						}
					}
					// If no number fits, return false (trigger backtracking)
					return false
				}
			}
		}
		// If no empty cells are left, the puzzle is solved
		return true
	}

	fun isValid(grid: Array<Array<SudokuCell>>, row: Int, col: Int, num: Int): Boolean {
		// Check the row
		for (i in 0..8) {
			if (grid[row][i].value == num) return false
		}
		// Check the column
		for (i in 0..8) {
			if (grid[i][col].value == num) return false
		}
		// Check the 3x3 subgrid
		val subgridRowStart = (row / 3) * 3
		val subgridColStart = (col / 3) * 3
		for (r in subgridRowStart until subgridRowStart + 3) {
			for (c in subgridColStart until subgridColStart + 3) {
				if (grid[r][c].value == num) return false
			}
		}
		return true
	}

}