package delucas.dp;

import java.util.HashMap;
import java.util.Map;

import delucas.utils.MyMath;
import delucas.utils.Pair;

public class StonePile {

	public static int recursive(final int[] stones) {
		return recursive(stones, 0, 0);
	}

	private static int recursive(final int[] stones, final int idx, final int balance) {
		if (idx == stones.length)
			return Math.abs(balance);
		else
			return Math.min(recursive(stones, idx + 1, balance - stones[idx]),
					recursive(stones, idx + 1, balance + stones[idx]));
	}

	public static int topDown(final int[] stones) {
		return topDown(stones, 0, 0, new HashMap<Pair, Integer>());
	}

	private static int topDown(final int[] stones, final int idx, final int balance, final Map<Pair, Integer> mem) {
		Pair currentKey = new Pair(idx, balance);
		if (!mem.containsKey(currentKey)) {
			if (idx == stones.length)
				mem.put(currentKey, Math.abs(balance));
			else
				mem.put(currentKey, Math.min(recursive(stones, idx + 1, balance - stones[idx]),
						recursive(stones, idx + 1, balance + stones[idx])));
		}
		return mem.get(currentKey);
	}

	public static int bottomUp(final int[] stones) {
		int totalWeight = MyMath.sum(stones);
		int average = totalWeight / 2;

		int[] table = new int[average + 1];

		for (int i = 0; i < stones.length; i++) {
			int stone = stones[i];
			for (int j = average; j >= stone; j--) {
				// Intento mejorar el peso para una posición dada, utilizando
				// la piedra actual en lugar de la piedra que seleccioné en j-stone
				table[j] = Math.max(table[j], table[j - stone] + stone);
			}
		}
		// Del mejor peso que conseguí para la mitad del peso total,
		// calculo su aproximación al total.
		return Math.abs(2 * table[average] - totalWeight);
	}
}
