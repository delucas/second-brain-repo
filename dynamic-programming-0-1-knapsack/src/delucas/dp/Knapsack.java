package delucas.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import delucas.utils.Pair;

public class Knapsack {

	public static int recursive(final int[] values, final int[] weights, final int remainingWeight, final int index) {
		if (index == values.length)
			return 0;
		int max = recursive(values, weights, remainingWeight, index + 1);

		if (weights[index] <= remainingWeight)
			max = Math.max(max, values[index] + recursive(values, weights, remainingWeight - weights[index], index + 1));

		return max;
	}
	
	public static int topDown(final int[] values, final int[] weights, final int remainingWeight, final int index) {
		return topDown(values, weights, remainingWeight, index, new HashMap<Pair, Integer>());
	}
	
	public static int topDown(final int[] values, final int[] weights, final int remainingWeight, final int index, final Map<Pair, Integer> mem) {
		Pair currentKey = new Pair(remainingWeight, index);
		
		if (!mem.containsKey(currentKey)) {
			if (index == values.length) {
				mem.put(currentKey, 0);
			} else {
				int max = topDown(values, weights, remainingWeight, index + 1, mem);
		
				if (weights[index] <= remainingWeight)
					max = Math.max(max, values[index] + topDown(values, weights, remainingWeight - weights[index], index + 1, mem));
				mem.put(currentKey, max);
			}
		}
		return mem.get(currentKey);
	}

	public static int bottomUp(final int[] values, final int[] weights, final int remainingWeight, final int index) {
		int n = weights.length;
		int k = remainingWeight;
		
		// early returns
		if (k == 0) return 0;
		// if (k > weights.sum) return values.sum;
		
		int[][] table = new int[n][k+1];
		
		for (int j = weights[0]; j < k+1; j++)
			table[0][j] = values[0];
		
		for (int i = 1; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				if (weights[i] > j)
					table[i][j] = table[i-1][j];
				else
					table[i][j] = Math.max(table[i-1][j], values[i] + table[i-1][j-weights[i]]);
			}
		}
		
		
		return table[n-1][k];
	}
	
	public static int optimizedBottomUp(final int[] values, final int[] weights, final int remainingWeight, final int index) {
		int n = weights.length;
		int k = remainingWeight;
		
		// early returns
		if (k == 0) return 0;
		// if (k > weights.sum) return values.sum;
		
		int[][] table = new int[2][k+1];
		
		for (int j = weights[0]; j < k+1; j++)
			table[0][j] = values[0];
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < table[0].length; j++) {
				if (weights[i] > j)
					table[1][j] = table[0][j];
				else
					table[1][j] = Math.max(table[0][j], values[i] + table[0][j-weights[i]]);
			}
			table[0] = Arrays.copyOf(table[1], table[1].length);
		}
		return table[1][k];
	}
	
}
