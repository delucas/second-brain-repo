package delucas.dp;

import java.util.HashMap;
import java.util.Map;

import delucas.utils.Pair;

public class MatrixChain {

	public static int recursive(final M[] matrices) {
		return recursive(matrices, 0, matrices.length - 1);
	}

	private static int recursive(final M[] matrices, final int i, final int j) {
		if (i == j)
			return 0;
		else {
			int min = Integer.MAX_VALUE;
			for (int k = i; k < j; k++) {
				int leftCost = recursive(matrices, i, k);
				int rightCost = recursive(matrices, k + 1, j);
				int prodCost = matrices[i].r * matrices[k].c * matrices[j].c;
				min = Math.min(min, leftCost + rightCost + prodCost);
			}
			return min;
		}
	}
	
	public static int topDown(final M[] matrices) {
		return topDown(matrices, 0, matrices.length - 1, new HashMap<Pair, Integer>());
	}

	private static int topDown(final M[] matrices, final int i, final int j, final Map<Pair, Integer> mem) {
		Pair currentKey = new Pair(i, j);
		
		if (!mem.containsKey(currentKey)) {
			if (i == j)
				mem.put(currentKey, 0);
			else {
				int min = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int leftCost = recursive(matrices, i, k);
					int rightCost = recursive(matrices, k + 1, j);
					int prodCost = matrices[i].r * matrices[k].c * matrices[j].c;
					min = Math.min(min, leftCost + rightCost + prodCost);
				}
				mem.put(currentKey, min);
			}
		}
		return mem.get(currentKey);
	}
	
	public static int bottomUp(final M[] matrices) {
		int n = matrices.length;
		int[][] table = new int[n][n];
		
		for (int d = 1; d < n; d++) {
			for (int i = 0; i < n - d; i++) {
				int j = i+d;
				int min = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int left = table[i][k];
					int right = table[k+1][j];
					int prodCost = matrices[i].r * matrices[k].c * matrices[j].c;
					min = Math.min(min, left+right+prodCost);
				}
				table[i][j] = min;
			}
		}
		
		return table[0][n-1];
	}
}
