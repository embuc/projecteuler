package se.embuc.utils

class DynamicDirectedGraph {
	private val adjList: MutableMap<Int, MutableList<Int>> = mutableMapOf()

	fun addEdge(u: Int, v: Int) {
		adjList.computeIfAbsent(u) { mutableListOf() }.add(v)
		adjList.putIfAbsent(v, mutableListOf()) // Ensure target node is in the graph, even if it has no outgoing edges
	}

	// A utility function to perform DFS and help in topological sorting
	private fun topologicalSortUtil(v: Int, visited: MutableSet<Int>, stack: MutableList<Int>) {
		visited.add(v)
		adjList[v]?.forEach { if (it !in visited) topologicalSortUtil(it, visited, stack) }
		stack.add(v) //when all nodes reachable from v are visited, add v to stack
	}

	fun topologicalSort(): List<Int> {
		val visited = mutableSetOf<Int>()
		val stack = mutableListOf<Int>()

		adjList.keys.forEach { if (it !in visited) topologicalSortUtil(it, visited, stack) }

		return stack.asReversed()
	}
}

