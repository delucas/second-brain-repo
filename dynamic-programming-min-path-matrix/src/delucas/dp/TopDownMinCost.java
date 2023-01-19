package delucas.dp;

import java.util.HashMap;
import java.util.Map;

public class TopDownMinCost {
	public static int minCost(final int[][] matrix, final int i, final int j) {
		return minCost(matrix, i, j, new HashMap<Pair, Integer>());
	}

	public static int minCost(final int[][] matrix, final int i, final int j, Map<Pair, Integer> mem) {
		Pair currentKey = new Pair(i, j);

		if (mem.containsKey(currentKey)) {
			return mem.get(currentKey);
		}

		int n = matrix.length;
		int m = matrix[0].length;

		if (i == n - 1 && j == m - 1) {
			mem.put(currentKey, matrix[i][j]);
		} else if (i == n - 1) {
			mem.put(currentKey, matrix[i][j] + minCost(matrix, i, j + 1, mem));
		} else if (j == m - 1) {
			mem.put(currentKey, matrix[i][j] + minCost(matrix, i + 1, j, mem));
		} else {
			mem.put(currentKey,
					matrix[i][j] + Math.min(minCost(matrix, i + 1, j, mem), minCost(matrix, i, j + 1, mem)));
		}
		return mem.get(currentKey);
	}
}
