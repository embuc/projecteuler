package se.embuc

fun placeQueens(boardSize: Int): List<List<String>> {
	val results = mutableListOf<List<String>>()
	val board = Array(boardSize) { CharArray(boardSize) { '.' } }
	solveNQueens(board, 0, results)
	return results
}

fun solveNQueens(board: Array<CharArray>, row: Int, results: MutableList<List<String>>) {
	if (row == board.size) {
		results.add(board.map { it.joinToString("") })
		return
	}

	for (col in board.indices) {
		if (isValid(board, row, col)) {
			board[row][col] = 'Q' // Place the queen
			solveNQueens(board, row + 1, results)
			board[row][col] = '.' // Backtrack
		}
	}
}

fun isValid(board: Array<CharArray>, row: Int, col: Int): Boolean {
	for (i in 0 until row) {
		if (board[i][col] == 'Q') return false
	}
	var (r, c) = row to col
	while (r >= 0 && c >= 0) {
		if (board[r][c] == 'Q') return false
		r--; c--
	}
	r = row; c = col
	while (r >= 0 && c < board.size) {
		if (board[r][c] == 'Q') return false
		r--; c++
	}
	return true
}

fun main() {
	val solutions = placeQueens(4)
	solutions.forEach { solution ->
		solution.forEach { println(it) }
		println()
	}
}
