package delucas.dp;
public class BottomUpMinCost {
	public static int minCost(final int[][] matrix, final int i, final int j) {
		int n = matrix.length;
		int m = matrix[0].length;

		int table[][] = new int[n][m];

		table[0][0] = matrix[0][0];

		for (int x = 1; x < n; x++) {
			table[x][0] = matrix[x][0] + table[x - 1][0];
		}

		for (int y = 1; y < m; y++) {
			table[0][y] = matrix[0][y] + table[0][y - 1];
		}

		for (int x = 1; x < n; x++) {
			for (int y = 1; y < m; y++) {
				table[x][y] = matrix[x][y] + Math.min(table[x - 1][y], table[x][y - 1]);
			}
		}

		return table[n - 1][m - 1];
	}
}
