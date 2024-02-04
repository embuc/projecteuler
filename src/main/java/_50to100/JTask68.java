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
		return findMagicRing(10);
	}

	String findMagicRing(int n) {
		var values = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
		Collections.reverse(values);
		for (var permutation :lexicographicalPermutations(values)) {
			var split = n / 2;
			var outer = permutation.subList(0, split);
			var inner = permutation.subList(split, permutation.size());
			if (isValidGonRing(outer, inner)) {
				return formatGonRing(outer, inner);
			}
		}
		return null;
	}

	public static List<List<Integer>> lexicographicalPermutations(List<Integer> list) {
		if (list.size() == 1) {
			List<List<Integer>> singleResult = new ArrayList<>();
			singleResult.add(new ArrayList<>(list));
			return singleResult;
		} else {
			List<List<Integer>> result = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				List<Integer> rest = new ArrayList<>(list);
				rest.remove(i);
				for (List<Integer> end : lexicographicalPermutations(rest)) {
					List<Integer> perm = new ArrayList<>();
					perm.add(list.get(i));
					perm.addAll(end);
					result.add(perm);
				}
			}
			return result;
		}
	}

	public static boolean isValidGonRing(java.util.List<Integer> outer, List<Integer> inner) {
		int total = outer.get(0) + inner.get(0) + inner.get(1);
		for (int i = 1; i < outer.size(); i++) {
			if (outer.get(i) + inner.get(i) + inner.get((i + 1) % inner.size()) != total) {
				return false;
			}
		}
		return true;
	}

	public static String formatGonRing(List<Integer> outer, List<Integer> inner) {
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
