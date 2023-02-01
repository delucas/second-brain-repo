package delucas.utils;

public class MyMath {
	public static int max(final int[] xs) {
		int max = xs[0];
		for (int i = 1; i < xs.length; i++) {
			max = Math.max(xs[i], max);
		}
		return max;
	}

	public static int min(final int[] xs) {
		int min = xs[0];
		for (int i = 1; i < xs.length; i++) {
			min = Math.min(xs[i], min);
		}
		return min;
	}
	
	public static boolean between(int number, int low, int high) {
		return low <= number && number <= high;
	}
}
