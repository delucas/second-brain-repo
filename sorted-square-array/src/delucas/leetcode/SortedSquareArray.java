package delucas.leetcode;

import java.util.Arrays;
import java.util.TreeMap;

public class SortedSquareArray {

	public static int[] naive(int[] input) {
		int[] output = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			output[i] = input[i] * input[i];
		}
		Arrays.sort(output);
		return output;
	}

	public static int[] withMemory(int[] input) {
		int[] output = new int[input.length];
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < input.length; i++) {
			int sq = input[i] * input[i];
			map.put(sq, map.getOrDefault(sq, 0) + 1);
		}
		int i = 0;
		for (Integer val : map.keySet()) {
			for(int j = 0; j < map.get(val); j++) {
				output[i++] = val;
			}
		}
		return output;
	}

	public static int[] outsideIn(int[] input) {
		int[] output = new int[input.length];
		int i = 0, j = input.length-1, k = input.length - 1;
		while (i<=j) {
			if (Math.abs(input[i]) > Math.abs(input[j])) {
				output[k] = input[i] * input[i];
				i++;
			} else {
				output[k] = input[j] * input[j];
				j--;
			}
			k--;
		}
		return output;
	}

}
