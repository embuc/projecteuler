package _1to100;

import se.embuc.Task;

// Number spiral diagonals
// Kotlin solution is more 'computer' solution while this is more of a 'pen and paper' solution - Kotlin
// version can be replaced with quadratic formula: 4n2-6n+6 (same thing)
public class JTask28 implements Task {

	@Override
	public Object solve() {
		long sum = 1;
		int odd = 1;
		for (int i = 1; i <= 500; i++){
			odd = 2 * i + 1;
			sum += 4 * odd * odd - 6*odd  + 6;
		}
		return sum;
	}
}
