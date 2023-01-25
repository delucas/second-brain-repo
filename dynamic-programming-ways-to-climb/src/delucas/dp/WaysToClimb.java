package delucas.dp;

import java.util.HashMap;
import java.util.Map;

public class WaysToClimb {

	public static int recursive(final int n, final int[] jumps) {
		if (n == 0)
			return 1;
		int ret = 0;
		for (int i = 0; i < jumps.length; i++) {
			int j = jumps[i];
			if (n - j >= 0)
				ret += recursive(n - j, jumps);
		}
		return ret;
	}

	public static int topDown(final int n, final int[] jumps) {
		return topDown(n, jumps, new HashMap<Integer, Integer>());
	}

	public static int topDown(final int n, final int[] jumps, final Map<Integer, Integer> mem) {
		if (!mem.containsKey(n)) {
			if (n == 0) {
				mem.put(0, 1);
			} else {
				int ways = 0;
				for (int i = 0; i < jumps.length; i++) {
					int j = jumps[i];
					if (n - j >= 0)
						ways += topDown(n - j, jumps, mem);
				}
				mem.put(n, ways);
			}
		}
		return mem.get(n);
	}

	public static int bottomUp(final int n, final int[] jumps) {
		int[] table = new int[n + 1];
		table[0] = 1;

		for (int i = 1; i <= n; i++) {
			int ways = 0;
			for (int k = 0; k < jumps.length; k++) {
				int jump = jumps[k];
				if (i - jump >= 0) {
					ways += table[i - jump];
				}
			}
			table[i] = ways;
		}

		return table[n];
	}
}
