package delucas.dp;

public class OptimizedBottomUpMinCost {
	public static int minCost(final int[][] matrix, final int i, final int j) {
		int n = matrix.length;
		int m = matrix[0].length;

		int table[][] = new int[2][m];

		table[0][0] = matrix[0][0];

		for (int y = 1; y < m; y++) {
			table[0][y] = matrix[0][y] + table[0][y - 1];
		}

		for (int x = 1; x < n; x++) {
			table[1][0] = matrix[x][0] + table[0][0];
			for (int y = 1; y < m; y++) {
				table[1][y] = matrix[x][y] + Math.min(table[0][y], table[1][y - 1]);
			}
			table[0] = table[1];
		}

		return table[0][m - 1];
	}
}
