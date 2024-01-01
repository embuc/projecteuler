package _1to50;

import se.embuc.Task;

import java.math.BigInteger;
import java.util.HashSet;

// Distinct powers
public class JTask29 implements Task {

	@Override
	public Object solve() {
		var seq = new HashSet<BigInteger>();
		for (int a = 2; a <= 100; a++) {
			for (int b = 2; b <= 100; b++) {
				seq.add(BigInteger.valueOf(a).pow(b));
			}
		}
		return seq.size();
	}
}
