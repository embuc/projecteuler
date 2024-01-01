package _1to50;

import org.jetbrains.annotations.NotNull;
import se.embuc.Task;

// Coin Sums
public class JTask31 implements Task {
	@NotNull
	private final int[] coins;
	private final int amount;

	public JTask31(@NotNull int[] coins, int amount) {
		this.coins = coins;
		this.amount = amount;
	}

	@Override
	public Object solve() {
		int[][] waysToMakeAmount = new int[amount + 1][coins.length];

		// There is 1 way to make amount 0 (using no coins)
		for (int coinIndex = 0; coinIndex < coins.length; coinIndex++) {
			waysToMakeAmount[0][coinIndex] = 1;
		}

		// Calculate the number of ways to make each amount
		for (int amount = 1; amount <= this.amount; amount++) {
			for (int coinIndex = 0; coinIndex < coins.length; coinIndex++) {
				int waysWithoutCurrentCoin = coinIndex > 0 ? waysToMakeAmount[amount][coinIndex - 1] : 0;
				int remainingAmount = amount - coins[coinIndex];
				int waysWithCurrentCoin = remainingAmount >= 0 ? waysToMakeAmount[remainingAmount][coinIndex] : 0;

				waysToMakeAmount[amount][coinIndex] = waysWithoutCurrentCoin + waysWithCurrentCoin;
			}
		}

		return waysToMakeAmount[amount][coins.length - 1];
	}
}
