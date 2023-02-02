package delucas.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import delucas.utils.MyMath;
import delucas.utils.Pair;

public class EditDistance {

	public static int recursive(String word1, String word2, int i, int j) {
		if (i == word1.length())
			return word2.length() - j;
		if (j == word2.length())
			return word1.length() - i;
		if (word1.charAt(i) == word2.charAt(j))
			return recursive(word1, word2, i + 1, j + 1);
		else
			return 1 + MyMath.min(new int[] {
					recursive(word1, word2, i + 1, j + 1),
					recursive(word1, word2, i, j + 1),
					recursive(word1, word2, i + 1, j)
				});
	}
	
	public static int topDown(String word1, String word2, int i, int j) {
		return topDown(word1, word2, i, j, new HashMap<Pair, Integer>());
	}
	
	public static int topDown(String word1, String word2, int i, int j, Map<Pair, Integer> mem) {
		Pair currentKey = new Pair(i, j);
		
		if (!mem.containsKey(currentKey)) {
			if (i == word1.length())
				mem.put(currentKey, word2.length() - j);
			else if (j == word2.length())
				mem.put(currentKey, word1.length() - i);
			else if (word1.charAt(i) == word2.charAt(j))
				mem.put(currentKey, topDown(word1, word2, i + 1, j + 1, mem));
			else
				mem.put(currentKey, 1 + MyMath.min(new int[] {
						topDown(word1, word2, i + 1, j + 1, mem),
						topDown(word1, word2, i, j + 1, mem),
						topDown(word1, word2, i + 1, j, mem)
					}));
		}
		return mem.get(currentKey);
	}

	public static int bottomUp(String word1, String word2, int i, int j) {
		int n = word1.length();
		int m = word2.length();
		
		int[][] table = new int[n+1][m+1];
		
		for (int x = 1; x < table.length; x++) {
			table[x][0] = x;
		}
		
		for (int y = 1; y < table[0].length; y++) {
			table[0][y] = y;
		}
		
		for (int x = 1; x < table.length; x++) {
			for (int y = 1; y < table[0].length; y++) {
				if (word1.charAt(x-1) == word2.charAt(y-1))
					table[x][y] = table[x-1][y-1];
				else
					table[x][y] = 1 + MyMath.min(new int[] {
							table[x-1][y-1],
							table[x-1][y],
							table[x][y-1],
					});
			}
		}
		
		return table[n][m];
	}

	public static int optimizedBottomUp(String word1, String word2, int i, int j) {
		int n = word1.length();
		int m = word2.length();
		
		int[][] table = new int[2][m+1];
		
		for (int y = 1; y < table[0].length; y++) {
			table[0][y] = y;
		}
		
		for (int x = 1; x <= n; x++) {
			table[1][0] = x;
			for (int y = 1; y < table[0].length; y++) {
				if (word1.charAt(x-1) == word2.charAt(y-1))
					table[1][y] = table[0][y-1];
				else
					table[1][y] = 1 + MyMath.min(new int[] {
							table[0][y-1],
							table[0][y],
							table[1][y-1],
					});
			}
			table[0] = Arrays.copyOf(table[1], table[1].length);
		}
		return table[1][m];
	}	
}
