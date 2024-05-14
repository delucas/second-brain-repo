package delucas.leetcode;

public class RotateImage {

	public static void rotate90clockwise(int[][] matrix) {
		// transponer
		int n = matrix.length - 1;
		int aux;
		for (int i = 0; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				aux = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = aux;
			}
		}

		// reflejar
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n / 2; j++) {
				aux = matrix[i][j];
				matrix[i][j] = matrix[i][n - j];
				matrix[i][n - j] = aux;
			}
		}
	}

	public static void rotate90clockwiseAlt(int[][] matrix) {
		int n = matrix.length - 1;
		int aux;
		for (int nivel = 0; nivel <= n / 2; nivel++) {
			for (int offset = nivel; offset < n - nivel; offset++) {
				aux = matrix[nivel][nivel + offset];
				matrix[nivel][nivel + offset] = matrix[n - nivel - offset][nivel];
				matrix[n - nivel - offset][nivel] = matrix[n - nivel][n - nivel - offset];
				matrix[n - nivel][n - nivel - offset] = matrix[nivel + offset][n - nivel];
				matrix[nivel + offset][n - nivel] = aux;
			}
		}
	}
}
