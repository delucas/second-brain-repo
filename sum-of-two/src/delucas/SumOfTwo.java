package delucas;

import java.util.HashSet;

public class SumOfTwo {

	public static boolean bruteForce(int[] a, int[] b, int v) {
		for (int i : a) {
			// cuesta menos que preguntar con la resta
			int needed = v - i;
			for (int j : b) {
				if (j == needed)
					return true;
			}
		}
		return false;
	}

	public static boolean usingSet(int[] a, int[] b, int v) {
		HashSet<Integer> complementos = new HashSet<Integer>();
		for (Integer elem : a) {
			complementos.add(v - elem);
		}

		for (Integer elem : b) {
			if (complementos.contains(elem))
				return true;
		}
		return false;
	}
}
