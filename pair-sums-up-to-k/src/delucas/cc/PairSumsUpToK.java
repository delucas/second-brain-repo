package delucas.cc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairSumsUpToK {

	public static boolean solution1(int[] arr, int k) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == k)
					return true;
			}
		}
		return false;
	}

	public static boolean solution2(int[] arr, int k) {
		Arrays.sort(arr);
		int left = 0, right = arr.length - 1;

		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum == k)
				return true;
			else if (sum < k)
				left++;
			else
				right--;
		}
		return false;
	}

	public static boolean solution3(int[] arr, int k) {
		Set<Integer> mem = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (mem.contains(k - arr[i]))
				return true;
			else 
				mem.add(arr[i]);
		}
		return false;
	}
}
