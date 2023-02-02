package delucas.dp;

import delucas.utils.MyMath;

public class Partition {

	public static boolean recursive(final int[] arr) {
		return recursive(arr, 0, 0, 0);
	}

	private static boolean recursive(final int[] arr, final int idx, final int left, final int right) {
		if (idx == arr.length)
			return left == right;
		
		return recursive(arr, idx+1, left + arr[idx], right) ||
				recursive(arr, idx+1, left, right+arr[idx]);
	}
	
	public static boolean reusing(final int[] arr) {
		int sum = MyMath.sum(arr);
		if (sum % 2 == 1) {
			return false;
		} else {
			return SubsetSum.optimizedBottomUp(arr, sum / 2, 0) > 0;
		}
	}
}
