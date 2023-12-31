package _1to100;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static se.embuc.utils.UtilsKt.computeNthPermutation;

// Lexicographic Permutations
public class JTask24 implements Task {
	@NotNull
	@Override
	public Object solve() {
		var s = "0123456789";
		return computeNthPermutation(s.chars().mapToObj(c -> (char) c).collect(Collectors.toList()), 1_000_000);
//		return permute(s).stream().sorted().toList().get(999999);
	}

	static List<String> permute(String str) {
		List<String> permutations = new ArrayList<>();
		permuteHelper(str, 0, str.length() - 1, permutations);
		return permutations;
	}

	private static void permuteHelper(String str, int l, int r, List<String> permutations) {
		if (l == r) {
			permutations.add(str);
		} else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permuteHelper(str, l + 1, r, permutations);
				str = swap(str, l, i); // backtrack
			}
		}
	}

	private static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	public static void main(String[] args) {
		permute("ABC");
	}
}
