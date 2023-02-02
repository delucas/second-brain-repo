package delucas.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import delucas.utils.MyMath;
import delucas.utils.Pair;

public class GoldMine {

	public static int recursive(final int[][] mine) {
		int m = mine[0].length;
		
		int[] arr = new int[m];
		for (int j = 0; j < m; j++) {
			arr[j] = recursive(mine, 0, j);
		}
		return MyMath.max(arr);
	}

	private static int recursive(final int[][] mine, final int i, final int j) {
		final int n = mine.length;
		final int m = mine[0].length;

		if (j < 0 || j >= m || i >= n) return 0;
		else return mine[i][j] + MyMath.max(new int[] {
				recursive(mine, i+1, j-1),
				recursive(mine, i+1, j),
				recursive(mine, i+1, j+1),
		});
	}

	public static int topDown(final int[][] mine) {
		final int m = mine[0].length;
		
		int[] arr = new int[m];
		Map<Pair, Integer> mem = new HashMap<Pair, Integer>();
		for (int j = 0; j < m; j++) {
			arr[j] = topDown(mine, 0, j, mem);
		}
		return MyMath.max(arr);
	}
	
	private static int topDown(final int[][] mine, final int i, final int j, final Map<Pair, Integer> mem) {
		final int n = mine.length;
		final int m = mine[0].length;

		final Pair currentKey = new Pair(i, j);
		
		if (j < 0 || j >= m || i >= n)
			mem.put(currentKey, 0);
		else mem.put(currentKey, mine[i][j] + MyMath.max(new int[] {
				topDown(mine, i+1, j-1, mem),
				topDown(mine, i+1, j, mem),
				topDown(mine, i+1, j+1, mem),
		}));
		
		return mem.get(currentKey);
	}
	
	public static int bottomUp(final int[][] mine) {
		final int n = mine.length;
		final int m = mine[0].length;
		
		int[][] table = new int[n][m];
		
		for (int j = 0; j < m; j++) {
			table[0][j] = mine[0][j];
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				table[i][j] = table[i-1][j];
				if (j > 0)
					table[i][j] = Math.max(table[i][j], table[i-1][j-1]);
				if (j < m-1)
					table[i][j] = Math.max(table[i][j], table[i-1][j+1]);
				table[i][j] += mine[i][j];
			}
		}
		
		return MyMath.max(table[n-1]);
	}
	
	public static int optimizedBottomUp(final int[][] mine) {
		final int n = mine.length;
		final int m = mine[0].length;
		
		int[][] table = new int[2][m];
		
		for (int j = 0; j < m; j++) {
			table[0][j] = mine[0][j];
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				table[1][j] = table[0][j];
				if (j > 0)
					table[1][j] = Math.max(table[1][j], table[0][j-1]);
				if (j < m-1)
					table[1][j] = Math.max(table[1][j], table[0][j+1]);
				table[1][j] += mine[i][j];
			}
			table[0] = Arrays.copyOf(table[1], m);
		}
		
		return MyMath.max(table[1]);
	}
}
