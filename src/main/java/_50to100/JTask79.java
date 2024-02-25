package _50to100;

import se.embuc.Task;
import se.embuc.utils.DynamicDirectedGraph;

import static se.embuc.utils.FilesKt.readFileAsString;

// Passcode derivation
public class JTask79 implements Task {
	@Override
	public Object solve() {
		var graph = new DynamicDirectedGraph();
		readFileAsString("79_keylog.txt").lines().forEach(s -> {
			var v = s.toCharArray();
			graph.addEdge(v[0] - '0', v[1] - '0');
			graph.addEdge(v[1] - '0', v[2] - '0');
		});
		var order = graph.topologicalSort();
		return order.stream().map(String::valueOf).reduce("", (a, b) -> a + b);
	}
}
