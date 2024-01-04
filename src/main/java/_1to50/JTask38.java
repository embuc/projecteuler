package _1to50;

import se.embuc.Task;

import java.util.ArrayList;

import static se.embuc.utils.UtilsKt.isPanDigit;

// Pandigital multiples
public class JTask38 implements Task {
	@Override
	public Object solve() {
		// see kotlin version for explanation
		for (int i = 9876; i > 9183; i--){
			var number = "";
			var j = 1;
			var products = new ArrayList<Integer>();
			while (number.length() < 9){
				number += String.valueOf(i * j);
				products.add(i * j);
				j++;
			}
			int[] intArray = new int[products.size()];
			for (int k = 0; k < products.size(); k++) {
				intArray[k] = products.get(k);
			}
			if (number.length() == 9 && isPanDigit(intArray)){
				return number;
			}
		}
		return "";
	}
}
