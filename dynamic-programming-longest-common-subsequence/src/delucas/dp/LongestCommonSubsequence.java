package delucas.dp;

import java.util.HashMap;
import java.util.Map;

import delucas.utils.Pair;

public class LongestCommonSubsequence {

	public static int recursive(final String s1, final String s2, final int i, final int j) {
		if (i == s1.length() || j == s2.length())
			return 0;
		if (s1.charAt(i) == s2.charAt(j))
			return 1 + recursive(s1, s2, i + 1, j + 1);

		return Math.max(recursive(s1, s2, i + 1, j), recursive(s1, s2, i, j + 1));
	}
	
	public static int topDown(final String s1, final String s2, final int i, final int j) {
		return topDown(s1, s2, i, j, new HashMap<Pair, Integer>());
	}
	
	public static int topDown(final String s1, final String s2, final int i, final int j, final Map<Pair, Integer> mem) {
		final Pair currentKey = new Pair(i, j);
		
		if (!mem.containsKey(currentKey)) {
			if (i == s1.length() || j == s2.length())
				mem.put(currentKey, 0);
			else if (s1.charAt(i) == s2.charAt(j))
				mem.put(currentKey, 1 + topDown(s1, s2, i + 1, j + 1, mem));
			else
				mem.put(currentKey, Math.max(
						topDown(s1, s2, i + 1, j, mem),
						topDown(s1, s2, i, j + 1, mem)));
		}
		return mem.get(currentKey);
	}
	
	public static int bottomUp(final String s1, final String s2, final int i, final int j) {
		final int n = s1.length();
		final int m = s2.length();
		int[][] table = new int[n + 1][m + 1];

		for (int x = 1; x <= n; x++)
			for (int y = 1; y <= m; y++)
				if (s1.charAt(x - 1) == s2.charAt(y - 1))
					table[x][y] = 1 + table[x - 1][y - 1];
				else
					table[x][y] = Math.max(table[x][y - 1], table[x - 1][y]);
		return table[n][m];
	}
	
	public static int optimizedBottomUp(final String s1, final String s2, final int i, final int j) {
		final int n = s1.length();
		final int m = s2.length();
		int[][] table = new int[2][m + 1];

		for (int x = 1; x <= n; x++) {
			for (int y = 1; y <= m; y++) {
				if (s1.charAt(x - 1) == s2.charAt(y - 1))
					table[1][y] = 1 + table[0][y - 1];
				else
					table[1][y] = Math.max(table[1][y - 1], table[0][y]);
			}
			table[0] = table[1];
		}
		return table[1][m];
	}

}
