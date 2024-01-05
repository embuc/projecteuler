package _1to50;

import se.embuc.Task;

import static se.embuc.utils.UtilsKt.findPositiveIntegerRoot;
import static se.embuc.utils.UtilsKt.getTriangleNumber;

// Triangular, pentagonal, and hexagonal
public class JTask45 implements Task {
	@Override
	public Object solve() {
		var n = 286L;
		while (true) {
			var triangle = getTriangleNumber(n++);
			if(findPositiveIntegerRoot(3 / 2.0, -1 / 2.0, -triangle) != null){
				if(findPositiveIntegerRoot(2.0, -1.0, -triangle) !=null) {
					return triangle;
				}
			}
		}
	}
}
