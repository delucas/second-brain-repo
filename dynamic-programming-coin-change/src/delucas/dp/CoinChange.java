package delucas.dp;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

	public static int recursive(final int amount, final int[] coins) {
		int min = _recursive(amount, coins);
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	private static int _recursive(final int amount, final int[] coins) {
		if (amount == 0)
			return 0;

		int min = Integer.MAX_VALUE - 1;
		for (int coin : coins) {
			if (amount >= coin) {
				min = Math.min(min, 1 + _recursive(amount - coin, coins));
			}
		}
		return min;
	}

	public static int topDown(final int amount, final int[] coins) {
		Map<Integer, Integer> mem = new HashMap<Integer, Integer>();
		mem.put(0, 0);

		int min = _topDown(amount, coins, mem);
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	private static int _topDown(final int amount, final int[] coins, Map<Integer, Integer> mem) {
		if (!mem.containsKey(amount)) {
			int min = Integer.MAX_VALUE - 1;
			for (int coin : coins) {
				if (amount >= coin) {
					min = Math.min(min, 1 + _topDown(amount - coin, coins, mem));
				}
			}
			mem.put(amount, min);
		}
		return mem.get(amount);
	}

	public static int bottomUp(final int amount, final int[] coins) {
		int[] table = new int[amount + 1];
		table[0] = 0;

		for (int i = 1; i <= amount; i++) {
			int min = Integer.MAX_VALUE - 1;
			for (int k = 0; k < coins.length; k++) {
				int coin = coins[k];
				if (i - coin >= 0) {
					min = Math.min(min, 1 + table[i - coin]);
				}
			}
			table[i] = min;
		}

		return table[amount] == Integer.MAX_VALUE ? -1 : table[amount];
	}

}
