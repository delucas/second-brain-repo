package delucas.dp;

import java.util.Arrays;

public class HouseRobber2 {

	public int recursive(int[] houses) {
		int[] housesWithoutLast = Arrays.copyOf(houses, houses.length - 1);
		return Math.max(rob(houses, 1), rob(housesWithoutLast, 0));
	}

	public static int rob(final int[] houses, final int i) {
		int n = houses.length;
		if (i >= n) {
			return 0;
		}
		return Math.max(houses[i] + rob(houses, i + 2), rob(houses, i + 1));
	}

}
