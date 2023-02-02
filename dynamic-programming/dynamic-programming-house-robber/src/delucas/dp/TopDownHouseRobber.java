package delucas.dp;

import java.util.HashMap;
import java.util.Map;

public class TopDownHouseRobber {
	public static int rob(final int[] houses, final int i) {
		return rob(houses, i, new HashMap<Integer, Integer>());
	}
	
	public static int rob(final int[] houses, final int i, final Map<Integer, Integer> mem) {
		int n = houses.length;
		
		if (!mem.containsKey(i)) {
			if (i >= n) {
				mem.put(i, 0);
			} else {
				mem.put(i, Math.max(houses[i] + rob(houses, i + 2, mem), rob(houses, i + 1, mem)));
			}
		}
		return mem.get(i);
	}
}
