package _1to50;

import kotlin.Pair;
import se.embuc.Task;

import static se.embuc.utils.UtilsKt.getPentagonalNumbers;

// Pentagonal numbers
public class JTask44 implements Task {
	@Override
	public Object solve() {
		Pair<int[], boolean[]> pentagonalNumbers = getPentagonalNumbers(5000);
		var keys = pentagonalNumbers.getFirst();
		var dict = pentagonalNumbers.getSecond();
		for (int i = 0; i < keys.length /2; i++) {
			for (int j = i + 1; j < keys.length/2; j++) {
				var sum = keys[i] + keys[j];
				var diff = keys[j] - keys[i];
				if (dict[diff] && dict[sum]) {
					return diff;
				}
			}
		}
		return -1;
	}
}
