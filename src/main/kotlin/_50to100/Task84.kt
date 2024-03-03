package se.embuc._50to100
import se.embuc.Task
import kotlin.random.Random

// Monopoly odds (using Monte Carlo simulation)
class Task84 : Task {
	override fun solve(): Any {
		val board = arrayOf("GO", "A1", "CC1", "A2", "T1", "R1", "B1", "CH1", "B2", "B3",
			"JAIL", "C1", "U1", "C2", "C3", "R2", "D1", "CC2", "D2", "D3",
			"FP", "E1", "CH2", "E2", "E3", "R3", "F1", "F2", "U2", "F3",
			"G2J", "G1", "G2", "CC3", "G3", "R4", "CH3", "H1", "T2", "H2")

		val ch = ("GO,JAIL,C1,E3,H2,R1,RN,RN,UN,-3" + ",*".repeat(6)).split(',').toMutableList()
		val cc = ("GO,JAIL" + ",*".repeat(14)).split(',').toMutableList()

		val visit = IntArray(40)
		var pos = 0
		var dbl = 0

		repeat(1_000_000) {
			val d1 = Random.nextInt(1, 5) // 1 to 4
			val d2 = Random.nextInt(1, 5) // 1 to 4
			dbl = if (d1 == d2) dbl + 1 else 0

			if (dbl == 3) {
				dbl = 0
				pos = 10 // To Jail
			} else {
				pos = (pos + d1 + d2) % 40
			}

			if (pos == 30) { // Go to Jail
				pos = 10
				dbl = 0
			} else {
				when (board[pos].substring(0, 2)) {
					"CC" -> {
						if (cc[0] != "*") pos = board.indexOf(cc[0])
						cc.add(cc.removeAt(0))
					}
					"CH" -> {
						when (ch[0]) {
							"-3" -> pos -= 3
							"RN" -> pos = when (pos) {
								in 0..5, in 36..39 -> 5
								in 6..15 -> 15
								in 16..25 -> 25
								else -> 35
							}
							"UN" -> pos = if (pos < 12 || pos > 28) 12 else 28
							else -> if (ch[0] != "*") pos = board.indexOf(ch[0])
						}
						ch.add(ch.removeAt(0))
					}
				}
			}
			visit[pos]++
		}

		val sortedIndices = visit.indices.sortedByDescending { visit[it] }.take(3)

		// Print the indices and visit counts
//		println("Top 3 visited tiles:")
//		sortedIndices.forEach { index ->
//			println("Index: $index (${board[index]}) with ${visit[index]} visits")
//		}

		return sortedIndices.joinToString("") { index -> String.format("%02d", index)}
	}
}