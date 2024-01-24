package _50to100;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;
import se.embuc.utils.UtilsKt;

import java.util.*;

// Cubic permutation
public class JTask62 implements Task {
	@NotNull
	@Override
	public Object solve() {
		long upper_limit = 100_000L;
		Map<Integer, ArrayList<Long>> groupes = new HashMap<Integer, ArrayList<Long>>();
		for (long i = 300; i < upper_limit; i++) {
			var cube = i * i * i;
			var digitsCount = UtilsKt.digitsCount(cube);
			var digitsHash = Arrays.hashCode(digitsCount);
			groupes.computeIfAbsent(digitsHash, k -> new ArrayList<Long>()).add(cube);
			if (groupes.get(digitsHash).size() == 5){
				return Collections.min(groupes.get(digitsHash));
			}
		}
		return -1;
	}
}
