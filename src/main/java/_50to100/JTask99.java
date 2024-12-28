package _50to100;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;
import se.embuc.utils.FilesKt;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class JTask99 implements Task {

	@NotNull
	@Override
	public Object solve() {
		List<String> lines = FilesKt.readFileAsString("0099_base_exp.txt").lines().toList();

		// Use streams for efficient processing
		Map.Entry<Integer, Double> maxEntry = lines.stream()
				.map(line -> line.split(",")) // Split each line
				.map(parts -> {
					long a = Long.parseLong(parts[0]); // Parse base
					long b = Long.parseLong(parts[1]); // Parse exponent
					return new AbstractMap.SimpleEntry<>(a, b);
				})
				.map(entry -> new AbstractMap.SimpleEntry<>(lines.indexOf(lines.stream().filter(l ->
								l.contains(entry.getKey() + "," + entry.getValue()))
						.findFirst().orElse("not found")) + 1, // Calculate index + 1
						entry.getValue() * Math.log(entry.getKey().doubleValue()))) // Calculate b * log(a)
				.max(Comparator.comparingDouble(Map.Entry::getValue))  // Find the maximum based on the calculated value
				.orElseThrow(() -> new IllegalStateException("No max found, check file"));  //handle if not found

		return maxEntry.getKey(); // Return the index (the first part of the pair)
	}
}
