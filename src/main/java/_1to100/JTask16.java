package _1to100;

import se.embuc.Task;

import java.math.BigInteger;

// Power digit sum
public class JTask16 implements Task {

	@Override
	public Object solve() {
		return BigInteger.valueOf(2).pow(1000).toString().chars().map(Character::getNumericValue).sum();
	}
}
