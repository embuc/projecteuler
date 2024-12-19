package se.embuc._50to100

import se.embuc.Task
import se.embuc.utils.DynamicDirectedGraph
import se.embuc.utils.readFileAsString

// Passcode derivation
class Task79:Task {
	override fun solve(): Any {
		val graph = DynamicDirectedGraph()
		readFileAsString("79_keylog.txt").lines().forEach {
			graph.addEdge(it[0] - '0', it[1] - '0')
			graph.addEdge(it[1] - '0', it[2] - '0')
		}
		val order = graph.topologicalSort()
		return order.joinToString("")
	}

}