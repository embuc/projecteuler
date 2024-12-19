package _50to100;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;
import se.embuc.utils.PrimesKt;

import java.util.HashSet;

//Prime Power Triples
public class JTask87 implements Task {

	@NotNull
	@Override
	public Object solve() {
		var limit = 50_000_000;
		int nbrOfPrimes = (int) Math.sqrt(limit) + 1;
		var primes = PrimesKt.getPrimesBelow(nbrOfPrimes).getFirst();
		var results = new HashSet<Integer>();
		for (var prime : primes) {
			var primeSquare = prime * prime;
			if (primeSquare >= limit) {
				break;
			}
			for (var prime2 : primes) {
				var primeQube = (int) Math.pow((double) prime2, 3);
				if (primeQube >= limit) {
					break;
				}
				for (var prime3 : primes) {
					var primeFourth = (int) Math.pow((double) prime3, 4);
					if (primeFourth >= limit) {
						break;
					}
					var result = primeSquare + primeQube + primeFourth;
					if (result >= limit) {
						break;
					}
					results.add(result);
				}
			}
		}
		return results.size();
	}
}
