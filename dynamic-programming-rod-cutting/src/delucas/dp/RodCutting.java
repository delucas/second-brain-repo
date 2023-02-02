package delucas.dp;

import java.util.HashMap;
import java.util.Map;

public class RodCutting {

	public static int recursive(final int[] prices) {
		return recursive(prices.length - 1, prices);
	}
	
	private static int recursive(final int n, final int[] prices) {
		int max = 0;
		for (int i = 1; i < n + 1; i++)
			max = Math.max(max, prices[i] + recursive(n - i, prices));
		return max;
	}
	
	public static int topDown(final int[] prices) {
		return topDown(prices.length - 1, prices, new HashMap<Integer, Integer>());
	}
	
	private static int topDown(final int n, final int[] prices, final Map<Integer, Integer> mem) {
		if (!mem.containsKey(n)) {
			int max = 0;
			for (int i = 1; i < n + 1; i++)
				max = Math.max(max, prices[i] + topDown(n - i, prices, mem));
			mem.put(n, max);
		}
		return mem.get(n);
	}

	public static int bottomUp(final int[] prices) {
		int n = prices.length - 1;
		int[] table = new int[n+1];
		
		for (int i = 1; i < n+1; i++) {
			for (int length = 1; length < i+1; length++) {
				table[i] = Math.max(table[i],
						prices[length] + table[i-length]);
			}
		}
		return table[n];
	}	
}
