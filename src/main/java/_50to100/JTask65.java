package _50to100;

import kotlin.Pair;
import se.embuc.Task;

import java.math.BigInteger;

// Convergents of e
//e=1+ 1/1! + 1/2! + 1/3! + ...
public class JTask65 implements Task {
	@Override
	public Object solve() {
		Pair<BigInteger, BigInteger> numDenum = computeEConvergent(100);
		return numDenum.getFirst().toString().chars().map(c -> c - '0').sum();
	}

	Pair<BigInteger, BigInteger> computeEConvergent(int terms)
	{
		var numerator = BigInteger.ONE;
		var denominator = BigInteger.ZERO;

		for(int i = terms - 1; i >= 0; i--)
		{
			var term = nextFractionTerm(i);
			var temp = BigInteger.valueOf(term).multiply(numerator).add(denominator);
			denominator = numerator;
			numerator = temp;
		}

		var gcd = numerator.gcd(denominator);
		return new Pair(numerator.divide(gcd), denominator.divide(gcd));
	}

	private int nextFractionTerm(int i) {
		return (i == 0) ? 2 : (i % 3 == 2) ?i / 3 * 2 + 2 : 1;
	}
}
