package _1to50;

import se.embuc.Task;

import java.util.Arrays;

import static se.embuc.utils.FilesKt.readFileAsString;
import static se.embuc.utils.UtilsKt.getTriangleNumbersUpTo;

// Coded triangle numbers
public class JTask42 implements Task {
	@Override
	public Object solve() {
		// build map of triangle numbers up to 364
		var triangleNumbers = getTriangleNumbersUpTo(364);
		return Arrays.stream(readFileAsString("42_words.txt").split(","))
				.map(w -> w.substring(1, w.length()-1)) // w.replace("\"", "")) concise but slow :/
				.map(w -> {
					// w.chars().map(c->c-64).sum() // concise but slow :/
					char[] arr = w.toCharArray();
					int sum = 0;
					for (char c : arr) {
						sum += c - 64;
					}
					return sum;
				})
				.filter(i -> triangleNumbers[i]).count();
	}
}
