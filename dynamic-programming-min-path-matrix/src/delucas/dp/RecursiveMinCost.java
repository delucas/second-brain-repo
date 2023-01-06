package delucas.dp;

public class RecursiveMinCost {
	public static int minCost(final int[][] matrix, final int i, final int j) {
		int n = matrix.length;
		int m = matrix[0].length;

		if (i == n - 1 && j == m - 1) {
			return matrix[i][j];
		} else if (i == n - 1) {
			return matrix[i][j] + minCost(matrix, i, j + 1);
		} else if (j == m - 1) {
			return matrix[i][j] + minCost(matrix, i + 1, j);
		} else {
			return matrix[i][j] +
					Math.min(minCost(matrix, i + 1, j), minCost(matrix, i, j + 1));
		}
	}
}
