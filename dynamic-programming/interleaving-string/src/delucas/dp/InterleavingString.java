package delucas.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import delucas.utils.Pair;

public class InterleavingString {

	public static boolean recursive(final String s1, final String s2, final String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		return recursive(s1, s2, s3, 0, 0);
	}

	private static boolean recursive(final String s1, final String s2, final String s3, final int i, final int j) {
		if (i == s1.length() && j == s2.length())
			return true;
		else
			return i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && recursive(s1, s2, s3, i + 1, j)
					|| j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && recursive(s1, s2, s3, i, j + 1);
	}
	
	public static boolean topDown(final String s1, final String s2, final String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		return topDown(s1, s2, s3, 0, 0, new HashMap<Pair, Boolean>());
	}

	private static boolean topDown(final String s1, final String s2, final String s3, final int i, final int j, final Map<Pair, Boolean> mem) {
		Pair currentKey = new Pair(i, j);
		
		if (!mem.containsKey(currentKey)) {
			if (i == s1.length() && j == s2.length())
				mem.put(currentKey, true);
			else
				mem.put(currentKey, i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && recursive(s1, s2, s3, i + 1, j)
						|| j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && recursive(s1, s2, s3, i, j + 1));
		}
		return mem.get(currentKey);
	}
	
	public static boolean bottomUp(final String s1, final String s2, final String s3) {
		int n = s1.length();
		int m = s2.length();
		
		boolean[][] table = new boolean[n+1][m+1];
		table[0][0] = true;
		
		for (int j = 1; j < table[0].length; j++)
			table[0][j] = s2.charAt(j-1) == s3.charAt(j-1) && table[0][j-1];
		
		for (int i = 1; i < table.length; i++) {
			table[i][0] = s1.charAt(i-1) == s3.charAt(i-1) && table[i-1][0];
			for (int j = 1; j < table[0].length; j++)
				table[i][j] = s1.charAt(i - 1) == s3.charAt(i + j - 1) && table[i - 1][j]
						|| s2.charAt(j - 1) == s3.charAt(i + j - 1) && table[i][j - 1];
		}
		
		return table[n][m];
	}
	
	public static boolean optimizedBottomUp(final String s1, final String s2, final String s3) {
		int n = s1.length();
		int m = s2.length();
		
		boolean[][] table = new boolean[2][m+1];
		table[0][0] = true;
		
		for (int j = 1; j < table[0].length; j++)
			table[0][j] = s2.charAt(j-1) == s3.charAt(j-1) && table[0][j-1];
		
		for (int i = 1; i < n + 1; i++) {
			table[1][0] = s1.charAt(i-1) == s3.charAt(i-1) && table[0][0];
			for (int j = 1; j < table[0].length; j++)
				table[1][j] = s1.charAt(i - 1) == s3.charAt(i + j - 1) && table[0][j]
						|| s2.charAt(j - 1) == s3.charAt(i + j - 1) && table[1][j - 1];
			table[0] = Arrays.copyOf(table[1], table[1].length);
		}
		
		return table[1][m];
	}
}
