package delucas.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import delucas.utils.MyMath;
import delucas.utils.Pair;

public class SquareMatrixOfOnes {
	
	public static int recursive(final int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				max = Math.max(max, recursive(matrix, i, j));
			}
		}
		return max * max;
	}
	
	private static int recursive(final int[][] matrix, final int i, final int j) {
		if (i < 0 || j < 0 || matrix[i][j] == 0)
			return 0;
		return 1 + MyMath.min(new int[] {
				recursive(matrix, i-1, j),
				recursive(matrix, i, j-1),
				recursive(matrix, i-1, j-1)
				
		});
	}
	
	public static int topDown(final int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int max = 0;
		
		Map<Pair, Integer> mem = new HashMap<Pair, Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				max = Math.max(max, topDown(matrix, i, j, mem));
			}
		}
		return max * max;
	}
	
	private static int topDown(final int[][] matrix, final int i, final int j, final Map<Pair, Integer> mem) {
		Pair currentKey = new Pair(i, j);
		if (!mem.containsKey(currentKey)) {
			if (i < 0 || j < 0 || matrix[i][j] == 0)
				mem.put(currentKey, 0);
			else
				mem.put(currentKey, 1 + MyMath.min(new int[] {
					topDown(matrix, i-1, j, mem),
					topDown(matrix, i, j-1, mem),
					topDown(matrix, i-1, j-1, mem)
				}));
		}
		return mem.get(currentKey);
	}

	public static int bottomUp(final int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int [][] aux = new int[n][m];
		
		int greatestSquare = 0;
		
		aux[0][0] = matrix[0][0];
		for (int j = 1; j < m; j++) {
			aux[0][j] = matrix[0][j] + aux[0][j-1];
		}
		for (int i = 1; i < n; i++) {
			aux[i][0] = matrix[i][0] + aux[i-1][0];
			
			for (int j = 1; j < m; j++) {
				aux[i][j] = matrix[i][j] + aux[i-1][j] + aux[i][j-1] - aux[i-1][j-1];
				
				if (isSquare(aux[i][j]) && aux[i][j] > greatestSquare)
					greatestSquare = aux[i][j];
			}
		}
		return greatestSquare;		
	}
	
	public static int bottomUp2(final int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int [][] aux = new int[n][m];
		
		int max = 0;
		
		aux[0][0] = matrix[0][0];
		for (int j = 1; j < m; j++) {
			aux[0][j] = matrix[0][j];
		}
		for (int i = 1; i < n; i++) {
			aux[i][0] = matrix[i][0];
			
			for (int j = 1; j < m; j++) {
				aux[i][j] = matrix[i][j] == 1 ? 1 + MyMath.min(new int[] {aux[i-1][j], aux[i][j-1], aux[i-1][j-1]}) : 0;
				
				if (aux[i][j] > max)
					max = aux[i][j];
			}
		}
		return max * max;		
	}
	
	public static int optimizedBottomUp(final int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int [][] aux = new int[2][m];
		
		int greatestSquare = 0;
		
		aux[0][0] = matrix[0][0];
		for (int j = 1; j < m; j++) {
			aux[0][j] = matrix[0][j] + aux[0][j-1];
		}
		for (int i = 1; i < n; i++) {
			aux[1][0] = matrix[i][0] + aux[0][0];
			
			for (int j = 1; j < m; j++) {
				aux[1][j] = matrix[i][j] + aux[0][j] + aux[1][j-1] - aux[0][j-1];
				
				if (isSquare(aux[1][j]) && aux[1][j] > greatestSquare)
					greatestSquare = aux[1][j];
			}
			
			aux[0] = Arrays.copyOf(aux[1], aux[1].length);
		}
		return greatestSquare;		
	}

	private static boolean isSquare(int n) {
		double sqrt = Math.sqrt(n);
		return ((sqrt - Math.floor(sqrt)) == 0);
	}
	
}
