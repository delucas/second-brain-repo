package delucas.dp;

import java.util.HashMap;
import java.util.Map;

public class TopDownHouseRobber {
	public static int rob(int[] houses, int i) {
		return rob(houses, i, new HashMap<Integer, Integer>());
	}
	
	public static int rob(int[] houses, int i, Map<Integer, Integer> mem) {
		int n = houses.length;
		
		if (!mem.containsKey(i)) {
			if (i >= n) {
				mem.put(i, 0);
			} else {
				mem.put(i, Math.max(houses[i] + rob(houses, i + 2), rob(houses, i + 1)));
			}
		}
		return mem.get(i);
	}
}
