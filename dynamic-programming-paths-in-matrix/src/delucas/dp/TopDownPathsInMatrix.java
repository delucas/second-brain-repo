package delucas.dp;

import java.util.HashMap;
import java.util.Map;

public class TopDownPathsInMatrix {

	public static int paths(final int[][] matrix, final int i, final int j) {
		return paths(matrix, i, j, new HashMap<Pair, Integer>());
	}

	private static int paths(final int[][] matrix, final int i, final int j, Map<Pair, Integer> mem) {
		int n = matrix.length;
		int m = matrix[0].length;

		Pair currentKey = new Pair(i, j);

		if (!mem.containsKey(currentKey)) {
			if (i == n - 1 && j == m - 1) {
				mem.put(currentKey, 1);
			} else if (i == n || j == m || matrix[i][j] == 1) {
				mem.put(currentKey, 0);
			} else {
				mem.put(currentKey, paths(matrix, i + 1, j, mem)
						+ paths(matrix, i, j + 1, mem));
			}
		}
		return mem.get(currentKey);
	}
}
