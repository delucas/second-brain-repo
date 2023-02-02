package delucas.dp;

public class BottomUpHouseRobber {
	public static int rob(final int[] houses, final int i) {
		int n = houses.length;

		int[] table = new int[n];
		table[0] = houses[0];
		table[1] = houses[1];
		
		for (int x = 2; x < n; x++) {
			table[x] = Math.max(houses[x] + table[x - 2], table[x - 1]);
		}

		return table[n - 1];
	}
}
