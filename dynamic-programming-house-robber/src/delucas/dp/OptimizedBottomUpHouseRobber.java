package delucas.dp;

public class OptimizedBottomUpHouseRobber {
	public static int rob(int[] houses, int i) {
		int n = houses.length;

		int prevPrev = houses[0];
		int prev = houses[1];
		int cur = 0;
		
		for (int x = 2; x < n; x++) {
			cur = Math.max(houses[x] + prevPrev, prev);
			
			prevPrev = prev;
			prev = cur;
		}

		return cur;
	}
}
