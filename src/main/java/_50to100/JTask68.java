package _50to100;

import se.embuc.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Magic 5-gon ring
public class JTask68 implements Task {
	@Override
	public Object solve() {
		return findValidGonRing(10);
	}

	public static String findValidGonRing(int n) {
		List<Integer> values = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			values.add(i);
		}
		Collections.reverse(values);
		return findValidGonRing(values, new ArrayList<>(), n / 2);
	}

	// Recursive method to generate permutations and immediately check for validity, this is as close to Kotlin sequence
	// as we can come.
	private static String findValidGonRing(List<Integer> available, List<Integer> current, int split) {
		if (available.isEmpty()) {
			List<Integer> outer = new ArrayList<>(current.subList(0, split));
			List<Integer> inner = new ArrayList<>(current.subList(split, current.size()));
			if (isValidGonRing(outer, inner)) {
				return formatGonRing(outer, inner);
			}
			return null;
		} else {
			for (int i = 0; i < available.size(); i++) {
				List<Integer> nextAvailable = new ArrayList<>(available);
				List<Integer> nextCurrent = new ArrayList<>(current);
				nextCurrent.add(nextAvailable.remove(i));
				String result = findValidGonRing(nextAvailable, nextCurrent, split);
				if (result != null) {
					// Found a valid configuration, return it
					return result;
				}
			}
			return null;
		}
	}

	private static boolean isValidGonRing(List<Integer> outer, List<Integer> inner) {
		int total = outer.get(0) + inner.get(0) + inner.get(1);
		for (int i = 1; i < outer.size(); i++) {
			if (outer.get(i) + inner.get(i) + inner.get((i + 1) % inner.size()) != total) {
				return false;
			}
		}
		return true;
	}

	private static String formatGonRing(List<Integer> outer, List<Integer> inner) {
		int rot = IntStream.range(0, outer.size())
				.reduce((i, j) -> outer.get(i) < outer.get(j) ? i : j)
				.orElse(0);

		List<Integer> rotatedOuter = rotate(outer, rot);
		List<Integer> rotatedInner = rotate(inner, rot);

		return IntStream.range(0, rotatedOuter.size())
				.mapToObj(i -> "" + rotatedOuter.get(i) + rotatedInner.get(i) + rotatedInner.get((i + 1) % inner.size()))
				.collect(Collectors.joining(""));
	}

	public static <T> List<T> rotate(List<T> list, int distance) {
		int listSize = list.size();
		List<T> result = new ArrayList<>(list);
		Collections.rotate(result, -distance);
		return result;
	}
}
