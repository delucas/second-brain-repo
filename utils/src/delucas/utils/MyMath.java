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
	
	public static int sum(final int[] xs) {
		int sum = 0;
		for (int i = 0; i < xs.length; i++) {
			sum += xs[i];
		}
		return sum;
	}
	
	public static boolean between(int number, int low, int high) {
		return low <= number && number <= high;
	}
	
	public static int fact(final int n) {
		int res = 1;
		for(int i = 1; i <= n; i++) {
			res *= i;
		}
		return res;
	}
}
