package _1to50;

import se.embuc.Task;

// Coin Sums
public class JTask31 implements Task {
	@Override
	public Object solve() {
		var combinations = 1;
		int [] coins = {1, 2, 5, 10, 20, 50, 100};
		for(int a = 0; a <= 200/coins[6]; a++) {
			for(int b = 0; b <= 200 /coins[5]; b++) {
				for(int c = 0; c <= 200 /coins[4]; c++) {
					for(int d = 0; d <= 200 /coins[3]; d++) {
						for(int e = 0; e <= 200 /coins[2]; e++) {
							for(int f = 0; f <= 200 /coins[1]; f++) {
								for(int g = 0; g <= 200 /coins[0]; g++) {
									if (a * coins[6] + b * coins[5] + c * coins[4] + d * coins[3] + e * coins[2] + f * coins[1] + g * coins[0] == 200) {
										combinations++;
									}
								}
							}
						}
					}
				}
			}
		}
		return combinations;
	}
}
