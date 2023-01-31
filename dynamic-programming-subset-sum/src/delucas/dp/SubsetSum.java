package delucas.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import delucas.utils.Pair;

public class SubsetSum {

	public static int recursive(final int[] arr, final int k, final int i) {
		if (k == 0)
			return 1;
		if (k < 0 || i == arr.length)
			return 0;

		return recursive(arr, k - arr[i], i + 1)
				+ recursive(arr, k, i + 1);
	}
	
	public static int topDown(final int[] arr, final int k, final int i) {
		return topDown(arr, k, i, new HashMap<Pair, Integer>());
	}
	
	public static int topDown(final int[] arr, final int k, final int i, final Map<Pair, Integer> mem) {
		Pair currentKey = new Pair(k, i);
		
		if (!mem.containsKey(currentKey)) {
			if (k == 0)
				mem.put(currentKey, 1);
			else if (k < 0 || i == arr.length)
				mem.put(currentKey, 0);
			else
				mem.put(currentKey, topDown(arr, k - arr[i], i + 1, mem)
					+ topDown(arr, k, i + 1, mem));
		}
		return mem.get(currentKey);
	}
	
	
	public static int bottomUp(final int[] arr, final int k, final int idx) {
		int n = arr.length;

		// early returns
		if (k == 0)
			return 0;
		// if (k > arr.sum) return 0;

		int[][] table = new int[n][k + 1];

		table[0][0] = 1;
		if (arr[0] <= k)
			table[0][arr[0]] = 1;

		for (int i = 1; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				table[i][j] = table[i - 1][j];
				if (j >= arr[i])
					table[i][j] += table[i-1][j-arr[i]];
			}
		}

		return table[n - 1][k];
	}
	
	public static int optimizedBottomUp(final int[] arr, final int k, final int idx) {
		int n = arr.length;

		// early returns
		if (k == 0)
			return 0;
		// if (k > arr.sum) return 0;

		int[][] table = new int[2][k + 1];

		table[0][0] = 1;
		if (arr[0] <= k)
			table[0][arr[0]] = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < table[0].length; j++) {
				table[1][j] = table[0][j];
				if (j >= arr[i])
					table[1][j] += table[0][j-arr[i]];
			}
			table[0] = Arrays.copyOf(table[1], table[1].length);
		}

		return table[1][k];
	}
}
