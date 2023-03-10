package delucas.dp;

public class RecursiveHouseRobber {
	public static int rob(final int[] houses, final int i) {
		int n = houses.length;
		if (i >= n) {
			return 0;
		}
		return Math.max(houses[i] + rob(houses, i + 2), rob(houses, i + 1));
	}

}
