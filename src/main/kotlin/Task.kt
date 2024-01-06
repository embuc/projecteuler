package se.embuc

import kotlin.system.measureTimeMillis

@JvmDefaultWithCompatibility
interface Task {

	fun solveWithTime(): Any {
		var result = Any()
		val timeTaken = measureTimeMillis {
			result = solve()
		}
		println("Time taken: $timeTaken ms")
		return result
	}

	fun solve(): Any
}