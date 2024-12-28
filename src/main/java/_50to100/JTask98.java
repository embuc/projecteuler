package _50to100;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static se.embuc.utils.FilesKt.readFileAsString;

public class JTask98 implements Task {

	@NotNull
	@Override
	public Object solve() {
		List<String> words = Arrays.stream(readFileAsString("0098_words.txt").split(",")).toList().stream()
				.map(word -> word.replace("\"", ""))
				.toList();

		Map<String, List<String>> anagramGroups = words.stream()
				.collect(Collectors.groupingBy(word ->
						word.chars()
								.sorted()
								.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
								.toString()
				));

		List<List<String>> anagrams = anagramGroups.values().stream()
				.filter(group -> group.size() > 1)
				.toList();


		long maxSquare = 0L;

		// Cache squares by length
		Map<Integer, List<Long>> squaresByLength = new HashMap<>();

		for (List<String> group : anagrams) {
			int wordLength = group.get(0).length();

			// Get or compute squares for this length
			List<Long> squares = squaresByLength.computeIfAbsent(wordLength, length -> {
				long start = (long) Math.pow(10.0, length - 1);
				long end = (long) Math.pow(10.0, length) - 1;
				List<Long> squareList = new ArrayList<>();

				for (long i = (long) Math.sqrt(start); ; i++) {
					long square = i * i;
					if (square > end) break;
					if(String.valueOf(square).length() == length) {
						squareList.add(square);
					}
				}
				return squareList;
			});

			// Check all pairs in group
			for (int i = 0; i < group.size(); i++) {
				for (int j = i + 1; j < group.size(); j++) {
					maxSquare = Math.max(maxSquare, findLargestSquare(group.get(i), group.get(j), squares));
				}
			}
		}
		return maxSquare;
	}

	private long findLargestSquare(String word1, String word2, List<Long> squares) {
		if (word1.length() != word2.length()) return 0;  // Safety check
		long largest = 0L;

		for (long square : squares) {
			String squareStr = String.valueOf(square);
			if (squareStr.charAt(0) == '0' || squareStr.length() != word1.length()) continue;

			Map<Character, Character> mapping = tryCreateMapping(word1, squareStr);
			if (mapping == null) continue;

			Long mapped = mapWordToNumber(word2, mapping);
			if (mapped == null) continue;

			if(String.valueOf(mapped).charAt(0) != '0' && squares.contains(mapped)) {
				largest = Math.max(largest, Math.max(square, mapped));
			}
		}
		return largest;
	}

	private Map<Character, Character> tryCreateMapping(String word, String number) {
		if (word.length() != number.length()) return null;  // Length check

		Map<Character, Character> mapping = new HashMap<>();
		Set<Character> usedDigits = new HashSet<>();

		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			char digit = number.charAt(i);

			if (mapping.containsKey(letter)) {
				if (mapping.get(letter) != digit) return null;
			} else {
				if (usedDigits.contains(digit)) return null;
				mapping.put(letter, digit);
				usedDigits.add(digit);
			}
		}
		return mapping;
	}

	private Long mapWordToNumber(String word, Map<Character, Character> mapping) {
		try {
			StringBuilder sb = new StringBuilder();
			for(char c : word.toCharArray()){
				sb.append(mapping.get(c));
			}
			return Long.parseLong(sb.toString());
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
