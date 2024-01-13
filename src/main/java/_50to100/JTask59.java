package _50to100;

import se.embuc.Task;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static se.embuc.utils.UtilsKt.readFileAsString;

// XOR Decryption
public class JTask59 implements Task {
	@Override
	public Object solve() {
		var file = readFileAsString("59_cipher.txt");
		var encrypted = Arrays.stream(file.split(",")).mapToInt(s -> Integer.parseInt(s.trim())).boxed().collect(
				Collectors.toList());
		var aChar = 'a';
		var zChar =  'z';
		for (int a = aChar; a <= zChar; a++) {
			for (int b = aChar; b <= zChar; b++) {
				for (int c = aChar; c <= zChar; c++) {
					// [101, 120, 112]
					var key = Arrays.asList( a, b, c);
					String decrypted = decrypt(encrypted, key);
					if (decrypted.contains(" the ")) {
//						System.out.println(decrypted);
						return decrypted.chars().sum();
					}
				}
			}
		}
		return -1;
	}

	private String decrypt(List<Integer> encrypted, List<Integer> key) {
		StringBuffer decrypted = new StringBuffer();
		for (int i = 0; i<encrypted.size();i++) {
			var keyChar = key.get(i % key.size());//rotate key bytes
			var decryptedChar = encrypted.get(i) ^ keyChar;
			decrypted.append((char) decryptedChar);
		}
		return decrypted.toString();
	}
}
