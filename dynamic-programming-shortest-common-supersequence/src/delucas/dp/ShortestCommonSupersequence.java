package delucas.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import delucas.utils.Pair;

public class ShortestCommonSupersequence {

	public static int reutilize(final String s1, final String s2, final int i, final int j) {
		return s1.length() + s2.length() - LongestCommonSubsequence.topDown(s1, s2, i, j);
	}
	
	public static int recursive(final String s1, final String s2, final int i, final int j) {
		if (i == s1.length())
			return s2.length() - j;
		if (j == s2.length())
			return s1.length() - i;
		if (s1.charAt(i) == s2.charAt(j))
			return 1 + recursive(s1, s2, i + 1, j + 1);

		return 1 + Math.min(recursive(s1, s2, i + 1, j), recursive(s1, s2, i, j + 1));
	}
	
	public static int topDown(final String s1, final String s2, final int i, final int j) {
		return topDown(s1, s2, i, j, new HashMap<Pair, Integer>());
	}
	
	public static int topDown(final String s1, final String s2, final int i, final int j, final Map<Pair, Integer> mem) {
		final Pair currentKey = new Pair(i, j);
		
		if (!mem.containsKey(currentKey)) {
			if (i == s1.length())
				mem.put(currentKey, s2.length() - j);
			else if (j == s2.length())
				mem.put(currentKey, s1.length() - i);
			else if (s1.charAt(i) == s2.charAt(j))
				mem.put(currentKey, 1 + topDown(s1, s2, i + 1, j + 1, mem));
			else
				mem.put(currentKey, 1 + Math.min(
						topDown(s1, s2, i + 1, j, mem),
						topDown(s1, s2, i, j + 1, mem)));
		}
		return mem.get(currentKey);
	}
	
	public static int bottomUp(final String s1, final String s2, final int i, final int j) {
		final int n = s1.length();
		final int m = s2.length();
		int[][] table = new int[n + 1][m + 1];

		for (int y = 1; y <= m; y++)
			table[0][y] = y;
		
		for (int x = 1; x <= n; x++)
			table[x][0] = x;
		
		for (int x = 1; x <= n; x++)
			for (int y = 1; y <= m; y++)
				if (s1.charAt(x - 1) == s2.charAt(y - 1))
					table[x][y] = 1 + table[x - 1][y - 1];
				else
					table[x][y] = 1 + Math.min(table[x][y - 1], table[x - 1][y]);
		return table[n][m];
	}
	
	public static int optimizedBottomUp(final String s1, final String s2, final int i, final int j) {
		final int n = s1.length();
		final int m = s2.length();
		int[][] table = new int[2][m + 1];

		for (int y = 1; y <= m; y++)
			table[0][y] = y;
		
		for (int x = 1; x <= n; x++) {
			table[1][0] = x;
			for (int y = 1; y <= m; y++) {
				if (s1.charAt(x - 1) == s2.charAt(y - 1))
					table[1][y] = 1 + table[0][y - 1];
				else
					table[1][y] = 1 + Math.min(table[1][y - 1], table[0][y]);
			}
			table[0] = Arrays.copyOf(table[1], table[1].length);
		}
		return table[1][m];
	}
}