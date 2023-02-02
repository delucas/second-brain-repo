package delucas.dp;

import java.util.HashMap;

import delucas.utils.MyMath;

public class LongestIncreasingSubsequence {
	
	public static int recursive(final int[] arr) {
		return recursive(arr, 0, Integer.MIN_VALUE);
	}
	
	private static int recursive(final int[] arr, final int idx, final int last) {
		if (idx == arr.length) return 0;
		
		if (arr[idx] > last)
			return Math.max(1 + recursive(arr, idx+1, arr[idx]), recursive(arr, idx+1, last));
		
		return recursive(arr, idx+1, last);
	}
	
	public static int optimizedRecursive(final int[] arr) {
		int[] res = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++)
			res[i] = optimizedRecursive(arr, i);

		return MyMath.max(res);
	}

	private static int optimizedRecursive(final int[] arr, final int i) {
		int max = 0;
		for (int j = i + 1; j < arr.length; j++)
			if (arr[j] > arr[i])
				max = Math.max(max, optimizedRecursive(arr, j));

		return 1 + max;
	}

	public static int topDown(final int[] arr) {
		int[] res = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++)
			res[i] = topDown(arr, i, new HashMap<Integer, Integer>());

		return MyMath.max(res);
	}

	private static int topDown(final int[] arr, final int i, final HashMap<Integer, Integer> mem) {
		if (!mem.containsKey(i)) {
			int max = 0;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j] > arr[i])
					max = Math.max(max, topDown(arr, j, mem));
			mem.put(i, 1 + max);
		}
		return mem.get(i);
	}

	public static int bottomUp(final int[] arr) {
		int n = arr.length;
		int[] table = new int[n];
		table[0] = 1;
		
		for (int i = 1; i < n; i++) {
			int max = 0;
			for (int j = i; j >= 0; j--) {
				if (arr[j] < arr[i])
					max = Math.max(max, table[j]);
			}
			table[i] = 1 + max;
		}
		return table[n-1];
	}
	
}
