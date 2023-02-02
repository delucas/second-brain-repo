package delucas.dp;

public class RecursivePathsInMatrix {
	
	public static int paths(final int[][] matrix, final int i, final int j) {
		int n = matrix.length;
		int m = matrix[0].length;

		if (i == n - 1 && j == m - 1) {
			return 1;
		} else if (i == n || j == m || matrix[i][j] == 1) {
			return 0;
		} else {
			return paths(matrix, i + 1, j) + paths(matrix, i, j + 1);
		}
	}
}
