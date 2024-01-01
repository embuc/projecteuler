package _1to50;

import se.embuc.Task;

import java.util.stream.IntStream;

public class JTask17 implements Task {

	@Override
	public Object solve() {
		return IntStream.rangeClosed(1, 1000)
				.mapToObj(JTask17::toEnglish)
				.mapToInt(String::length)
				.sum();
	}

	private static final String[] BELOW_TWENTY = {
			"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
	};
	private static final String[] TENS = {
			"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
	};

	/* without spaces */
	private static String toEnglish(int i) {
		if (i == 1000) return "onethousand";

		if (i >= 100) {
			return BELOW_TWENTY[i / 100] + "hundred" + (i % 100 != 0 ? "and" + toEnglish(i % 100) : "");
		}
		if (i >= 20) {
			return TENS[i / 10] + (i % 10 != 0 ? "" + BELOW_TWENTY[i % 10] : "");
		}
		return BELOW_TWENTY[i];
	}

}
