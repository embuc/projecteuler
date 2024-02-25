package _50to100;

import se.embuc.Task;
import se.embuc.utils.BigNumbersKt;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static se.embuc.utils.BigNumbersKt.sqrt;

// Square Root Digital Expansion
public class JTask80 implements Task {
	@Override
	public Object solve() {
		return sumOfDecimalParts((IntStream.range(2,100)
										.mapToObj(n-> sqrt(BigDecimal.valueOf(n), 101)))
										.collect(toList()));
	}

	private int sumOfDecimalParts(List<BigDecimal> numbers) {
		return numbers.stream()
				.filter(BigNumbersKt::hasNonZeroDecimalDigits)
				.mapToInt(BigNumbersKt::digitsSum)
				.sum();
	}

}
