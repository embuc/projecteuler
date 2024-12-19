package _50to100;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;
import se.embuc.utils.FilesKt;

import java.util.Arrays;
import java.util.List;

public class JTask89 implements Task {

	@NotNull
	@Override
	public Object solve() {
		var input = Arrays.stream(FilesKt.readFileAsString("89.txt").split("\n")).toList();
		return convertRomanToMinimal(input);
	}

	private int convertRomanToMinimal(List<String> input) {
		var saved = 0;
		for (String line : input) {
			var minimal = line;
			minimal = minimal.replace("DCCCC", "CM");
			minimal = minimal.replace("CCCC", "CD");
			minimal = minimal.replace("LXXXX", "XC");
			minimal = minimal.replace("XXXX", "XL");
			minimal = minimal.replace("VIIII", "IX");
			minimal = minimal.replace("IIII", "IV");
			saved += line.length() - minimal.length();
		}
		return saved;
	}
}
